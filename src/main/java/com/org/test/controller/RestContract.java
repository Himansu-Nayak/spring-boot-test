package com.org.test.controller;

import com.org.test.entity.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RestContract {

    ResponseEntity<Item> helloWorld(@RequestParam MultiValueMap<String, String> requestIds);

    ResponseEntity<List<Item>> itemFromBusinessService();

    List<Item> retrieveAllItems();
}
