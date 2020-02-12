package com.amith.cms.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.amith.cms.interceptor.RequestResponseInterceptor;

@Component
public class InterceptorConfiguration implements WebMvcConfigurer {

	@Autowired
	RequestResponseInterceptor requestResponseInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestResponseInterceptor);
	}
}
