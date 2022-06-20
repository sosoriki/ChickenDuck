package com.chickenducks.weatherApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);


	}
//	@Override
//	protected void configure(HttpSecurity security) throws Exception
//{
//    security.httpBasic().disable();
//}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// @formatter:off
//		http
//				.authorizeRequests(a -> a
//						.antMatchers("/", "/error", "/webjars/**").permitAll()
//						.anyRequest().authenticated()
//				).logout(l -> l
//						.logoutSuccessUrl("/").permitAll()
//				)
//				.exceptionHandling(e -> e
//						.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//				)
//				.csrf(c -> c
//						.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//				)
//				.cors().and()
//				.oauth2Login();
//
//		// @formatter:on
//
//
//	}
//
//	@GetMapping("/user")
//	public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
//		return Collections.singletonMap("name", principal.getAttribute("name"));
//	}
//	@Bean
//	public CorsFilter corsFilter(){

//	@Bean
//	CorsConfigurationSource corsConfigurationSource(){
//	CorsConfiguration corsConfiguration = new CorsConfiguration();
////		corsConfiguration.setAllowCredentials(true);
//		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//				"Accept","Authorization", "Origin, Accept", "X-Requested-With",
//				"Access-Control-Request-Method", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
//		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS" ));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", corsConfiguration);
//		return source;
//	}




}
