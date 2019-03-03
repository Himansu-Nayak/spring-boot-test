package com.org.test.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.org.test.entity.Item;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	public void testFindAll() {
		List<Item> items = itemRepository.findAll();
		assertEquals(3,items.size());
	}

	@Test
	public void testFindOne() {
		Item item = itemRepository.findById(10001).get();
		
		assertEquals("Item1",item.getName());
	}

}
