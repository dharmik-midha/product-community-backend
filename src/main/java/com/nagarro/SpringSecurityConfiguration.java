package com.nagarro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringSecurityConfiguration {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("*");
			}
		};
	}
	
//	@Bean
//	public InMemoryUserDetailsManager users() {
//		UserDetails user = User.withUsername("user").password("{noop}password").roles("user").build();
//		UserDetails admin = User.withUsername("admin").password("{noop}password").roles("admin").build();
//		return new InMemoryUserDetailsManager(user, admin);
//	}
//	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return http.csrf(csrf->csrf.disable())
//				.authorizeRequests(auth-> {
//					auth.antMatchers("/api/admin").hasRole("admin");
//					auth.antMatchers("/api/user").hasRole("user");
//				})
//				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				.httpBasic(Customizer.withDefaults()).build();
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest()
				.authenticated().and().httpBasic();
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) ->
		web.ignoring().antMatchers(HttpMethod.POST, "/api/user").and().ignoring()
				.antMatchers(HttpMethod.GET, "/api/user/getusers").and().ignoring()
				.antMatchers(HttpMethod.POST, "/api/user/login").and().ignoring().antMatchers("/api/posts/getposts")
				.and().ignoring().antMatchers("/api/posts/solved");

	}
}
