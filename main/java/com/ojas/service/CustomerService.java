package com.ojas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ojas.dao.CustomerRepo;
import com.ojas.entity.CustomerEntity;
import com.ojas.exception.BusinessException;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo custRepo;
	
	public CustomerEntity addCust(CustomerEntity cust) {
		
			if(cust.getCust_name().isEmpty() ||cust.getCust_name().length()==0) {
				throw new BusinessException("601","pleaase send proper name ,it is blank");
			}
			try {
		return custRepo.save(cust);
		
	}
		catch(IllegalArgumentException e) {
			throw new
			BusinessException("602","given employee is null"+e.getMessage()); }
		catch(Exception e1) {
			throw new BusinessException("603","something went wrong service layer save the employee  "+e1.getMessage());
		}
	}
	public CustomerEntity getProductById( int id) {
		try {
		return custRepo.findById(id).get();

		}catch(IllegalArgumentException e) { 
			throw new
			BusinessException("604","given employee is null"+e.getMessage()); 
		}catch(java.util.NoSuchElementException e) { throw new
			BusinessException("605","given employee id does not exist"+e.getMessage());
		}
		catch(Exception e) {
			throw new BusinessException("606","something went wrong service layer while fitching all employee"+e.getMessage());
		}
	}
	public List<CustomerEntity> listCust(){
	List<CustomerEntity> custList=null;	
	
		try {
		return custRepo.findAll();
	}catch(Exception e) {
		throw new BusinessException("609","something went wrong service layer while fitching all employee"+e.getMessage());
	}
		
		
	}
	public CustomerEntity updateCust(CustomerEntity cust) {
		try {
		return custRepo.save(cust);
		}
		catch(Exception e) {
			throw new BusinessException("610","something went wrong service layer while fitching all employee"+e.getMessage());
		}
		
	}
	
		 
	public void delete(int id) {
		try {
		 custRepo.deleteById(id);

	}catch(Exception e) {
		throw new BusinessException("608","given employee "+e.getMessage());
	}
	}

}
