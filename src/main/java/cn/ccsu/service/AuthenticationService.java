package cn.ccsu.service;

import cn.ccsu.model.AuthenticationRequest;
import cn.ccsu.model.UserDto;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-01-04
 * @Time: 16:14
 */
public interface AuthenticationService
{
    /**
     * 用户认证
     * @param authenticationRequest 用户认证请求账号密码
     * @return
     */
    public UserDto authentication(AuthenticationRequest authenticationRequest);
}
