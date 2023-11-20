package com.example.RectCrudDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.RectCrudDemo.Exception.InvalidProductIDException;
import com.example.RectCrudDemo.Service.ProductService;
import com.example.RectCrudDemo.model.Product;

@RestController
public class ProductController {
@Autowired
ProductService service;

@GetMapping("/listall")
public List<Product> list(){
	return service.listAll();
}

@RequestMapping(value="/addproduct", method=RequestMethod.POST)
public Product add(@RequestBody Product product) {
	service.add(product);
	System.out.println(product);
	return product;
}
@GetMapping("/hello/{name}/{name1}")
public String say(@PathVariable("name") String name, @PathVariable("name") String name1)
{
	return name1+name1;
}
@RequestMapping(value="/getproduct/{id}", method=RequestMethod.GET)
public Product getProduct(@PathVariable("id") int i) {
	System.out.println(i);
	Product product=null;
	try {
		product = service.get(i);
		return product;
	}catch(Exception e) {
		System.out.println(e);
	}
	return product;
}
@PutMapping(value="/updateProduct/{id}")
public String update(@PathVariable("id") int id) {
	try {
		
		return service.UpdateProduct(id);
	}catch(InvalidProductIDException e) {
	return e.getMessage();
}
}
@DeleteMapping(value="/deleteProduct/{id}")
	public String delete(@PathVariable("id") int id) {
		try {
			
			return service.deleteProduct(id);
		}catch(InvalidProductIDException e) {
		return e.getMessage();
	}
}
}
