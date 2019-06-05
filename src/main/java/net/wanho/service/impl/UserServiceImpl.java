package net.wanho.service.impl;

import net.wanho.entity.User;
import net.wanho.dao.impl.UserDaoImpl;
import net.wanho.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/5/24.
 */
@Service
public class UserServiceImpl implements UserServiceI{
    @Autowired
    private UserDaoImpl userDao;
    public List<User> findAll(){
        return userDao.selectAll();
    }
    public void addUser(User user) throws Exception {
        userDao.insertUser(user);
    }
    public void updateUser(User user) throws Exception {
        userDao.updateUser(user);
    }
    public void removeUser(int id) throws Exception {
        userDao.deleteUser(id);
    }

    @Override
    public User selectUserById(int id) throws Exception {
        return userDao.selectUserById(id);
    }

    @Override
    public User login(String username, String password) throws Exception {
        return userDao.selectUserByUsernameAndPassword(username,password);
    }
}
