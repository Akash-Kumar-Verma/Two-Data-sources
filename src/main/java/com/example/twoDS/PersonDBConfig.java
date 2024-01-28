package com.example.twoDS;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.*;
//
@Configuration
@EnableJpaRepositories(basePackages = {"com.example.twoDS.personDB"},
        entityManagerFactoryRef="getPersonEntityManager",
        transactionManagerRef = "personTxnManager")
public class PersonDBConfig {
    @Bean
    @ConfigurationProperties(
            prefix = "person.datasource"
    )
    public DataSource getPersonDs(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getPersonEntityManager(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getPersonDs());
        em.setPackagesToScan("com.example.twoDS.personDB");
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        em.setJpaPropertyMap(properties);
        return em;
    }
    @Bean
    public PlatformTransactionManager personTxnManager(){
        JpaTransactionManager txnManager = new JpaTransactionManager();
        txnManager.setEntityManagerFactory(getPersonEntityManager().getObject());
        return txnManager;
    }
}

// how to get connected to 2 datasources -> default, 1 was new one

// how to get connected to 3 datasource -> person, author , student(spring)

// u have to try saving the data in to db

// person -> jbdl_64_person , student -> jbdl_64_student, author -> jbdl_64_author

// u have to check if the data is going into db or not
