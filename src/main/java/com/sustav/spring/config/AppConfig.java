package com.sustav.spring.config;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import static org.hibernate.cfg.AvailableSettings.*;
import static org.hibernate.cfg.Environment.DRIVER;
import java.util.Objects;
import java.util.Properties;

@Configuration
@PropertySource(value = "classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = {
        @ComponentScan("com.sustav.spring.dao"),
        @ComponentScan("com.sustav.spring.service")
})
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        Properties properties = new Properties();
        properties.put(DRIVER, Objects.requireNonNull(environment.getProperty("mysql.driver")));
        properties.put(URL, Objects.requireNonNull(environment.getProperty("mysql.url")));
        properties.put(USER, Objects.requireNonNull(environment.getProperty("mysql.user")));
        properties.put(PASS, Objects.requireNonNull(environment.getProperty("mysql.pas$w0rd")));
//        Hibernate properties
        properties.put(SHOW_SQL, Objects.requireNonNull(environment.getProperty("hibernate.show_sql")));
        properties.put(HBM2DDL_AUTO, Objects.requireNonNull(environment.getProperty("hibernate.hbm2ddl.auto")));
        properties.put(DIALECT, Objects.requireNonNull(environment.getProperty("hibernate.dialect")));
        properties.put(FORMAT_SQL, Objects.requireNonNull(environment.getProperty("hibernate.format_sql")));
//        C3P0 properties
        properties.put(C3P0_MAX_SIZE, Objects.requireNonNull(environment.getProperty("hibernate.c3p0.max_size")));
        properties.put(C3P0_MIN_SIZE, Objects.requireNonNull(environment.getProperty("hibernate.c3p0.min_size")));
        properties.put(C3P0_TIMEOUT, Objects.requireNonNull(environment.getProperty("hibernate.c3p0.timeout")));
        properties.put(C3P0_ACQUIRE_INCREMENT, Objects.requireNonNull(environment.getProperty("hibernate.c3p0.acquire_increment")));
        properties.put(C3P0_MAX_STATEMENTS, Objects.requireNonNull(environment.getProperty("hibernate.c3p0.max_statements")));

        localSessionFactoryBean.setHibernateProperties(properties);
        localSessionFactoryBean.setDataSource(getDataSource());
        localSessionFactoryBean.setPackagesToScan("com.sustav.spring.model");

        return localSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(localSessionFactoryBean().getObject());

        return hibernateTransactionManager;
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClass(environment.getProperty("mysql.driver"));
        dataSource.setJdbcUrl(environment.getProperty("mysql.url"));
        dataSource.setUser(environment.getProperty("mysql.user"));
        dataSource.setPassword(environment.getProperty("mysql.pas$w0rd"));

        return dataSource;
    }
}
