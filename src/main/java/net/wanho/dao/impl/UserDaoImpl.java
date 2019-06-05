package net.wanho.dao.impl;

import net.wanho.dao.UserDaoI;
import net.wanho.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/24.
 */

@Repository
public class UserDaoImpl implements UserDaoI{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> selectAll() {

        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);

        List<User> list = jdbcTemplate.query("select * from user",rowMapper);
        return list;

    }


    public void insertUser(User user) throws Exception {


        jdbcTemplate.update("INSERT INTO USER (username,password) VALUES (?,?)",user.getUsername(),user.getPassword());

    }

    public void updateUser(User user) throws Exception {


        jdbcTemplate.update("UPDATE USER set username = ?,password = ? WHERE id = ?",user.getUsername(),user.getPassword(),user.getId());

    }

    public void deleteUser(int id) throws Exception {


        jdbcTemplate.update("DELETE FROM USER WHERE id = ?",id);

    }

    @Override
    public User selectUserById(int id) throws Exception {

        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);

        List<User> list = jdbcTemplate.query("select * from user WHERE id = ?",rowMapper,id);
        return list.size()==0?null:list.get(0);
    }

    @Override
    public User selectUserByUsernameAndPassword(String username, String password) throws Exception {
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> list = jdbcTemplate.query("select * from user where username = ? and password = ?", rowMapper, username, password);
        return list.size()==0?null:list.get(0);
    }
}
