package com.aiolosgs.springcloud_zuul.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ZuulTestFilter extends ZuulFilter{

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		
		String requestURI = request.getRequestURI();
		if(requestURI.indexOf("hello") > -1){
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			context.set("isSuccess",false);
		}else{
			context.setSendZuulResponse(true);
			context.setResponseStatusCode(200);
			context.set("isSuccess",true);
		}
		
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		
		RequestContext ctx = RequestContext.getCurrentContext();
//		return (Boolean)ctx.get("isSuccess");
		
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
