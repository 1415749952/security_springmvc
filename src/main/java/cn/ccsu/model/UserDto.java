package cn.ccsu.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:用户身份信息
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-01-04
 * @Time: 16:17
 */
@Data
@AllArgsConstructor//构造方法所有的参数
public class UserDto
{
    private Integer id;
    private String loginName;
    private String password;
    private String name;
    private String phone;

    private Set<String> authorities;
}
