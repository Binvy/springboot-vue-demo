package com.binvi.springboot.demo03.component;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/15 22:25
 */
@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication,
                       Object object,
                       Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (!CollectionUtils.isEmpty(configAttributes)) {
            for (ConfigAttribute attribute : configAttributes) {
                if (StringUtils.equals("ROLE_LOGIN", attribute.getAttribute())
                        && authentication instanceof UsernamePasswordAuthenticationToken) {
                    return;
                }
                if (!CollectionUtils.isEmpty(authorities)) {
                    for (GrantedAuthority authority : authorities) {
                        if (StringUtils.equals(attribute.getAttribute(), authority.getAuthority())) {
                            return;
                        }
                    }
                }
            }
        }
        throw new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
