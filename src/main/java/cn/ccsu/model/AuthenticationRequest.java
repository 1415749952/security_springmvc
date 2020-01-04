package cn.ccsu.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 用户认证请求参数
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-01-04
 * @Time: 16:17
 */
@Data
public class AuthenticationRequest
{
    private String loginName;
    private String password;
}
