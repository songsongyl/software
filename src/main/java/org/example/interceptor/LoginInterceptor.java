package org.example.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.exception.XException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getHeader("role") == null || request.getHeader("uid") == null) {
            throw new XException("未登录");
        }
        int role = Integer.parseInt(request.getHeader("role"));
        String uid = request.getHeader("uid");
        request.setAttribute("role", role);
        request.setAttribute("uid", uid);
        return true;
    }
}
