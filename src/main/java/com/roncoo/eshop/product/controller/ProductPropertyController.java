package com.roncoo.eshop.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roncoo.eshop.product.model.ProductProperty;
import com.roncoo.eshop.product.service.ProductPropertyService;

@RestController
@RequestMapping("/product-property")
public class ProductPropertyController {

	@Autowired
	private ProductPropertyService productPropertyService;

	//http://localhost:8762/product-property/add?id=1&name=上市时间&value=2017-3&productId=2
	@RequestMapping("/add") 
	@ResponseBody
	public String add(ProductProperty productProperty,String operationType) {
		try {
			productPropertyService.add(productProperty,operationType);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}

	//http://localhost:8762/product-property/update?id=1&name=手机属性&value=红色&productId=1
	@RequestMapping("/update") 
	@ResponseBody
	public String update(ProductProperty productProperty,String operationType) {
		try {
			productPropertyService.update(productProperty,operationType);
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
			productPropertyService.delete(id,operationType);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/findById") 
	@ResponseBody
	public ProductProperty findById(Long id){
		try {
			return productPropertyService.findById(id);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new ProductProperty();
	}

	@RequestMapping("/findByProductId")
	@ResponseBody
	public ProductProperty findByProductId(Long productId){
		try {
			return productPropertyService.findByProductId(productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ProductProperty();
	}
	
}
