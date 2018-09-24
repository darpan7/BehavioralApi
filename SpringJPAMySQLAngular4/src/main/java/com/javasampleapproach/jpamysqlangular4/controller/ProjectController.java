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

import com.javasampleapproach.jpamysqlangular4.model.Project;
import com.javasampleapproach.jpamysqlangular4.repo.CompanyRepository;
import com.javasampleapproach.jpamysqlangular4.repo.ProjectRepository;

@RestController
public class ProjectController {
	
	@Autowired
	ProjectRepository projectService;
	
	@Autowired
	CompanyRepository companyService;
	
	@GetMapping(value="/project",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Project> getAll() {
		
		List<Project> list = new ArrayList<>();
		Iterable<Project> projects = projectService.findAll();

		projects.forEach(list::add);
		return list;
	}
	
	@PostMapping(value="/plusproject")
	public Project addProject(@RequestBody Project project) {
		System.out.println("Project from client: " + project);
		projectService.save(new Project(project));
		return project;
	}

	@GetMapping(value="/project/findbyname/{name}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Project> findByName(@PathVariable String name) {

		List<Project> projects = projectService.findByName(name);
		return projects;
	}
	
	@GetMapping(value="/project/findbycompany/{companyid}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Project> findByCompany(@PathVariable long companyid) {

		List<Project> projects = projectService.findByCompany(companyService.findOne(companyid));
		return projects;
	}
	
	@DeleteMapping(value="/minusproject/{id}")
	public void deleteProject(@PathVariable long id){
		
		projectService.delete(id);
	}

}
