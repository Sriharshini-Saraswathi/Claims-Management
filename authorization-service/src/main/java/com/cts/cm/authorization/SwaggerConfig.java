package com.cts.cm.authorization;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/**"))
				.apis(RequestHandlerSelectors.basePackage("com.cts.cm.authorization"))
				.build()
				.apiInfo(apiDetails());
				
	}
	
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Authorization Service",
				"User credentials will be validated using this service",
				"1.0",
				"Premium Members only",
				new springfox.documentation.service.Contact("Claims Management", "http://www.authorization.com", "authorization@gmail.com"),
				"API License",
				"http://www.authorization.com",
				Collections.emptyList()
				);
		
	}
}