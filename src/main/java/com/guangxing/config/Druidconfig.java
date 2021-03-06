package com.guangxing.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Druid配置类
 * @author apple
 * @create time 2020/4/22 10:29 上午
 **/
@Configuration
public class Druidconfig {

    @ConfigurationProperties(prefix = "spring.datasource",ignoreInvalidFields = true)
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置Druid的监控
    //1、配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        Map<String,String> initParame = new HashMap<String,String>();
        registrationBean.setInitParameters(initParame);
        initParame.put("loginUsername", "admin");
        initParame.put("loginPassword", "123456");
        //IP白名单
        initParame.put("allow", "");//默认就是允许所有访问
        //IP黑名单（共同存在时，deny,优于allow）
        initParame.put("deny", "127.0.0.1");
        registrationBean.setInitParameters(initParame);
        return registrationBean;
    }

    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String,String> initParam = new HashMap();
        initParam.put("exclusions", "*.js,*.css,*.jpg,*.css,*.gif,/druid/*");
        filterRegistrationBean.setInitParameters(initParam);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }
}
