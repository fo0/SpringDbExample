package com.example.spring.db.dao;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.example.spring.db.dao" })
public class PersistenceConfiguration {

	public PersistenceConfiguration() {
		super();
	}

	@Bean
	public DataSource dataSource() {
		//@formatter:off
		return DataSourceBuilder.create()
				.url("jdbc:mysql://localhost:3306/testdb?createDatabaseIfNotExist=true&useSSL=false")
				.driverClassName("com.mysql.cj.jdbc.Driver")
				.username("root")
				.password("max123")
				.build();
		//@formatter:on
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.example.spring.db.model" });

		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		// vendorAdapter.set
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	private final Properties additionalProperties() {
		final Properties p = new Properties();
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		// MYSQL 5
//		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

		// Whether to enable logging of SQL statements "true" | "false" -> currently not
		// working
		p.put("spring.jpa.show_sql", "false");

		// database metrics: "true" | "false"
		p.put("hibernate.generate_statistics", "false");
		return p;
	}

}
