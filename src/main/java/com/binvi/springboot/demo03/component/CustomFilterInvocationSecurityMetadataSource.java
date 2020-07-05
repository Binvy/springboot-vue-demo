package com.binvi.springboot.demo03.component;

import com.binvi.springboot.demo03.entity.Pattern;
import com.binvi.springboot.demo03.entity.Role;
import com.binvi.springboot.demo03.repository.PatternDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description: 权限动态配置
 * @date 2019/6/15 22:08
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private PatternDao patternDao;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<Pattern> patterns = patternDao.findAll();
        if (!CollectionUtils.isEmpty(patterns)) {
            for (Pattern pattern : patterns) {
                if (antPathMatcher.match(pattern.getPattern(), requestUrl)) {
                    List<Role> roles = pattern.getRoles();
                    if (!CollectionUtils.isEmpty(roles)) {
                        String[] roleArray = new String[roles.size()];
                        for (int i = 0, length = roles.size(); i < length; i++) {
                            roleArray[i] = roles.get(i).getName();
                        }
                        return SecurityConfig.createList(roleArray);
                    }
                }
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
