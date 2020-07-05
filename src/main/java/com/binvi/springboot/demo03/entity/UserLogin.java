package com.binvi.springboot.demo03.entity;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/15 20:02
 */
@Data
@Entity(name = "user_login")
public class UserLogin implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    private String username;
    private String password;
    private String enable;
    private String locked;
    private String accountExpired;
    private String credentialsExpired;
    private Date logonTime;
    private Date updateTime;
    private Date lastLoginTime;
    private String lastLoginIp;
    private String loginErrorTimes;
    private String logonWay;
    private String phone;
    private String email;
    private String remark;

    @Transient
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> authorities = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(roles)) {
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return StringUtils.equals("1", accountExpired);
    }

    @Override
    public boolean isAccountNonLocked() {
        return StringUtils.equals("1", locked);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return StringUtils.equals("1", credentialsExpired);
    }

    @Override
    public boolean isEnabled() {
        return StringUtils.equals("1", enable);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(String accountExpired) {
        this.accountExpired = accountExpired;
    }

    public String getCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(String credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public Date getLogonTime() {
        return logonTime;
    }

    public void setLogonTime(Date logonTime) {
        this.logonTime = logonTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLoginErrorTimes() {
        return loginErrorTimes;
    }

    public void setLoginErrorTimes(String loginErrorTimes) {
        this.loginErrorTimes = loginErrorTimes;
    }

    public String getLogonWay() {
        return logonWay;
    }

    public void setLogonWay(String logonWay) {
        this.logonWay = logonWay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
