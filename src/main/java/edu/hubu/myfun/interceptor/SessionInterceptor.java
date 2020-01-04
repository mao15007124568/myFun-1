package edu.hubu.myfun.interceptor;

import edu.hubu.myfun.exception.CustomizeErrorCode;
import edu.hubu.myfun.exception.CustomizeException;
import edu.hubu.myfun.pojo.User;
import edu.hubu.myfun.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class SessionInterceptor implements HandlerInterceptor {


    @Autowired
    NotificationService notificationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws  Exception{
        System.out.println("enter interceptor");
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            throw  new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
        int notificationCount = notificationService.getNotificationCount(user);
System.out.println(notificationCount);
        request.getSession().setAttribute("notificationCount", notificationCount);
        return true;
    }
}
