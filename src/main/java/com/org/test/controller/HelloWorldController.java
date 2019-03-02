package com.org.test.controller;

import com.org.test.entity.Item;
import com.org.test.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {

	@Autowired
	private ItemBusinessService businessService;

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Ball", 10, 100);
	}

	@GetMapping("/item-from-service-service")
	public Item itemFromBusinessService() {
		Item item = businessService.retreiveHardcodedItem();

		return item;
	}

	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItems() {
		return businessService.retrieveAllItems();
	}
	
}
