package com.roncoo.eshop.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roncoo.eshop.product.model.ProductSpecification;
import com.roncoo.eshop.product.service.ProductSpecificationService;

@RestController
@RequestMapping("/product-specification")
public class ProductSpecificationController {

	@Autowired
	private ProductSpecificationService productSpecificationService;

	//http://localhost:8762/product-specification/add?id=1&name=iphone的手机规格&value=2017-3&productId=2
	@RequestMapping("/add") 
	@ResponseBody
	public String add(ProductSpecification productSpecification,String operationType) {
		try {
			productSpecificationService.add(productSpecification,operationType);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/update") 
	@ResponseBody
	public String update(ProductSpecification productSpecification,String operationType) {
		try {
			productSpecificationService.update(productSpecification,operationType);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/delete") 
	@ResponseBody
	public String delete(Long id,String operationType) {
		try {
			productSpecificationService.delete(id,operationType);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/findById") 
	@ResponseBody
	public ProductSpecification findById(Long id){
		try {
			return productSpecificationService.findById(id);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new ProductSpecification();
	}

	@RequestMapping("/findByProductId")
	@ResponseBody
	public ProductSpecification findByProductId(Long productId){
		try {
			return productSpecificationService.findByProductId(productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ProductSpecification();
	}
	
}
