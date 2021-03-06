package com.bootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer//eureka注册中心
@SpringBootApplication
public class EurekaStarter {

	public static void main(String[] args) {
		SpringApplication.run(EurekaStarter.class,args);
	}
}
