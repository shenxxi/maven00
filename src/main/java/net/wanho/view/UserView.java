package net.wanho.view;

import net.wanho.entity.User;
import net.wanho.service.UserServiceI;
import net.wanho.service.impl.UserServiceImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2019/5/24.
 */
public class UserView {
    public static void main(String[] args) throws Exception {

        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceI userServiceImpl = (UserServiceI) ctx.getBean("userServiceImpl");
        List<User> list = userServiceImpl.findAll();
        System.out.println(list);

        /*User user1 = (User) ctx.getBean("user1");
        userServiceImpl.addUser(user1);*//*

        User user2 = (User) ctx.getBean("user2");
        userServiceImpl.updateUser(user2);*/

        userServiceImpl.removeUser(13);


    }
}
