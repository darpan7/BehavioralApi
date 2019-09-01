package com.behavior.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.behavior.model.Company;
import com.behavior.model.Story;
import com.behavior.repo.CompanyRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CompanyController {
	
	@Autowired
	CompanyRepository companyService;
	
	@GetMapping(value="/companies",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Company> getAll() {
		List<Company> list = new ArrayList<>();
		Iterable<Company> companies = companyService.findAll();

		companies.forEach(list::add);
		return list;
	}
	
	@PostMapping(value="/companies")
	public Company addCompany(@RequestBody Company company) {
		return companyService.save(company);
	}
	
	@GetMapping(value="/companies/{id}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public Company findOne(@PathVariable long id) {
		Company company = companyService.findOne(id);
		return company;
	}
	
	@PutMapping(value="/companies/{id}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public Company updateCompany(@RequestBody Company company, @PathVariable long id) {
		Company db_company = companyService.findOne(id);
		company.setId(db_company.getId());
		return companyService.save(company);
	}
	
	@DeleteMapping(value="/companies/{id}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteCompany(@PathVariable long id) {
		companyService.delete(id);
		return companyService.findOne(id) == null? true: false;
	}


	@GetMapping(value="/company/findbyname/{name}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Company> findByName(@PathVariable String name) {
		List<Company> companies = companyService.findByName(name);
		return companies;
	}
	
	
	@GetMapping(value="/companies/{id}/stories",  produces=MediaType.APPLICATION_JSON_VALUE)
	public Set<Story> findStories(@PathVariable long id) {
		Company company = this.companyService.findOne(id);
		return company.getStories();
	}
}
