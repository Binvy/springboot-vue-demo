package com.binvi.springboot.demo03.repository;

import com.binvi.springboot.demo03.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/15 20:37
 */
@Repository
public interface UserLoginDao extends JpaRepository<UserLogin, String> {

    UserLogin findByUsername(String name);

}
