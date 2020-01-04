package cn.ccsu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * Description:spring 容器配置类，相当于sping的applicationContext.xml配置文件。
 * 除了controller的其他bean，比如数据库连接池，事务管理，业务bean等
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-01-04
 * @Time: 15:31
 */
//注解是一个配置文件
@Configuration
// 指定扫描的包，排除controller注解的类
@ComponentScan(basePackages = "cn.ccsu", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationConfig
{

}
