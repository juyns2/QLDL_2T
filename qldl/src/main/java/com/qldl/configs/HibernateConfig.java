/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldl.configs;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import static org.hibernate.cfg.Environment.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author Lenovo
 */
@Configuration
@PropertySource("classpath:databases.properties")			// Classpath để env đọc properties file từ java file # đọc từ jsp
public class HibernateConfig {

    @Autowired
    private Environment env;		// Copy nhớ bỏ Class ra

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setPackagesToScan("com.qldl.pojo");
        factory.setDataSource(dataSource());
        factory.setHibernateProperties(hibernateProperties());
        return factory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource d = new DriverManagerDataSource();
        d.setDriverClassName(env.getProperty("hibernate.connection.driverClass"));
        d.setUrl(env.getProperty("hibernate.connection.url"));
        d.setUsername(env.getProperty("hibernate.connection.username"));
        d.setPassword(env.getProperty("hibernate.connection.password"));
        return d;
    }

    public Properties hibernateProperties() {
        Properties props = new Properties();
        props.setProperty(SHOW_SQL, env.getProperty("hibernate.showSql"));
        // Can 
        props.setProperty(DIALECT, env.getProperty("hibernate.dialect"));
        return props;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager h = new HibernateTransactionManager();
        h.setSessionFactory(getSessionFactory().getObject());
        return h;
    }
}
