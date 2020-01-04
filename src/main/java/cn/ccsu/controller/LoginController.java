package cn.ccsu.controller;

import cn.ccsu.model.AuthenticationRequest;
import cn.ccsu.model.UserDto;
import cn.ccsu.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-01-04
 * @Time: 16:42
 */
@RestController
public class LoginController
{
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login", produces = {"text/plain;charset=UTF-8"})
    public String login(AuthenticationRequest authenticationRequest, HttpSession session)
    {
        UserDto authenticationUser = authenticationService.authentication(authenticationRequest);
        session.setAttribute("user", authenticationUser);
        return authenticationUser.getLoginName() + "登录成功ww";
    }

    @RequestMapping(value = "/logout", produces = {"text/plain;charset=UTF-8"})
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "退出成功";
    }


    @RequestMapping(value = "/r/r1", produces = {"text/plain;charset=UTF-8"})
    public String r1(HttpSession session)
    {
        Object user = session.getAttribute("user");
        UserDto userDto = null;
        if (user == null)
        {
            return "匿名访问";
        }
        else
        {
            userDto = (UserDto) user;
        }
        return userDto.getName() + "访问资源r1";
    }
    @RequestMapping(value = "/r/r2", produces = {"text/plain;charset=UTF-8"})
    public String r2(HttpSession session)
    {
        Object user = session.getAttribute("user");
        UserDto userDto = null;
        if (user == null)
        {
            return "匿名访问";
        }
        else
        {
            userDto = (UserDto) user;
        }
        return userDto.getName() + "访问资源r2";
    }

}
