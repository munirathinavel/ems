package com.hospital.ems;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import static org.hibernate.cfg.Environment.*;

/**
 * <P>
 * This class is used for keeping all the configuration for the application like
 * configuring Data Source, JDBC Template, Component Scan & Read Application
 * Property
 * </P>
 * 
 * @author munirathinavel
 *
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.hospital.ems")
@PropertySource(value = { "classpath:application.properties" })
public class EmsApplication {

	private static final String HIBERNATE_C3P0_MAX_STATEMENTS = "hibernate.c3p0.max_statements";
	private static final String HIBERNATE_C3P0_TIMEOUT = "hibernate.c3p0.timeout";
	private static final String HIBERNATE_C3P0_ACQUIRE_INCREMENT = "hibernate.c3p0.acquire_increment";
	private static final String HIBERNATE_C3P0_MAX_SIZE = "hibernate.c3p0.max_size";
	private static final String HIBERNATE_C3P0_MIN_SIZE = "hibernate.c3p0.min_size";
	private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String DATASOURCE_PASSWORD = "datasource.password";
	private static final String DATASOURCE_USERNAME = "datasource.username";
	private static final String DATASOURCE_URL = "datasource.url";
	private static final String DATASOURCE_DRIVER_CLASS_NAME = "datasource.driver-class-name";

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}

	/**
	 * 
	 * Postgresql database configuration goes here.
	 * 
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(DATASOURCE_DRIVER_CLASS_NAME));
		dataSource.setUrl(env.getRequiredProperty(DATASOURCE_URL));
		dataSource.setUsername(env.getRequiredProperty(DATASOURCE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(DATASOURCE_PASSWORD));
		return dataSource;
	}

	/**
	 * Configure JdbcTemplate by setting Datasource.
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}

	/**
	 * This method is used to create session factory bean for hibernate
	 * 
	 * @return
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		Properties props = new Properties();

		// Setting Hibernate properties
		props.put(SHOW_SQL, env.getProperty(HIBERNATE_SHOW_SQL));
		props.put(HBM2DDL_AUTO, env.getProperty(HIBERNATE_HBM2DDL_AUTO));

		// Setting C3P0 properties
		props.put(C3P0_MIN_SIZE, env.getProperty(HIBERNATE_C3P0_MIN_SIZE));
		props.put(C3P0_MAX_SIZE, env.getProperty(HIBERNATE_C3P0_MAX_SIZE));
		props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty(HIBERNATE_C3P0_ACQUIRE_INCREMENT));
		props.put(C3P0_TIMEOUT, env.getProperty(HIBERNATE_C3P0_TIMEOUT));
		props.put(C3P0_MAX_STATEMENTS, env.getProperty(HIBERNATE_C3P0_MAX_STATEMENTS));

		factoryBean.setHibernateProperties(props);
		factoryBean.setDataSource(dataSource());
		// Setting the package for scanning & making model entity object to prepare the
		// object relational mapping
		factoryBean.setPackagesToScan("com.hospital.ems.model");

		return factoryBean;
	}

	/**
	 * Preparing Transaction Manager with hibernate Session factory
	 */

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

}
