package com.org.test.service;

import com.org.test.repository.ItemRepository;
import com.org.test.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository repository;
	
	public Item retreiveHardcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	public List<Item> retrieveAllItems() {
		List<Item> items = repository.findAll();
		
		for(Item item:items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		
		return items;	
	}
	
}
