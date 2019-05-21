package com.roncoo.eshop.product.controller;

import com.roncoo.eshop.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roncoo.eshop.product.model.Brand;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	//http://localhost:8762/brand/add?name=huawei&description=中国品牌&operationType=refresh
	@RequestMapping("/add") 
	@ResponseBody
	public String add(Brand brand, String operationType) {
		try {
			brandService.add(brand,operationType);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	//http://localhost:8762/brand/update?name=huawei&description=北美品牌&id=2&operationType=/high/refresh
	@RequestMapping("/update") 
	@ResponseBody
	public String update(Brand brand, String operationType) {
		try {
			brandService.update(brand,operationType);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/delete") 
	@ResponseBody
	public String delete(Long id, String operationType) {
		try {
			brandService.delete(id,operationType);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	//http://localhost:8762/brand/findById?id=2
	@RequestMapping("/findById") 
	@ResponseBody
	public Brand findById(Long id){
		try {
			return brandService.findById(id);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new Brand();
	}

	@RequestMapping("/findByIds")
	@ResponseBody
	public List<Brand> findByIds(String ids){
		try {
			return brandService.findByIds(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Brand>();
	}
}
