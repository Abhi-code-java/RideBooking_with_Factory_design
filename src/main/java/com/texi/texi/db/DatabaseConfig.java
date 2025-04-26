package com.texi.texi.db;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryBean",
        basePackages = "com.texi.texi.repositopry",
        transactionManagerRef = "transactionManager"
)
public class DatabaseConfig {
    @Autowired
    private Environment environment;

    @Bean("mysql")
    @Primary
    public DataSource dataSource(){
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver"); // ✅ Hardcoded
        source.setUrl(environment.getProperty("spring.datasource.url"));
        source.setUsername(environment.getProperty("spring.datasource.username"));
        source.setPassword(environment.getProperty("spring.datasource.password"));
        return source;
    }
    @Bean("entityManagerFactoryBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
        Map<String,String>map=new HashMap<>();
        map.put("hibernate.hbm2ddl.auto","update");
        map.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        map.put("hibernate.show_sql","true");
        bean.setJpaPropertyMap(map);
        HibernateJpaVendorAdapter adaptor=new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(adaptor);
        bean.setPackagesToScan("com.texi.texi.entity");
        bean.setDataSource(dataSource());
        return bean;
    }
    @Bean(name="transactionManager")
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager manager=new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return manager;
    }
}
