package com.techzone.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({"com.techzone.springmvc"})
public class SpringMvcConfig implements WebMvcConfigurer { // TODO INFO: This's the dispatcher servlet's Spring application context //
	
	// OR extends WebMvcConfigurerAdapter
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/*.js/**").addResourceLocations("/views/static/");
        registry.addResourceHandler("/*.css/**").addResourceLocations("/views/static/");
        
        // add for test load image
//        registry.addResourceHandler("src/main/webapp/resources/**").addResourceLocations("/resources/");

	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/showMyLoginPage").setViewName("login");
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resourceView = new InternalResourceViewResolver();
		resourceView.setViewClass(JstlView.class);
		resourceView.setPrefix("/views/jsp/");
		resourceView.setSuffix(".jsp");
		return resourceView;
	}
	
	// for upload image
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520); // 20 MB
		return multipartResolver;
	}
//	@Bean // for upload image
//	public MultipartResolver multipartResolver() {
//		StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
//		return resolver;
//	}
	
	// multiple Language
	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		interceptorRegistry.addInterceptor(localeChangeInterceptor).addPathPatterns("/*");
	}
	

}
