package com.roncoo.eshop.product.controller;

import com.roncoo.eshop.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roncoo.eshop.product.model.Category;


@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	//http://localhost:8762/category/add?name=手机&description=电子类
	@RequestMapping("/add") 
	@ResponseBody
	public String add(Category category,String operationType) {
		try {
			categoryService.add(category,operationType);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}

	//http://localhost:8762/category/update?name=手机&description=电子类&id=6
	@RequestMapping("/update") 
	@ResponseBody
	public String update(Category category,String operationType) {
		try {
			categoryService.update(category,operationType);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}

	//http://localhost:8762/category/delete?id=6
	@RequestMapping("/delete") 
	@ResponseBody
	public String delete(Long id,String operationType) {
		try {
			categoryService.delete(id,operationType);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}

	//http://localhost:8762/category/findById?id=6
	@RequestMapping("/findById") 
	@ResponseBody
	public Category findById(Long id){
		try {
			return categoryService.findById(id);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new Category();
	}
	
}