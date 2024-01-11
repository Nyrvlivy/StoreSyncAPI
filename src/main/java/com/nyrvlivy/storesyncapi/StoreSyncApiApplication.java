package com.nyrvlivy.storesyncapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StoreSyncApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreSyncApiApplication.class, args);
	}

}
