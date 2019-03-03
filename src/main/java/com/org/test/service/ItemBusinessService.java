package com.org.test.service;

import com.org.test.entity.Item;
import com.org.test.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository repository;
	
	public List<Item> retrieveHardcodedItem() {
		return asList(new Item(1, "Ball", 10, 100));
	}
	
	public List<Item> retrieveAllItems() {
		List<Item> items = repository.findAll();
		
		for(Item item:items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		
		return items;	
	}
	
}
