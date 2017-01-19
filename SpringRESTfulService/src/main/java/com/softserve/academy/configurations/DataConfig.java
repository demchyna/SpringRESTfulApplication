package com.softserve.academy.configurations;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.softserve.academy.repositories")
public class DataConfig {
    @Bean
    public DataSource getDataSource(@Value("#{driverClassName}") String driverClassName,
                                    @Value("${jdbc.url}") String url,
                                    @Value("${jdbc.username}") String username,
                                    @Value("${jdbc.password}") String password) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfig() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfig = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfig.setLocation(new ClassPathResource("database.properties"));
        return propertyPlaceholderConfig;
    }
}
