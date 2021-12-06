package com.ojas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.entity.CustomerEntity;
import com.ojas.exception.BusinessException;
import com.ojas.exception.ControllerException;
import com.ojas.service.CustomerService;

@RestController
@RequestMapping("/api/rest")
public class CustomerController {
	
	@Autowired
	private CustomerService custSer;
	@ExceptionHandler(Exception.class)  
	@PostMapping("/add")
	public ResponseEntity<CustomerEntity> addCust( @RequestBody  CustomerEntity cust) {
		try {
		return new ResponseEntity(custSer.addCust(cust),HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerException ce=new ControllerException("611","something went wrong n controller");
			return new ResponseEntity(ce,HttpStatus.BAD_REQUEST);
		}
	}
	

	@GetMapping("/list")
	public ResponseEntity<List<?>> listCust(){
		
		return new ResponseEntity<List<?>>(custSer.listCust(),HttpStatus.OK);
		
	}
	@PostMapping("/update")
	public ResponseEntity<CustomerEntity> updateCust( @RequestBody  CustomerEntity cust) {
		return new ResponseEntity<CustomerEntity>(custSer.updateCust(cust),HttpStatus.OK);
		
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<CustomerEntity>  getProductById(@PathVariable int id) {
		try {
		return new ResponseEntity<CustomerEntity>(custSer. getProductById(id),HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerException ce=new ControllerException("612","this id not there");
			return new ResponseEntity(ce,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/DelId")
	public void delete(int id) {
		custSer.delete(id);

}
}
