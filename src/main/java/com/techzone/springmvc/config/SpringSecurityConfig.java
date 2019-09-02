package com.techzone.springmvc.config;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Resource(name = "userDetailService")
	private UserDetailsService userDetailsService;

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login"))
//		.and().authorizeRequests()
//		.antMatchers("**/login").permitAll()
//		.antMatchers("/dashboard").hasRole("USER")
//		.and().formLogin().defaultSuccessUrl("/dashboard").loginProcessingUrl("/login")
//		.loginPage("/login").and().logout().permitAll();
//	}
	
	
	@Override // work fine
	protected void configure(HttpSecurity http) throws Exception {

		http
		.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login"))
		.and()
		.authorizeRequests()
//				.anyRequest().authenticated()
			.and().authorizeRequests()
			.antMatchers("**/showMyLoginPage").permitAll()
			.antMatchers("/dashboard").authenticated()
			.antMatchers("/dashboard").hasRole("ADMIN")
			.antMatchers("/dashboard").hasRole("STAFF")
			.antMatchers("/admin/**").access("hasRole('ADMIN')")
			.antMatchers("/staff/**").access("hasRole('STAFF')")
			
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
//				.defaultSuccessUrl("/dashboard")
				.defaultSuccessUrl("/")
				.and().logout()
				.permitAll()
				.and().exceptionHandling().accessDeniedPage("/Access_Denied");
		
	}

	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/*.css");
		web.ignoring().antMatchers("/*.js");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	
//	@Bean // test
//	public FilterChainProxy samlFilter() throws Exception {
//	    List<SecurityFilterChain> chains = new ArrayList<SecurityFilterChain>();
//	    chains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/TechZone/login/**")));
//	    return new FilterChainProxy(chains);
//	}

	
	

}
