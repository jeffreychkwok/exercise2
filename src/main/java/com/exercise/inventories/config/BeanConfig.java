package com.exercise.inventories.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.exercise.inventories.api.impl.InventoriesApiDelegateImpl;

@Configuration
public class BeanConfig {
	@Bean
	public InventoriesApiDelegateImpl inventoriesApi() {
		return new InventoriesApiDelegateImpl();
	}
}
