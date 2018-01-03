package com.boot.edu.healthcare;/**
 * @author Sergey Zhernovoy
 * create on 03.01.2018.
 */

import com.boot.edu.healthcare.interceptors.SignupInterceptors;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SignupInterceptors())
                .addPathPatterns("/account/signup/process");
    }


    @Bean(name = "dataSource")
    public DataSource getDataSource(){
        return DataSourceBuilder
                .create()
                .username(username)
                .password(password)
                .url(url)
                .driverClassName(driverClassName)
                .build();

    }

    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(@Qualifier("dataSource") DataSource dataSource){
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.scanPackages("com.boot.edu.healthcare.domain");
        return sessionBuilder.buildSessionFactory();
    }

}

    