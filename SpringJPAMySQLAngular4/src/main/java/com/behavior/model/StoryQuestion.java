package com.behavior.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//@Entity
//@Table(name = "story_question")
public class StoryQuestion implements Serializable {
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@JsonIgnore
	@JsonManagedReference
	@ManyToOne
    @JoinColumn(name = "story_id")
	private Story story;

	
	@JsonManagedReference
	@ManyToOne
    @JoinColumn(name = "question_id")
	private Question question;
	
	@Column(name = "date_created")
	private LocalDateTime dateCreated;
	
	public StoryQuestion(Story s, Question q) {
		super();
		this.story = s;
		this.question = q;
		this.dateCreated = LocalDateTime.now(); //Calendar.getInstance().getTime();
	}
	
	public StoryQuestion() {
		super();
		this.dateCreated = LocalDateTime.now();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Story_Question [" + id + ", question=" + question.getQuestion() + ", story=" + story.getTitle() + "]";
	}
	
}
