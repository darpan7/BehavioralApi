package com.javasampleapproach.jpamysqlangular4.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.jpamysqlangular4.model.Question;
import com.javasampleapproach.jpamysqlangular4.model.Story;
import com.javasampleapproach.jpamysqlangular4.model.Story_Question;

public interface Story_QuestionRepository extends CrudRepository<Story_Question, Long>{
	List<Story_Question> findByQuestion(Question question);
	Iterable<Question> findByStory(Story story);
}
