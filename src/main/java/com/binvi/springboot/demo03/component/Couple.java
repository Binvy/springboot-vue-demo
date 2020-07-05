package com.binvi.springboot.demo03.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/5/30 0:57
 */
@Component
@ConfigurationProperties(prefix = "couple")
public class Couple {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Couple)) return false;

        Couple couple = (Couple) o;

        return getUsers() != null ? getUsers().equals(couple.getUsers()) : couple.getUsers() == null;
    }

    @Override
    public int hashCode() {
        return getUsers() != null ? getUsers().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Couple{" +
                "users=" + users +
                '}';
    }
}
