//package com.nagarro;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter{
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
////		http.cors().and().authorizeRequests().antMatchers("/api/user/**").permitAll().and().httpBasic();
//		http.csrf().disable()
//		.authorizeRequests()
//		.antMatchers( HttpMethod.OPTIONS,"/**").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.httpBasic();
//	    }
////	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//	    web.ignoring().antMatchers(HttpMethod.POST,"/api/user");
//	    web.ignoring().antMatchers(HttpMethod.GET,"/api/user/getusers");
//	    web.ignoring().antMatchers(HttpMethod.POST,"/api/user/login");
//	    web.ignoring().antMatchers("/api/posts/getposts");
//	    web.ignoring().antMatchers("/api/posts/solved");
//	}
////	
////	 @Bean
////	  CorsConfigurationSource corsConfigurationSource() 
////	  {
////	    CorsConfiguration configuration = new CorsConfiguration();
////	    configuration.setAllowedOrigins(Arrays.asList("*"));
////	    configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","PATCH","DELETE","OPTIONS"));
////	    configuration.setAllowedHeaders(Arrays.asList("*"));
////	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////	    source.registerCorsConfiguration("/**", configuration);
////	    return source;
////	  }
//	 
//	
//}
//
//
