package com.binvi.springboot.demo03.config;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/16 22:25
 */
//@Configuration
/*public class ShiroConfig {

    @Bean
    public Realm realm() {
        TextConfigurationRealm realm = new TextConfigurationRealm();
        realm.setUserDefinitions("binvi=binvi, user\n admin=admin, admin");
        realm.setRoleDefinitions("admin=read, write\n user=read");
        return realm;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition("/login", "anon");
        definition.addPathDefinition("/doLogin", "anon");
        definition.addPathDefinition("/logout", "logout");
        definition.addPathDefinition("/**", "authc");
        return definition;
    }

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}*/
