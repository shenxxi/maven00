package net.wanho.controller;

import net.wanho.entity.User;
import net.wanho.service.UserServiceI;
import net.wanho.service.impl.UserServiceImpl;
import net.wanho.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by SX on 2019/6/2.
 */
@Controller
public class UserController {
    @Autowired
    private UserServiceI userServiceI;

    @RequestMapping("showUser")
    public String showUser(Map map) {
        List<User> users = userServiceI.findAll();
        map.put("users", users);
        return "user";
    }

    @RequestMapping(value = "del")
    public String delUser(int id) {
        try {
            userServiceI.removeUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:showUser";
    }

    @RequestMapping("selectUser")
    public String selectUser(int id, Map map) {
        User user = null;
        try {
            user = userServiceI.selectUserById(id);
            map.put("user", user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "updateUser";
    }

    @RequestMapping("updateUser")
    public String updateUser(User user) {
        try {
            userServiceI.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:showUser";
    }

    @RequestMapping("addUser")
    public String addUser(User user) {
        try {
            userServiceI.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:showUser";
    }

    @RequestMapping("add")
    public String add() {
        return "addUser";
    }


    @RequestMapping("log")
    public String login(String username, String password, String remember, HttpServletRequest request, HttpServletResponse response) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            try {
                user = userServiceI.login(username, password);

                if ("ok".equals(remember)) {
                    Cookie cookie = new Cookie("record", username + "-" + password);
                    cookie.setPath(request.getContextPath() + "/");
                    cookie.setMaxAge(3600 * 24 * 5);
                    response.addCookie(cookie);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        request.getSession().setAttribute("user", user);
        return "success";
    }


}
