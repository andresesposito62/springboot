package com.fundamentosplatzi.springboot.fundamentos.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}") //permite llamar a valores que hemos incializado en application.properties
    private String name;

    @Value("${value.apellido}") //permite llamar a valores que hemos incializado en application.properties
    private String apellido;

    @Value("${value.random}") //permite llamar a valores que hemos incializado en application.properties
    private String random;
    
    @Value("${jdbc.url}")
    private String jdbcurl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name, apellido);
    }

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .driverClassName(driver)
                    .url(jdbcurl)
                     .username(username)
                      .password(password)
                       .build();
        }

}
