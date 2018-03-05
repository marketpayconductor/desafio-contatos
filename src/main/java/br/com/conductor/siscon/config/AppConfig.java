package br.com.conductor.siscon.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAutoConfiguration
@EnableCaching
@EnableScheduling
@ComponentScan({"br.com.conductor.siscon",})
@PropertySource({"classpath:db.properties","classpath:parametros.properties"})
public class AppConfig {
	
	private static final Logger log = LoggerFactory.getLogger(AppConfig.class);
	
	public static void main(String[] args) {
		log.info("Inicializando aplicacao SisCon...");
		
		SpringApplication app = new SpringApplication(AppConfig.class);
        app.run(args);
	}
	
	@Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBean() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
