package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.entity.CustomerEntity;
@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

}
