package com.schaydulin.jhelp.config;

import com.schaydulin.jhelp.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {

    @Bean
    @Autowired
    public Test test(DataSource dataSource) {
        return new Test(dataSource);
    }

}
