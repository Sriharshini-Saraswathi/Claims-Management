package com.cts.cm.member.config;

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
				.paths(PathSelectors.ant("/member/**"))
				.apis(RequestHandlerSelectors.basePackage("com.cts.cm.member"))
				.build()
				.apiInfo(apiDetails());
				
	}
	
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Member Services",
				"User shall be able to view bills here",
				"1.0",
				"Premium Members only",
				new springfox.documentation.service.Contact("Shruthi", "http://www.member.com", "shuthimalathkar@gmail.com"),
				"API License",
				"http://www.member.com",
				Collections.emptyList()
				);
		
	}
}