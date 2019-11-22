package com.aiolosgs.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aiolosgs.model.DemoA;

@FeignClient(value="eureka-client-a")
public interface DemoAAPI {
	
	@RequestMapping(value="/test/get")	
	public DemoA get(String id); 

	@RequestMapping(value="/save")
	public boolean save(DemoA a);
	
	@RequestMapping(value="/delete")	
	public boolean delete(String id);
}
