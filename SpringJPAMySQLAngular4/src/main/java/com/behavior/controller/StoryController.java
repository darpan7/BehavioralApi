package com.behavior.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

import com.behavior.model.Question;
import com.behavior.model.Story;
import com.behavior.repo.CompanyRepository;
import com.behavior.repo.QuestionRepository;
import com.behavior.repo.StoryRepository;
import com.behavior.repo.StoryTypeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StoryController {
	
	@Autowired
	StoryRepository storyService;
	
	//@Autowired
	//Story_QuestionRepository storyToQuestionService;
	
	@Autowired
	QuestionRepository questionService;
	
	@Autowired
	CompanyRepository companyService;
	
	@Autowired
	StoryTypeRepository sTypeService;
	
	@GetMapping(value="/stories",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Story> getAll() {
		List<Story> list = new ArrayList<>();
		Iterable<Story> stories = storyService.findAll();
		stories.forEach(list::add);
		return list;
	}
	
	@PostMapping(value="/stories")
	public Story addStory(@RequestBody Story story) {
		System.out.println("STORY: " + story);
		return storyService.save(story);
	}

	@GetMapping(value="/stories/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Story findById(@PathVariable long id) {
//		try {
//			TimeUnit.SECONDS.sleep(6);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return this.storyService.findOne(id);
	}
	
	@PutMapping(value="/stories/{id}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public Story updateStory(@RequestBody Story story, @PathVariable long id) {
		Story db_story = storyService.findOne(id);
		story.setId(db_story.getId());
		return storyService.save(story);
	}
	
	@DeleteMapping(value="/stories/{id}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteStory(@PathVariable long id) {
		storyService.delete(id);
		return storyService.findOne(id) == null? true: false;
	}

	
	@GetMapping(value="/stories/{id}/questions", produces=MediaType.APPLICATION_JSON_VALUE)
	public Set<Question> findQuestions(@PathVariable long id) {
		Story story = this.storyService.findOne(id);
		return story.getQuestions();
	}
	
	/*@GetMapping(value="/story/findbyquestiontype/{questionType}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Story> findByQType(@PathVariable String questionType) {

		List<Story> stories = storyService.findByQType(qTypeService.findOne(questionType));
		return stories;
	}
	*/
	@GetMapping(value="/stories/findbystorytype/{stype_id}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Story> findBySType(@PathVariable long stype_id) {

//		List<Story> stories = this.storyService.findBySType(this.sTypeService.findOne(stype_id));
//		return stories;
		return null;
	}
	
	
	@GetMapping(value="/stories/byCompany/{companyid}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Story> findByCompany(@PathVariable long companyid) {
//		List<Story> stories = this.storyService.findByCompany(this.companyService.findOne(companyid));
//		return stories;
		return null;
	}
	
//	@GetMapping(value="/story/byQuestion/{questionid}",  produces=MediaType.APPLICATION_JSON_VALUE)
//	public List<Story> findByQuestion(@PathVariable long question_id) {
//
//		List<Story> stories = this.storyService.findByQuestion(this.questionService.findOne(question_id));
//		return stories;
//	}
	
}
