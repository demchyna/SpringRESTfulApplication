package com.softserve.academy.configurations;


import com.softserve.academy.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;


import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:database.properties")
public class DataConfig {

    @Autowired
    private Environment env;

    @Bean
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Autowired
    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);

//        sessionBuilder.addAnnotatedClasses(User.class);

        sessionBuilder.scanPackages("com.softserve.academy.models");
        sessionBuilder.addProperties(getHibernateProperties());

        return sessionBuilder.buildSessionFactory();
    }

    @Autowired
    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return properties;
    }

}
