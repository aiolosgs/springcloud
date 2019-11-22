package com.aiolosgs.clientbdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiolosgs.api.DemoAAPI;
import com.aiolosgs.model.DemoA;
import com.aiolosgs.model.DemoB;

@RestController
@RequestMapping(value="base")
public class BaseController {

	@Autowired
	private DemoAAPI clientA;
	
	@RequestMapping(value="get")
	public DemoB get(){
		DemoB b = new DemoB();
		b.setId("1");
		b.setName("entity from client-b");
		b.setCode("123");
		return b;
	}
	
	@RequestMapping(value="getA")
	public DemoA getA(){
		DemoA a = clientA.get("1");
		return a;
	}
}
