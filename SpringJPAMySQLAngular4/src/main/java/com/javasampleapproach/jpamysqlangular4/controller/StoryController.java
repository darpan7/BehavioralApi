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
import com.javasampleapproach.jpamysqlangular4.repo.StoryRepository;
import com.javasampleapproach.jpamysqlangular4.repo.Story_QuestionRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StoryController {
	
	@Autowired
	StoryRepository storyService;
	
	@Autowired
	Story_QuestionRepository storyToQuestionService;
	
	@GetMapping(value="/story",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Story> getAll() {
		//Map<Story, Iterable<Question>> map_story_to_questions = new HashMap<>();
		List<Story> list = new ArrayList<>();
		Iterable<Story> stories = storyService.findAll();
		
		/*stories.forEach(story -> {
			Iterable<Question> questions = this.storyToQuestionService.findByStory(story);
			map_story_to_questions.put(story, questions);
		});*/
		stories.forEach(list::add);
		return list;
	}
	
	@PostMapping(value="/plusstory")
	public Story addStory(@RequestBody Story story) {

		storyService.save(new Story(story));
		return story;
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
	
	@GetMapping(value="/story/findbyproject/{projectid}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Story> findByProject(@PathVariable long projectid) {

		List<Story> stories = storyService.findByProject(projectService.findOne(projectid));
		return stories;
	}

	@GetMapping(value="/story/findbycompany/{companyid}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Story> findByCompany(@PathVariable long companyid) {

		List<Story> stories = storyService.findByCompany(companyService.findOne(companyid));
		return stories;
	}
	
	@GetMapping(value="/story/findbyquestion/{questionid}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Story> findByQuestion(@PathVariable long questionid) {

		List<QuestionJoinStory> qTostoryList = questionTostoryService.findByQuestion(questionService.findOne(questionid));
		List<Story> stories = new ArrayList<Story>();
		qTostoryList.forEach(join -> stories.add(join.getStory()));
		return stories;
	}*/
	
	@DeleteMapping(value="/minusstory/{id}")
	public void deleteStory(@PathVariable long id){
		
		storyService.delete(id);
	}

}
