package cn.ccsu.interceptor;

import cn.ccsu.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:拦截器
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-01-04
 * @Time: 19:30
 */
@Component
public class SimpleAuthenticaltionInterceptor implements HandlerInterceptor
{
    /**
     * preHandle调用方法之前拦截请求
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        /*
        这个方法校验用户请求的url是否在用户的权限范围内
         */

        Object user = request.getSession().getAttribute("user");
        if (user == null)
        {
            writeContent(response, "请登录");
        }
        else
        {
            UserDto userDto = (UserDto) user;
            String requestURL = new String(request.getRequestURL());
            if (userDto.getAuthorities().contains("p1") && requestURL.contains("/r/r1"))
            {
                return true;
            }
            if (userDto.getAuthorities().contains("p2") && requestURL.equals("/r/r2"))
            {
                return true;
            }
            writeContent(response, "没有权限");
        }
        return false;
    }

    /**
     * 响应信息给客户端
     *
     * @param response
     * @param msg
     */
    private void writeContent(HttpServletResponse response, String msg)
    {
        PrintWriter writer = null;
        try
        {
            response.setContentType("text/html;charset=UTF-8");
            writer = response.getWriter();

            writer.print(msg);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            writer.close();
            //response.resetBuffer();
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {

    }
}
