package com.behavior.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.behavior.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
	List<Company> findByName(String name);
}