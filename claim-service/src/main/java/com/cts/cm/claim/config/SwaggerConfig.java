package com.cts.cm.claim.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cts.cm.claim")).build().apiInfo(apiDetails());

	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Claim Services", "User can submit claim and get claim status through this service", "1.0",
				"Accessible to only premium members",
				new springfox.documentation.service.Contact("Srikar", "http://www.claim.com", "srikar@gmail.com"),
				"API License", "http://www.claim.com", Collections.emptyList());

	}
}
