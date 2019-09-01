package com.behavior.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.behavior.model.Question;
import com.behavior.model.Story;
import com.behavior.model.StoryQuestion;

//public interface Story_QuestionRepository extends CrudRepository<Story_Question, Long>{
//	List<Story_Question> findByQuestion(Question question);
//	Iterable<Question> findByStory(Story story);
//}

public interface StoryQuestionRepository {
	//List<Story_Question> findByQuestion(Question question);
	//Iterable<Question> findByStory(Story story);
}