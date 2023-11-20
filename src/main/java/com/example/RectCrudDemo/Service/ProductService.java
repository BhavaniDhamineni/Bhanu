package com.example.RectCrudDemo.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.RectCrudDemo.Exception.InvalidProductIDException;
import com.example.RectCrudDemo.model.Product;

@Service
public class ProductService {
	private static List<Product>data=new ArrayList();
	static {
		data.add(new Product(1,"iphone X",9999.99f));
		data.add(new Product(2,"iphone X",899.99f));
	}
	public ProductService() {
	}
	public List<Product>listAll(){
		return data;
	}
public boolean add(Product product) {
	data.add(product);
	return true;
}
public Product get(int id)throws InvalidProductIDException{
	boolean flag=false;
	for(Product p1:data)
	{
		if(p1.getId()==id) {
			flag=true;
			return p1;
		}
	}if(flag==false)
		throw new InvalidProductIDException("Id doesn't exist");
	return null;
	}
	//}
public String deleteProduct(int id) throws InvalidProductIDException{
	List<Product> p2=new ArrayList<>();
	if(id<=0)
		throw new InvalidProductIDException("product id is invalid");
	else {
		for(Product p:data) {
		if(p.getId()==id) {
			p2.add(p);
		}
	}
	data.removeAll(p2);
	return "product deleted successfully";
}
}
public String UpdateProduct(int id) throws InvalidProductIDException{
	if(id<=0)
		throw new InvalidProductIDException("product id is invalid");

	else {
		for(Product p:data) {
		if(p.getId()==id) {
			p.setName("washing machine");
		}
	}
	
	return "Updated";
}

}
}
