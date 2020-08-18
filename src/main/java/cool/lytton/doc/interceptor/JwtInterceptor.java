package cool.lytton.doc.interceptor;

import cool.lytton.doc.annotation.JwtToken;
import cool.lytton.doc.exception.exceptions.TokenException;
import cool.lytton.doc.util.JwtUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 不是映射到方法？
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        // 检查有需要用户权限的注解
        if(method.isAnnotationPresent(JwtToken.class)) {
            JwtToken jwtToken = method.getAnnotation(JwtToken.class);
            if(jwtToken.required()) {
//                System.out.print(request.getHeader("Authorization"));
                String token = request.getHeader("Authorization").split(" ")[1];
                System.out.print(token);
                if(token == null) {
//                    throw new RuntimeException("无效的token");
                    throw new TokenException("token不存在");
                }
//                String username = JwtUtil.getUsername(token);
                // 需要的话可以签名时传入role等属性做权限管理验证
//                System.out.printf(username);
                JwtUtil.checkToken(token);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
