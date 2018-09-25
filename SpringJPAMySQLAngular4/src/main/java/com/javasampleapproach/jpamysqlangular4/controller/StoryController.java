package com.javasampleapproach.jpamysqlangular4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.jpamysqlangular4.model.Story;
import com.javasampleapproach.jpamysqlangular4.model.Story_Question;
import com.javasampleapproach.jpamysqlangular4.repo.CompanyRepository;
import com.javasampleapproach.jpamysqlangular4.repo.QuestionRepository;
import com.javasampleapproach.jpamysqlangular4.repo.StoryRepository;
import com.javasampleapproach.jpamysqlangular4.repo.Story_QuestionRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StoryController {
	
	@Autowired
	StoryRepository storyService;
	
	@Autowired
	Story_QuestionRepository storyToQuestionService;
	
	@Autowired
	QuestionRepository questionService;
	
	@Autowired
	CompanyRepository companyService;
	
	@GetMapping(value="/story",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Story> getAll() {
		List<Story> list = new ArrayList<>();
		Iterable<Story> stories = storyService.findAll();
		stories.forEach(list::add);
		return list;
	}
	
	@PostMapping(value="/insert_story")
	public Story addStory(@RequestBody Story story) {
		this.storyService.save(new Story(story));
		return story;
	}

	@GetMapping(value="/story/{story_id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Story findById(@PathVariable long story_id) {
		return this.storyService.findOne(story_id);
	}
	
	/*@GetMapping(value="/story/findbyquestiontype/{questionType}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Story> findByQType(@PathVariable String questionType) {

		List<Story> stories = storyService.findByQType(qTypeService.findOne(questionType));
		return stories;
	}
	
	@GetMapping(value="/story/findbystorytype/{storyType}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Story> findBySType(@PathVariable String sType) {

		List<Story> stories = storyService.findBySType(sTypeService.findOne(sType));
		return stories;
	}
	*/
	
	@GetMapping(value="/story/byCompany/{companyid}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Story> findByCompany(@PathVariable long companyid) {
		List<Story> stories = this.storyService.findByCompany(this.companyService.findOne(companyid));
		return stories;
	}
	
	@GetMapping(value="/story/byQuestion/{questionid}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Story> findByQuestion(@PathVariable long question_id) {

		List<Story_Question> qTostoryList = this.storyToQuestionService.findByQuestion(this.questionService.findOne(question_id));
		List<Story> stories = new ArrayList<Story>();
		qTostoryList.forEach(join -> stories.add(join.getStory()));
		return stories;
	}
	
	@DeleteMapping(value="/remove_story/{id}")
	public void deleteStory(@PathVariable long id){
		this.storyService.delete(id);
	}

}
