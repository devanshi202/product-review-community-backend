package com.springboot.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPattern;

@Configuration
public class CorsConfiguration {

	
	private static final String GET = "GET";
	private static final String POST = "POST";
	private static final String DELETE = "DELETE";
	private static final String PUT = "PUT";
	
	
	@Bean
	public WebMvcConfigurer corsConfigurer()
	{
		return new WebMvcConfigurer() 
		{
			@Override
			public void addCorsMappings(CorsRegistry registry)
			{
				
				registry.addMapping("/**")
				        .allowedMethods(GET, POST, DELETE, PUT)
				        .allowedHeaders("*")
				        .allowedOriginPatterns("*")
				        .allowCredentials(true)
				        ;
			}
		};
	}
}
