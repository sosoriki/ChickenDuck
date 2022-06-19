package com.chickenducks.weatherApplication;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


//Spring security 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	private DataSource dataSource;
//	
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
//		auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//			.dataSource(dataSource)
//			.usersByUsernameQuery("select username, password, enabled from users where username=?")
//			.authoritiesByUsernameQuery("select username, users.role from users where username=?");
//	}
	
	//configure for angular
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		  http.cors().and().csrf().
	      disable()
	      .authorizeRequests()
//	      .antMatchers(HttpMethod.OPTIONS, "/**")
	      .antMatchers("/", "/main")
	      .permitAll()
	      .anyRequest()
//	      .permitAll()
	      .authenticated()
	      .and()
	      .httpBasic();
//		  http.httpBasic().disable();
		  
	    }
	

	   
	   @Bean
	    CorsConfigurationSource corsConfigurationSource(){
	        CorsConfiguration corsConfiguration = new CorsConfiguration();
	        corsConfiguration.setAllowCredentials(true);
	        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
	                "Accept","Authorization", "Origin, Accept", "X-Requested-With",
	                "Access-Control-Request-Method", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
	        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS" ));
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", corsConfiguration);
	        return source;
	    }
	   
	   
}

//OAuth security

//@RestController
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
//		http.authorizeRequests(a -> a
//				.antMatchers("/", "/error","/webjars/**").permitAll()
//				.anyRequest().authenticated()
//				)
//		.exceptionHandling(e -> e
//				.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//				)
//		.logout(l -> l
//				.logoutSuccessUrl("/").permitAll()
//				)
//		.csrf(c -> c
//	            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//	        )
//		.oauth2Login();
//		
//		http.httpBasic().disable();
//	}
//}
