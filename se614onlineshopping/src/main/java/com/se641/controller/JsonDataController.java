/**
 * 
 */
package com.se641.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se641.se641backend.dao.ProductDAO;
import com.se641.se641backend.model.Product;

/**
 * @author zknab Provides data JSON format and adds RequestMapping of JSON/DATA
 *
 */
@Controller
@RequestMapping("json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getProductAll() {
		return productDAO.activeProductList();
	}

	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductByCat(@PathVariable int id){
		return  productDAO.activeProductListByCategory(id);
	}
}
