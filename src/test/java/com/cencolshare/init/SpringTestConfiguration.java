package com.cencolshare.init;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("test")
@Slf4j
public class SpringTestConfiguration {
	
	public SpringTestConfiguration() {
		log.debug("initalizing spring test configuration");
	}

//  @Bean
//  public static PropertyOverrideConfigurer propertyOverride() {
//    log.debug("Loading test properties.");
//    final PropertyOverrideConfigurer properties = new PropertyOverrideConfigurer();
//
//    Resource location = new ClassPathResource("test.properties");
//    properties.setLocation(location);
//    
//    log.debug("Loaded test properties.");
//    return properties;
//  }
}
