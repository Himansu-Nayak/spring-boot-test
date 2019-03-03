package com.org.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
public class Item {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name="name")
	private String name;

	@Column(name = "price")
	private int price;

	@Column(name = "quantity")
	private int quantity;

	@Transient
	private int value;

	public Item(int id, String name, int price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
}
