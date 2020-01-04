package cn.ccsu.init;

import cn.ccsu.config.ApplicationConfig;
import cn.ccsu.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created with IntelliJ IDEA.
 * Description: 相当于web.xml配置文件
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-01-04
 * @Time: 15:55
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    /**
     * 相当于加载spring的配置文件applicationContext.xml
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[]{ApplicationConfig.class};
    }

    /**
     * 相当于加载springmvc配置文件dispatcher-servlet.xml
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[]{WebConfig.class};
    }

    /**
     * url-mapping
     *
     * @return
     */
    @Override
    protected String[] getServletMappings()
    {
        return new String[]{"/"};
    }
}
