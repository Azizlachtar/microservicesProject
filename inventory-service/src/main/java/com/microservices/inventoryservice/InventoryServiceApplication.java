package com.microservices.inventoryservice;

import com.microservices.inventoryservice.model.Inventory;
import com.microservices.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory=new Inventory();
			inventory.setSkuCode("iphone 13");
			inventory.setQuantity(113);

			Inventory inventory2=new Inventory();
			inventory2.setSkuCode("iphone 14");
			inventory2.setQuantity(100);

			Inventory inventory3=new Inventory();
			inventory3.setSkuCode("iphone 15");
			inventory3.setQuantity(0);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory2);
			inventoryRepository.save(inventory3);
		};
	}

}
