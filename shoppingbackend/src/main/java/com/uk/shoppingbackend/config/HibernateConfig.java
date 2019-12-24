package com.uk.shoppingbackend.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.uk.shoppingbackend.dto")
@EnableTransactionManagement
public class HibernateConfig {
	
	// CHANGES THE BELOW BASED ON MY H2 DATABSE
	private final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/test";
	private final String DATABASE_DRIVER = "org.h2.Driver";
	private final String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final String DATABASE_USERNAME = "sa";
	private final String DATABASE_PASSWORD = "";
//SET VARIABLE FOR MYSQL
	// CHANGES THE BELOW BASED ON MY H2 DATABSE
//	private final String DATABASE_URL = "jdbc:mysql://localhost:3306/onlineshopping";
//	private final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
//	private final String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
//	private final String DATABASE_USERNAME = "root";
//	private final String DATABASE_PASSWORD = "admin";
	// DATASOURCE BEAN
	
	HibernateConfig(){
		System.out.println("HibernateConfig.HibernateConfig()");
	}
	// TO CREATE CONNECTION WE ARE USING DATASOURCE
	@Bean
	public DataSource getDataSource() {
		System.out.println("HibernateConfig.getDataSource()");
		BasicDataSource dataSource = new BasicDataSource();
		// providing databse connection information

		dataSource.setUrl(DATABASE_URL);
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataSource;
	}

	// session bean factory will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		System.out.println("HibernateConfig.getSessionFactory()");
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getProperties());
		builder.scanPackages("com.uk.shoppingbackend.dto");
		try {
			return builder.buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	// all the hibernate properties will be return in this method
	private Properties getProperties() {
		System.out.println("HibernateConfig.getProperties()");
		// TODO Auto-generated method stub
		Properties properties = new Properties();

		System.out.println(properties);

		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		System.out.println(properties);
		return properties;
	}

	// transaction manager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("HibernateConfig.getTransactionManager()");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
