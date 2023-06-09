package in.gauravit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.gauravit.entity.Product;
import in.gauravit.repo.ProductRepository;

@RestController
public class ProductRestController {

@Autowired
private ProductRepository repo;

@PostMapping(value="/products",
consumes= {"application/json"})
public ResponseEntity<String> addProduct(@RequestBody Product product){
	 repo.save(product);
	
	return new ResponseEntity<>("Product saved",HttpStatus.CREATED);
}
@GetMapping(value="products",
produces= {"application/json"}
		)
public ResponseEntity<List<Product>> products(){
	List<Product> products = repo.findAll();
	return new ResponseEntity<>(products,HttpStatus.OK);
}
}