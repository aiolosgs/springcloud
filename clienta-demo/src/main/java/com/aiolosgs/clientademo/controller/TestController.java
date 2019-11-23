package com.aiolosgs.clientademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiolosgs.api.DemoBAPI;
import com.aiolosgs.model.DemoA;
import com.aiolosgs.model.DemoB;

@RestController
@RequestMapping(value="test")
public class TestController {

	@Autowired
	private DemoBAPI clientB;

	@Value("${server.port}")
	private String port;

	@Value("${config.test}")
	private String config;
	
	@RequestMapping(value="get")
	public DemoA get(){
		DemoA a = new DemoA();
		a.setId("1");
		a.setName("entity from client-a via port : " + port);
		return a;
	}

	@RequestMapping(value="getConfig")
	public String getConfig(){
		return config;
	}
	
	@RequestMapping(value="getB")
	public DemoB getB(){
		DemoB b = clientB.get("1");
		return b;
	}
}
