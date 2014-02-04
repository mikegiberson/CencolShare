package com.cencolshare.init;

import java.util.Properties;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.cencolshare.interceptor.DemoInterceptor;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.cencolshare")
@EnableJpaRepositories("com.cencolshare.repository")
@Profile({ "runtime", "web", "test", "testweb" })
@Slf4j
public class WebAppConfig extends WebMvcConfigurerAdapter {

	public WebAppConfig() {
		log.debug("creating spring web app configuration");
	}

  @Bean
  public static PropertySourcesPlaceholderConfigurer applicationProperties() {
    final PropertySourcesPlaceholderConfigurer applicationProperties = new PropertySourcesPlaceholderConfigurer();
    applicationProperties.setIgnoreResourceNotFound(true);
    applicationProperties.setIgnoreUnresolvablePlaceholders(true);

    log.debug("Loading application.properties.");
    applicationProperties.setLocation(new ClassPathResource("application.properties"));

    return applicationProperties;
  }
    @Value("${hibernate.hbm2ddl.auto}") 
    private String PROPERTY_NAME_HIBERNATE_DDL;    
    
    @Value("${hibernate.dialect}")
    private String PROPERTY_NAME_HIBERNATE_DIALECT;
    
    @Value("${hibernate.show_sql}")
    private String PROPERTY_NAME_HIBERNATE_SHOW_SQL;
    
    @Value("${entitymanager.packages.to.scan}")
    private String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN;
	
    @Value("${db.driver}")
	private String PROPERTY_NAME_DATABASE_DRIVER;
    
    @Value("${db.password}")
	private String PROPERTY_NAME_DATABASE_PASSWORD;
    
    @Value("${db.url}")
	private String PROPERTY_NAME_DATABASE_URL;
    
    @Value("${db.username}")
	private String PROPERTY_NAME_DATABASE_USERNAME;
    
    @Value("${message.source.basename}")
    private String PROPERTY_NAME_MESSAGE_SOURCE_BASENAME;
    
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
		dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
		dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
		dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);

		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
		entityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
		
		entityManagerFactoryBean.setJpaProperties(hibProperties());
		
		return entityManagerFactoryBean;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", PROPERTY_NAME_HIBERNATE_DIALECT);
		properties.put("hibernate.show_sql", PROPERTY_NAME_HIBERNATE_SHOW_SQL);
		properties.put("hibernate.hbm2ddl.auto", PROPERTY_NAME_HIBERNATE_DDL);
		return properties;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename(PROPERTY_NAME_MESSAGE_SOURCE_BASENAME);
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) 
    {
      registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
 
 @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
         log.info("configureDefaultServletHandling");
     configurer.enable();
   }
 
 @Override
public void addInterceptors(InterceptorRegistry registry) {
         log.info("adding interceptors");
         registry.addInterceptor(new DemoInterceptor()).addPathPatterns("/**").excludePathPatterns("/all/**");
}
}
