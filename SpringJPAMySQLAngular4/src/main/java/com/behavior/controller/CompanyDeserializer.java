package com.behavior.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.behavior.model.Company;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class CompanyDeserializer extends JsonDeserializer<Company> {
    @Override
    public Company deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    	JsonNode node = jp.getCodec().readTree(jp);
        String joined = node.get("joinedAt").asText();
        String left = node.get("leftAt").asText();
        String startSal = node.get("startSalary").asText();
        String endSal = node.get("endSalary").asText();
        String imgpath = node.get("imagePath").asText();
        String job = node.get("jobTitle").asText();
        String name = node.get("name").asText();
        
		Date leftat = null;
		Date joinedat = null;
		try{
			joinedat = new SimpleDateFormat("yyyy-MM-dd").parse(joined);
		}catch (ParseException e) {
			System.out.println("Parsing error for joinedat: " + e.getMessage());
		}
		try {
			leftat = new SimpleDateFormat("yyyy-MM-dd").parse(left);
		}catch (ParseException e) {
			System.out.println("Parsing error for leftat: " + e.getMessage());
		}
		Double strt = Double.valueOf(0);
		Double end = Double.valueOf(0);
		try {
			strt = Double.valueOf(startSal);
		} catch (NumberFormatException | NullPointerException e) {
			System.out.println("Exception occurred for start salary: " + e.getMessage());
		}
		try {
			end = Double.valueOf(endSal);
		} catch (NumberFormatException | NullPointerException e) {
			System.out.println("Exception occurred for end salary: " + e.getMessage());
		}
		Company company = new Company();
		company.setJoinedAt(joinedat);
		company.setLeftAt(leftat);
		company.setStartSalary(strt);
		company.setEndSalary(end);
		company.setImagePath(imgpath);
		company.setName(name);
		company.setJobTitle(job);
		return company;
    }
    
//    public static void main(String[] args) {
//    	String joined = "2019-07-28";
//    	try {
//			Date joinedat = new SimpleDateFormat("yyyy-MM-dd").parse(joined);
//			System.out.println(joined + " == " + joinedat);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//    	System.out.println(Double.valueOf(null));
//    	System.out.println(Double.valueOf(""));
//    	System.out.println(Double.valueOf("123.54"));
//    	System.out.println(Double.valueOf("123000.54"));
//	}
}
