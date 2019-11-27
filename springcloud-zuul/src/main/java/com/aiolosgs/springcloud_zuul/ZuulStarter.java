package com.aiolosgs.springcloud_zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.aiolosgs.springcloud_zuul.filter.ZuulTestFilter;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulStarter 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ZuulStarter.class, args);
    }
    
    @Bean
    public ZuulTestFilter testFilter(){
    	return new ZuulTestFilter();
    }
}
