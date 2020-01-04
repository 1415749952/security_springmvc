package cn.ccsu.service.impl;

import cn.ccsu.model.AuthenticationRequest;
import cn.ccsu.model.UserDto;
import cn.ccsu.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-01-04
 * @Time: 16:21
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService
{
    private Map<String, UserDto> userMap = new HashMap<>();

    /**
     * 静态代码块，初始化用户信息，相当于从数据库中查询出来的结果
     */
    {
        Set<String> authorities1 = new HashSet<>();
        Set<String> authorities2 = new HashSet<>();
        authorities1.add("p1");
        authorities1.add("p2");
        userMap.put("zhangsan", new UserDto(1001, "zhangsan", "123", "张三", "18390869224",authorities1));
        userMap.put("lisi", new UserDto(1002, "lisi", "456", "李四", "18390869220",authorities2));
    }


    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest)
    {
        if (authenticationRequest == null || StringUtils.isEmpty(authenticationRequest.getLoginName()) || StringUtils.isEmpty(authenticationRequest.getPassword()))
        {
            throw new RuntimeException("账号或者密码为空");
        }

        //模拟数据库查询
        UserDto userDto = getUserDto(authenticationRequest.getLoginName());
        //判断用户是否为空
        if (userDto == null)
        {
            throw new RuntimeException("查询不到用户");
        }
        if (!authenticationRequest.getPassword().equals(userDto.getPassword()))
        {
            throw new RuntimeException("账号或者密码错误");
        }

        return userDto;
    }

    /**
     * 模拟从数据查询用户信息（根据登录名来查询用户）
     *
     * @param loginName
     * @return
     */
    private UserDto getUserDto(String loginName)
    {
        return userMap.get(loginName);
    }
}
