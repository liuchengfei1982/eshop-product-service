package com.roncoo.eshop.product.controller;

import com.roncoo.eshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roncoo.eshop.product.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	//http://localhost:8762/product/add?name=热门产品&categoryId=10&brandId=3&id=3
	@RequestMapping("/add") 
	@ResponseBody
	public String add(Product product,String operationType) {
		try {
			productService.add(product,operationType);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}

	//http://localhost:8762/product/update?id=2&name=最热销产品&categoryId=5&brandId=2
	@RequestMapping("/update") 
	@ResponseBody
	public String update(Product product,String operationType) {
		try {
			productService.update(product,operationType);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	//http://localhost:8762/product/delete?id=1
	@RequestMapping("/delete") 
	@ResponseBody
	public String delete(Long id,String operationType) {
		try {
			productService.delete(id,operationType);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}

	//http://localhost:8762/product/findById?id=1
	@RequestMapping("/findById") 
	@ResponseBody
	public Product findById(Long id){
		try {
			return productService.findById(id);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new Product();
	}
	
}
