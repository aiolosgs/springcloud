package com.aiolosgs.clientbdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiolosgs.api.DemoAAPI;
import com.aiolosgs.model.DemoA;
import com.aiolosgs.model.DemoB;

@RestController
@RequestMapping(value="base")
@RefreshScope
public class BaseController {

	@Autowired
	private DemoAAPI clientA;

	@Value("${server.port}")
	private String port;

	@Value("${config.test}")
	private String config;
	
	@RequestMapping(value="get")
	public DemoB get(){
		DemoB b = new DemoB();
		b.setId("1");
		b.setName("entity from client-b via port : " + port);
		b.setCode("123");
		return b;
	}

	@RequestMapping(value="getConfig")
	public String getConfig(){
		return config;
	}
	
	@RequestMapping(value="getA")
	public DemoA getA(){
		DemoA a = clientA.get("1");
		return a;
	}
}
