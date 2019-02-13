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

import com.javasampleapproach.jpamysqlangular4.model.Question;
import com.javasampleapproach.jpamysqlangular4.model.Story_Question;
import com.javasampleapproach.jpamysqlangular4.repo.CompanyRepository;
import com.javasampleapproach.jpamysqlangular4.repo.QuestionRepository;
import com.javasampleapproach.jpamysqlangular4.repo.StoryRepository;
import com.javasampleapproach.jpamysqlangular4.repo.Story_QuestionRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class QuestionController {
	
	@Autowired
	StoryRepository storyService;
	
	@Autowired
	Story_QuestionRepository storyToQuestionService;
	
	@Autowired
	QuestionRepository questionService;
	
	@Autowired
	CompanyRepository companyService;
	
	@GetMapping(value="/questions",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Question> getAll() {
		List<Question> list = new ArrayList<>();
		Iterable<Question> stories = this.questionService.findAll();
		stories.forEach(list::add);
		return list;
	}
	
	/*@PostMapping(value="/insert_story")
	public Question addStory(@RequestBody Question story) {
		this.storyService.save(new Question(story));
		return story;
	}*/

	@GetMapping(value="/questions/story/{story_id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Question> questionsByStory(@PathVariable String story_id) {
		return this.storyToQuestionService.findByStory(this.storyService.findOne(Long.parseLong(story_id)));
	}
	
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
	
	@GetMapping(value="/story/byQuestion/{questionid}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Question> findByQuestion(@PathVariable long question_id) {

		List<Story_Question> qTostoryList = this.storyToQuestionService.findByQuestion(this.questionService.findOne(question_id));
		List<Question> stories = new ArrayList<Question>();
		qTostoryList.forEach(join -> stories.add(join.getStory()));
		return stories;
	}
	
	@DeleteMapping(value="/remove_story/{id}")
	public void deleteStory(@PathVariable long id){
		this.storyService.delete(id);
	}
	*/
}
