package br.com.conductor.siscon.config;

import java.util.Arrays;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@EnableJpaRepositories({"br.com.conductor.siscon"})
public class DatabaseConfigurationSiscon {

	private final Logger log = LoggerFactory.getLogger(DatabaseConfigurationSiscon.class);


	@Autowired
	private DBConfigSiscon dbConfig;


	@Bean(name="dataSource")
	@Lazy
	@Primary
	public DataSource dataSource() {
		log.info("Inicializando configuracao do Datasource...");
	
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(dbConfig.getDriver());
		dataSource.setUrl(dbConfig.getUrl());
		dataSource.setUsername(dbConfig.getUsername());
		dataSource.setPassword(dbConfig.getPassword());
		dataSource.setConnectionInitSqls(
				Arrays.asList(new String[] {dbConfig.getConnectionInitSql() } ) );

		dataSource.setInitialSize(Integer.parseInt(dbConfig.getInitialSize()));
		dataSource.setMaxActive(Integer.parseInt(dbConfig.getMaxActive()));
		dataSource.setMaxIdle(Integer.parseInt(dbConfig.getMaxIdle()));
		dataSource.setMinIdle(Integer.parseInt(dbConfig.getMinIdle()));
		dataSource.setMaxWait(Integer.parseInt(dbConfig.getMaxWait()));
		dataSource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(dbConfig.getTimeBetweenEvictionRunsMillis()));
		dataSource.setRemoveAbandoned(Boolean.parseBoolean(dbConfig.getRemoveAbandoned()));
		dataSource.setRemoveAbandonedTimeout(Integer.parseInt(dbConfig.getRemoveAbandonedTimeout()));
		dataSource.setTestOnBorrow(Boolean.parseBoolean(dbConfig.getTestOnBorrow()));
		dataSource.setValidationQuery(dbConfig.getValidateQuery());
		return dataSource;

	}

	@Bean
	public LazyConnectionDataSourceProxy lazyConnectionDataSourceProxy(){
		return new LazyConnectionDataSourceProxy(dataSource());
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		log.info("Inicializando configuracao do JPA...");
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource());
		entityManager.setPackagesToScan("br.com.conductor.siscon");
		entityManager.setJpaVendorAdapter(jpaVendorAdapter());
		entityManager.setPersistenceUnitName("pePersistenceUnit");
		entityManager.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
		entityManager.setJpaProperties(getHibernateProperties());
		entityManager.setValidationMode(ValidationMode.NONE);

		return entityManager;

	}


	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabasePlatform(dbConfig.getDialect());
		return jpaVendorAdapter;
	}


	private Properties getHibernateProperties() {
		Properties hibernateProperties = new Properties();

		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "validate");
		//hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "none");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.format_sql", "false");
		hibernateProperties.setProperty("hibernate.generate_statistics", "true");
		hibernateProperties.setProperty("hibernate.default_schema",dbConfig.getDefaultSchema());
//		hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");

		//inicio das configuracoes de cache (ehcache)
//		hibernateProperties.setProperty("hibernate.cache.provider_class", "net.sf.ehcache.hibernate.EhCacheProvider");
//		//hibernateProperties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
//		hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", "true");
//		hibernateProperties.setProperty("hibernate.cache.use_structured_entries", "true");
//		hibernateProperties.setProperty("hibernate.cache.use_query_cache", "true");
//		hibernateProperties.setProperty("hibernate.cache.provider_configuration_file_resource_path", "classpath:ehcache.xml");
//		hibernateProperties.setProperty("hibernate.cache.region_prefix", "");
		

		//inicio das configuracoes de processamento em lote
		hibernateProperties.setProperty("hibernate.default_batch_fetch_size", "8");
		hibernateProperties.setProperty("hibernate.jdbc.batch_size", "30");
		
		// Configuracao do Hibernate Envers
		hibernateProperties.setProperty("org.hibernate.envers.auditTableSuffix", "_aud");
		

		return hibernateProperties;
	}


	@Bean
	@Primary
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}


}
