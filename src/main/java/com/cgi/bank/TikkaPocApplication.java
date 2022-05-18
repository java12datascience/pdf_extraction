package com.cgi.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEncryptableProperties
public class TikkaPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(TikkaPocApplication.class, args);
	}

}
