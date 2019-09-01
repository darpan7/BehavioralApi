package com.behavior.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.behavior.model.Question;
import com.behavior.repo.CompanyRepository;
import com.behavior.repo.QuestionRepository;
import com.behavior.repo.StoryRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class QuestionController {
	
	@Autowired
	StoryRepository storyService;
	
	//@Autowired
	//Story_QuestionRepository storyToQuestionService;
	
	@Autowired
	QuestionRepository questionService;
	
	@Autowired
	CompanyRepository companyService;
	
	@GetMapping(value="/questions",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Question> getAll() {
		System.out.println("Calling questions request.....");
		List<Question> list = new ArrayList<>();
		Iterable<Question> questions = this.questionService.findAll();
		questions.forEach(list::add);
//		System.out.println("waiting for 1 seconds...");
//		try {
//			TimeUnit.SECONDS.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("Questions: "+ list);
		return list;
	}
	
	/*@PostMapping(value="/insert_story")
	public Question addStory(@RequestBody Question story) {
		this.storyService.save(new Question(story));
		return story;
	}*/

//	@GetMapping(value="/questions/story/{story_id}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public Iterable<Question> questionsByStory(@PathVariable long story_id) {
//		return this.questionService.findByStory(this.storyService.findOne(story_id));
//	}
	
	/*@GetMapping(value="/story/findbyquestiontype/{questionType}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Question> findByQType(@PathVariable String questionType) {

		List<Question> stories = storyService.findByQType(qTypeService.findOne(questionType));
		return stories;
	}
	
	@GetMapping(value="/story/findbystorytype/{storyType}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Question> findBySType(@PathVariable String sType) {

		List<Question> stories = storyService.findBySType(sTypeService.findOne(sType));
		return stories;
	}
	
	
	@GetMapping(value="/story/byCompany/{companyid}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Question> findByCompany(@PathVariable long companyid) {
		List<Question> stories = this.storyService.findByCompany(this.companyService.findOne(companyid));
		return stories;
	}
	*/
	
	@GetMapping(value="/story/byQuestion/{questionid}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public Question findById(@PathVariable long question_id) {
		return this.questionService.findOne(question_id);
	}
	
	/*
	@DeleteMapping(value="/remove_story/{id}")
	public void deleteStory(@PathVariable long id){
		this.storyService.delete(id);
	}
	*/
}
