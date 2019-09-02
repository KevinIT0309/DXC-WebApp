package com.techzone.springmvc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@Configuration
public class MessageResourcesConfig {
	
	@Bean(name = "messageSource")
	public MessageSource getMessageResource() {
		ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
//		messageResource.setBasename("classpath:i18n/messages");
		messageResource.setBasenames("classpath:i18n/messages","classpath:validation");
		messageResource.setUseCodeAsDefaultMessage(true);
		messageResource.setDefaultEncoding("UTF-8");
		messageResource.setCacheSeconds(1000);
		return messageResource;
	}
	
	
	@Bean(name = "localeResolver")
	public LocaleResolver getLocaleResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setCookieDomain("myAppLocaleCookie");
		resolver.setCookieMaxAge(60*60);
		return resolver;
	}

}
