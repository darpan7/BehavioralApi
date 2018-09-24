package com.javasampleapproach.jpamysqlangular4.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.jpamysqlangular4.model.Company;
import com.javasampleapproach.jpamysqlangular4.model.QuestionType;
import com.javasampleapproach.jpamysqlangular4.model.Story;
import com.javasampleapproach.jpamysqlangular4.model.StoryType;

public interface StoryRepository extends CrudRepository<Story, Long>{
	List<Story> findByQType(QuestionType qType);
	List<Story> findBySType(StoryType qType);
	List<Story> findByCompany(Company company);
}
