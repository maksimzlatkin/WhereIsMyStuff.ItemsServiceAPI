package com.wheremystuff.ItemServiceAPI;

import com.wheremystuff.ItemServiceAPI.repository.ItemRepository;
import com.wheremystuff.ItemServiceAPI.repository.ItemRepositoryImplementation;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ItemServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
