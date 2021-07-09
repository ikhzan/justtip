package com.justtip.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JusttipApplication {

	public static void main(String[] args) {
		SpringApplication.run(JusttipApplication.class, args);
	}

}
