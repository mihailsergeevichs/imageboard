package com.mihailsergeevichs.imageboard.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Overlord on 21.12.2015.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.mihailsergeevichs.imageboard.repository"})
@EnableTransactionManagement
public class Persistence {

    private static final String[] ENTITY_PACKAGES = {
            "com.mihailsergeevichs.imageboard.entity"
    };

    @Resource
    Environment environment;

    private static final String PROPERTY_NAME_DB_DRIVER_CLASS = "db.driver";
    private static final String PROPERTY_NAME_DB_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DB_URL = "db.url";
    private static final String PROPERTY_NAME_DB_USER = "db.username";
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";


    /*
    * This method creates HikariCP DataSource as connection pool.
    * @param environment
     */
    @Bean(destroyMethod = "close")
    DataSource getDataSource(Environment environment){
        HikariConfig dataSource = new HikariConfig();
        dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DB_DRIVER_CLASS));
        dataSource.setJdbcUrl(environment.getRequiredProperty(PROPERTY_NAME_DB_URL));
        dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DB_USER));
        dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DB_PASSWORD));

        return new HikariDataSource(dataSource);
    }
    /*
    * This method creates JPA entity manager factory bean.
    * @param dataSource - data source as data base connection pool
    * @param environment - runtime environment of this application
     */
    @Bean(name = "entityManagerFactory")
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource, Environment environment){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);

        //creates temporary property object
        Properties jpaProperties = new Properties();

        //configures optimized SQL dialect for Hibernate
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT,
                environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));

        //If this value is true, hibernate will print clear log to console out
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL,
                environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));

        //action that invokes when hibernate started. Data base will be created and dropped at the end of application lifecycle
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO,
                environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));

        //configures naming strategy for hibernate when he creates new data base objects
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY,
                environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));

        //if this value is true, hibernate will log all statements to console out
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL,
                environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

        localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties);

        return localContainerEntityManagerFactoryBean;
    }

    /*
    *Creates transaction manager, which will be integrated current JPA provider with spring transaction mechanism
    *@param entityManagerFactory - current JPA transaction factory
     */
    @Bean
    JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }

}
