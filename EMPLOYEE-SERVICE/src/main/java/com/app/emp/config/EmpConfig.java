package com.app.emp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmpConfig {

	@Bean
	public ModelMapper modelmapper()
	{
		return new ModelMapper();
	}
	

}

