package com.behavior.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.behavior.model.Question;
import com.behavior.model.QuestionType;
import com.behavior.model.Story;

public interface QuestionRepository extends CrudRepository<Question, Long>{
//	List<Question> findByQType(QuestionType qType);
	//List<Question> findByStory(Story story);
}
