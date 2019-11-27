package com.resoft.springboot_starter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloController {

	@Value("${server.port}")
	private String port;
	
	@RequestMapping(value="/hello")
	public String hello(){
		return "hello from "+port;
	}
	
	@RequestMapping(value="/service")
	@HystrixCommand(fallbackMethod="serviceFallback")
	public String service(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("service run in "+Thread.currentThread().getName());
		return "service";
	}
	
	public String serviceFallback(){
		System.out.println("fallback run in "+Thread.currentThread().getName());
		return "fallback";
	}
}
