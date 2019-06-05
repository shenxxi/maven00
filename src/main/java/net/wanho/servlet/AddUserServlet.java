package net.wanho.servlet;

import net.wanho.entity.User;
import net.wanho.service.UserServiceI;
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

/**
 * Created by SX on 2019/6/2.
 */
@WebServlet("/AddUser")
@Controller
public class AddUserServlet extends HttpServlet {
    private UserServiceI userServiceI;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        userServiceI=ctx.getBean(UserServiceI.class);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            userServiceI.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("user?method=showUser");
    }
}
