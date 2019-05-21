package com.roncoo.eshop.product.model;

import lombok.Data;

@Data
public class ProductProperty {
	
	private Long id;
	private String name;
	private String value;
	private Long productId;
	

}
