package com.charlieaffs.ifs.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
		"com.charlieaffs.ifs", 
		"com.charlieaffs.data", 
		"com.charlieaffs.rest" })
public class InfastructureConfig {	
}
