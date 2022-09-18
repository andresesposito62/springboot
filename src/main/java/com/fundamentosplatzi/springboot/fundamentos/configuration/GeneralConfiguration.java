package com.fundamentosplatzi.springboot.fundamentos.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}") //permite llamar a valores que hemos incializado en application.properties
    private String name;

    @Value("${value.apellido}") //permite llamar a valores que hemos incializado en application.properties
    private String apellido;

    @Value("${value.random}") //permite llamar a valores que hemos incializado en application.properties
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name, apellido);
    }

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                    .url("jdbc:h2:mem:testdb")
                     .username("sa")
                      .password("")
                       .build();
        }

}
