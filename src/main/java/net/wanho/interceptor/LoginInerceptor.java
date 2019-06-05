package net.wanho.interceptor;

import net.wanho.entity.User;
import net.wanho.service.UserServiceI;
import net.wanho.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Administrator on 2019/6/4.
 */
@Controller
public class LoginInerceptor implements HandlerInterceptor {
    @Autowired
    private UserServiceI userServiceI;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println(123);
      /*  User user1 = (User) request.getSession().getAttribute("user");
        if (user1==null){
            Cookie cookie = CookieUtils.getCookieByName("record",request.getCookies());
            if(cookie!=null){
                String username = cookie.getValue().split("-")[0];
                String password = cookie.getValue().split("-")[1];
                User user = userServiceI.login(username,password);
                System.out.println(user);
                request.getSession().setAttribute("user",user);
            }
            else {
                response.sendRedirect("login.jsp");
            }
        }*/
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
