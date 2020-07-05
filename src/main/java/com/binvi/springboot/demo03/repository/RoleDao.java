package com.binvi.springboot.demo03.repository;

import com.binvi.springboot.demo03.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/15 20:41
 */
@Repository
public interface RoleDao extends JpaRepository<Role, String> {

}
