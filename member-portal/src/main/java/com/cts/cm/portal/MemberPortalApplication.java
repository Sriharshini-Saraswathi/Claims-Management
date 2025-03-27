package com.cts.cm.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MemberPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberPortalApplication.class, args);
	}

}
