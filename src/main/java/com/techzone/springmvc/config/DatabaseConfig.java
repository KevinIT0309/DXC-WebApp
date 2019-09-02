package com.techzone.springmvc.config;


import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


//@Configuration
//@EnableTransactionManagement
public class DatabaseConfig extends WebMvcConfigurerAdapter {
	
//	final static String PACKAGE_SCAN = "com.techzone.springmvc";
//	
//	
//	private Properties hibernateProperties() {
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//		properties.put("hibernate.show_sql", true);
//		properties.put("hibernate.format_sql", true);
//		properties.put("hibernate.hbm2ddl.auto", "update");
//		return properties;
//	}
//	
//	@Bean(name = "dataSource")
//	public BasicDataSource getDataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/TechZone?useSSL=false");
//		dataSource.setUsername("springstudent");
//		dataSource.setPassword("springstudent");
//		return dataSource;
//	}
//	
//	@Bean
//	public LocalSessionFactoryBean sessionFactoryBean(BasicDataSource dataSource) {
//		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//		sessionFactoryBean.setDataSource(dataSource);
//		sessionFactoryBean.setPackagesToScan(PACKAGE_SCAN);
//		sessionFactoryBean.setHibernateProperties(hibernateProperties());
//		return sessionFactoryBean;
//	}
	
	//////////////////////////////////////////////////////////////////////////////
	
//	@Bean /** PersistenceJPAConfig **/
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//	    factory.setDataSource(getDataSource());
//	    factory.setPackagesToScan(PACKAGE_SCAN);
//	    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//	    factory.setJpaVendorAdapter(vendorAdapter);
//	    factory.setJpaProperties(hibernateProperties());
//	 
//	    return factory;
//	   }

//	@Bean
//	public HibernateTransactionManager transactionManager(SessionFactory session) {
//		HibernateTransactionManager manager = new HibernateTransactionManager();
//		manager.setSessionFactory(session);
//		return manager;
//	}
//	
//	@Bean
//	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//	    return new PersistenceExceptionTranslationPostProcessor();
//	}

	

}
