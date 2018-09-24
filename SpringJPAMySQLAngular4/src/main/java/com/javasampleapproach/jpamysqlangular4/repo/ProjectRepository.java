package com.javasampleapproach.jpamysqlangular4.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.jpamysqlangular4.model.Company;
import com.javasampleapproach.jpamysqlangular4.model.Project;


public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project> findByName(String name);
	List<Project> findByCompany(Company company);
}
