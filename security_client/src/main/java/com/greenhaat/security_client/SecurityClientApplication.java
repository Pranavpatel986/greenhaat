package com.greenhaat.security_client;

import com.greenhaat.security_client.config.OpenAPIConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(OpenAPIConfiguration.class)
public class SecurityClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityClientApplication.class, args);
	}

}
