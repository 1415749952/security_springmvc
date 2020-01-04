package cn.ccsu.config;

import cn.ccsu.interceptor.SimpleAuthenticaltionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 相当于springmvc配置文件dispatcher-servlet.xml
 * 配置视图解析器
 *
 * @version 1.0
 * @author: TheFei
 * @Date: 2020-01-04
 * @Time: 15:40
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "cn.ccsu", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class WebConfig implements WebMvcConfigurer
{
    @Autowired
    private SimpleAuthenticaltionInterceptor simpleAuthenticaltionInterceptor;


    /**
     * 配置视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry)
    {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
    {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters)
    {

    }

    @Override
    public Validator getValidator()
    {
        return null;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer)
    {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer)
    {

    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer)
    {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers)
    {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers)
    {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers)
    {

    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        //添加自己的拦截器
        registry.addInterceptor(simpleAuthenticaltionInterceptor).addPathPatterns("/r/**");
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver()
    {
        return null;
    }

    /**
     * 配置根视图，项目一打开就跳到登录页面login.jsp
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("login");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry)
    {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry)
    {

    }
}
