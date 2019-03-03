package com.org.test.controller;

import com.org.test.entity.Item;
import com.org.test.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController implements RestContract{

	@Autowired
	private ItemBusinessService businessService;

	@Override
	@GetMapping(value = "/hello-world", produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Item> helloWorld(@RequestParam MultiValueMap<String, String> requestIds) {
	    Item item = new Item(1, "Ball", 10, 100);
		return ResponseEntity.ok(item);
	}

	@Override
	@GetMapping(value = "/item-from-service-service", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Item>> itemFromBusinessService() {
		return ResponseEntity.ok(businessService.retrieveHardcodedItem());
	}

	@Override
	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItems() {
		return businessService.retrieveAllItems();
	}
	
}
