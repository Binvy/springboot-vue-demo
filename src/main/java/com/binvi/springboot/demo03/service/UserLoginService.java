package com.binvi.springboot.demo03.service;

import com.binvi.springboot.demo03.entity.UserLogin;
import com.binvi.springboot.demo03.entity.UserRole;
import com.binvi.springboot.demo03.repository.RoleDao;
import com.binvi.springboot.demo03.repository.UserLoginDao;
import com.binvi.springboot.demo03.repository.UserRoleDao;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/15 20:36
 */
@Service
public class UserLoginService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserLoginService.class);

    @Autowired
    private UserLoginDao userLoginDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("UserLoginService loadUserByUsername start");
        UserLogin user = userLoginDao.findByUsername(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("账户不存在！");
        }
        List<UserRole> userRoles = userRoleDao.getAllByUserIdEquals(user.getId());
        List<String> roleIds = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(userRoles)) {
            userRoles.forEach((userRole)-> roleIds.add(userRole.getRoleId()));
            user.setRoles(roleDao.findAllById(roleIds));
        }
        return user;
    }

}
