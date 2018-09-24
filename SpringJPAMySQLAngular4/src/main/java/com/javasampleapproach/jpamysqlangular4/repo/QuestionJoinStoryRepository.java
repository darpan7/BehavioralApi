package com.javasampleapproach.jpamysqlangular4.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.jpamysqlangular4.model.Question;
import com.javasampleapproach.jpamysqlangular4.model.QuestionJoinStory;

public interface QuestionJoinStoryRepository extends CrudRepository<QuestionJoinStory, Long>{
	List<QuestionJoinStory> findByQuestion(Question question);
}
