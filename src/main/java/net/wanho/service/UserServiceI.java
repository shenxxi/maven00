package net.wanho.service;

import net.wanho.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2019/5/28.
 */
public interface UserServiceI {

    List<User> findAll();

    void addUser(User user) throws Exception;

    void updateUser(User user) throws Exception;

    void removeUser(int id) throws Exception;

    User selectUserById(int id) throws Exception;

    User login(String username,String password) throws Exception;
}
