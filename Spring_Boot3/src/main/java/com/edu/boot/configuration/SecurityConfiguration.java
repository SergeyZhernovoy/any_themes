package com.edu.boot.configuration;/**
 * @author Sergey Zhernovoy
 * create on 22.01.2018.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.sql.ResultSet;

@Configuration
@EnableGlobalAuthentication
public class SecurityConfiguration extends GlobalAuthenticationConfigurerAdapter{
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

    @Autowired
    private UserDetailsService userDetailsService;

    /**для безопасности в памяти */
    //    @Autowired
    //    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //        auth.inMemoryAuthentication()
    //                .withUser("user")
    //                .password("1")
    //                .roles("USER")
    //                .and()
    //                .withUser("admin")
    //                .password("1")
    //                .roles("USER","ADMIN");
    //    }

    @Bean
    public UserDetailsService userDetailsService(JdbcTemplate jdbcTemplate){
        RowMapper<User> userRowMapper = (ResultSet rs, int i)->
            new User(
                    rs.getString("ACCOUNT_NAME"),
                    rs.getString("PASSWORD"),
                    rs.getBoolean("ENABLED"),
                    rs.getBoolean("ENABLED"),
                    rs.getBoolean("ENABLED"),
                    rs.getBoolean("ENABLED"),
                    AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_USER"));
        return username -> jdbcTemplate
                                    .queryForObject("SELECT * FROM ACCOUNT WHERE ACCOUNT_NAME = ?",
                                                          userRowMapper, username);

    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService);
    }
}

    