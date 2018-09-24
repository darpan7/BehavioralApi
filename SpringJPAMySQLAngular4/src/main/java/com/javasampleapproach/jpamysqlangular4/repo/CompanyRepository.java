package com.javasampleapproach.jpamysqlangular4.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.jpamysqlangular4.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
	List<Company> findByName(String name);
}