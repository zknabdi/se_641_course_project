/**
 * 
 */
package com.se641.se641backend.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author zknab
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.se641.se641backend.model"})
@EnableTransactionManagement
public class HibernateConfig {

	/*
	 *  Database Configuration
	 */
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/se641online?useSSL=false";
	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_USER = "root";
	private final static String DATABASE_PASS = "root";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
	
	@Bean("dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USER);
		dataSource.setPassword(DATABASE_PASS);
		
		return dataSource;
		
	}
	
	
	/*
	 * SessionFactory
	 */
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder  builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.se641.se641backend.model"); //ccom.se641.se641backend
		
		return builder.buildSessionFactory();
	}


	/*
	 *  All Hibernate Properties will be returned in here
	 */
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	
	/*
	 *  Hibernate Transaction Management
	 */
	@Bean
	public HibernateTransactionManager getTransManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transManager = new HibernateTransactionManager(sessionFactory);
		
		return transManager;
	}
}
