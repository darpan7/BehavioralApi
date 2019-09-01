package com.behavior.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.behavior.model.Company;
import com.behavior.model.Question;
import com.behavior.model.Story;
import com.behavior.model.StoryType;

public interface StoryRepository extends CrudRepository<Story, Long>{
//	List<Story> findBySType(StoryType sType);
//	List<Story> findByCompany(Company company);
	//List<Story> findByQuestion(Question question);
}
