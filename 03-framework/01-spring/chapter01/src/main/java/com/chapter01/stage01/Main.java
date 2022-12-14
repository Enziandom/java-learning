package com.chapter01.stage01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/stage01/application.xml");
    UserDao userDao = (UserDao) context.getBean("userDao");
    userDao.say();
  }

}
