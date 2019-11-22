package com.aiolosgs.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aiolosgs.model.DemoB;

@FeignClient(value="eureka-client-b")
public interface DemoBAPI {
	
	@RequestMapping(value="/base/get")
	public DemoB get(String id); 

	@RequestMapping(value="/save")
	public boolean save(DemoB a);
	
	@RequestMapping(value="/delete")
	public boolean delete(String id);
}
