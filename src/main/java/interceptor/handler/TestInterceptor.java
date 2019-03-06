package interceptor.handler;

import bean.ResultInfo;
import lombok.Setter;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Setter
public class TestInterceptor implements HandlerInterceptor {

    private ResultInfo resultInfo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uid = request.getParameter("uid");
        return true;
    }
}
