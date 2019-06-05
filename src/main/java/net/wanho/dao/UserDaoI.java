package net.wanho.dao;

import net.wanho.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2019/5/28.
 */
public interface UserDaoI {

    List<User> selectAll();

    void insertUser(User user) throws Exception;

    void updateUser(User user) throws Exception;

    void deleteUser(int id) throws Exception;

    User selectUserById(int id) throws Exception;

    User selectUserByUsernameAndPassword(String username,String password) throws Exception;
}

