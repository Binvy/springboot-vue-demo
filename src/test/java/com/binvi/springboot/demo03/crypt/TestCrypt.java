package com.binvi.springboot.demo03.crypt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/15 16:42
 */
@RunWith(SpringRunner.class)
//@SpringBootTest
public class TestCrypt {

    public static final Logger logger = LoggerFactory.getLogger(TestCrypt.class);

    @Test
    public void testCrypt() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String root = passwordEncoder.encode("root");
        String admin = passwordEncoder.encode("admin");
        String binvi = passwordEncoder.encode("binvi");
        String password = passwordEncoder.encode("password");
        String refresh_token = passwordEncoder.encode("refresh_token");
        String password123 = passwordEncoder.encode("123");
        logger.info("root:[{}]", root);
        logger.info("admin:[{}]", admin);
        logger.info("binvi:[{}]", binvi);
        logger.info("password:[{}]", password);
        logger.info("password123:[{}]", password123);
        logger.info("refresh_token:[{}]", refresh_token);

    }

}
