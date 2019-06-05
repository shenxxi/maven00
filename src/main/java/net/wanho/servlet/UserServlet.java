package net.wanho.servlet;

import net.wanho.entity.User;
import net.wanho.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Administrator on 2019/5/29.
 */
@WebServlet("/user")
@Controller
public class UserServlet extends HttpServlet {
    @Autowired
    private UserServiceI userServiceI;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String methodName = request.getParameter("method");

        try {
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public  void init()throws ServletException{
        ServletContext servletContext = getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        userServiceI=ctx.getBean(UserServiceI.class);

    }

    protected void showUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = userServiceI.findAll();
        request.setAttribute("users",users);
        request.getRequestDispatcher("user.jsp").forward(request,response);
    }

    protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        try {
            userServiceI.removeUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("user?method=showUser");
    }

    protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        try {
            User user = userServiceI.selectUserById(id);
            request.setAttribute("user",user);
            request.getRequestDispatcher("updateUser.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    }
