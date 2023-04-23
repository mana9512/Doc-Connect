package com.docConnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.docConnect.controller", "com.docConnect.pojo", "com.docConnect.dao",
		"com.docConnect.validators" })
public class DocConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocConnectApplication.class, args);
	}

}
