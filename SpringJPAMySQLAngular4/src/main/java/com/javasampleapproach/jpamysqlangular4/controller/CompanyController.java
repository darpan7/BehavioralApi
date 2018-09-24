package com.javasampleapproach.jpamysqlangular4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.jpamysqlangular4.model.Company;
import com.javasampleapproach.jpamysqlangular4.repo.CompanyRepository;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyRepository companyService;
	
	@GetMapping(value="/company",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Company> getAll() {
		List<Company> list = new ArrayList<>();
		Iterable<Company> companies = companyService.findAll();

		companies.forEach(list::add);
		return list;
	}
	
	@PostMapping(value="/pluscompany")
	public Company addCompany(@RequestBody Company company) {

		companyService.save(new Company(company));
		return company;
	}
	
	@PostMapping(value="/updatecompany")
	public Company updateCompany(@RequestBody Company company) {
		companyService.save(company);
		return company;
	}

	@GetMapping(value="/company/findbyname/{name}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Company> findByName(@PathVariable String name) {

		List<Company> companies = companyService.findByName(name);
		return companies;
	}
	
	@GetMapping(value="/company/findbyid/{id}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public Company findOne(@PathVariable long id) {
		System.out.println("call came here!");
		Company company = companyService.findOne(id);
		System.out.println("Found company : " + company);
		return company;
	}
	
	@DeleteMapping(value="/minuscompany/{id}")
	public void deleteCompany(@PathVariable long id){
		
		companyService.delete(id);
	}
}
