package com.test;

import com.domain.Account;
import com.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestSpring
 * @Description TODO
 * @Auther Google
 * @Date 2019/4/23 8:12
 * @Version 1.0
 */
public class TestSpring {

    @Test
    public void run1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService accountService = (AccountService) applicationContext.getBean("accountService");

        accountService.findAll();
    }
}
