package com.ldg.coffee.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private int id;
	private String productname;
	private int price;
	private String content1;
	private String content2;
	private String content3;
	

}
