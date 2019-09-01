package com.behavior.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.behavior.model.Company;
import com.behavior.model.Question;
import com.behavior.model.Story;
import com.behavior.repo.CompanyRepository;
import com.behavior.repo.QuestionRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StoryDeserializer extends JsonDeserializer<Story> {
	
	@Autowired
	QuestionRepository questionService;
	
	@Autowired
	CompanyRepository companyService;
	
	@Override
    public Story deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    	JsonNode node = jp.getCodec().readTree(jp);
    	System.out.println("....Printing json object....");
    	System.out.println(prettyPrintJsonString(node));
//    	return null;
    	String title = node.get("title").asText();
    	String task = node.get("taskAction").asText();
    	String result = node.get("result").asText();
    	String situation = node.get("situation").asText();
    	String companyid = node.get("selectedComapnyId").asText();
    	Integer company_id = companyid == null? null: Integer.parseInt(companyid);
    	Company c = companyid == null? null: this.companyService.findOne(Long.parseLong(companyid));
    	JsonNode qs = node.get("questions");
    	Set<Question> questions = new HashSet<>();
    	if (qs.isArray()){
    		for (JsonNode qnode: qs) {
    			questions.add(this.questionService.findOne(qnode.asLong()));
    		}
    	}
    	Story story = new Story();
    	story.setResult(result);
    	story.setTaskAction(task);
    	story.setSituation(situation);
    	story.setTitle(title);
    	story.setCompany(c);
    	story.setQuestions(questions);
    	
//        String joined = node.get("joinedAt").asText();
//        String left = node.get("leftAt").asText();
//        String startSal = node.get("startSalary").asText();
//        String endSal = node.get("endSalary").asText();
//        String imgpath = node.get("imagePath").asText();
//        String job = node.get("jobTitle").asText();
//        String name = node.get("name").asText();
//        
		return story;
    }
	
	public String prettyPrintJsonString(JsonNode jsonNode) {
	    try {
	        ObjectMapper mapper = new ObjectMapper();
	        Object json = mapper.readValue(jsonNode.toString(), Object.class);
	        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
	    } catch (Exception e) {
	        return "Sorry, pretty print didn't work";
	    }
	}
}
