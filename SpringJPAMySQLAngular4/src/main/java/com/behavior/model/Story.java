package com.behavior.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.behavior.controller.StoryDeserializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonDeserialize(using = StoryDeserializer.class)
@Entity
@Table(name = "story")
public class Story implements Serializable {
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "title")
	private String title;
	
	@Column(name = "situation")
	private String situation;
	
	@Column(name = "action")
	private String taskAction;
	
	@Column(name = "result")
	private String result;
	
	@ManyToOne
	private StoryType sType;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	@Column(name = "date_created")
	private Date dateCreated;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
	@JsonBackReference
    @JoinTable(name = "question_story",
            joinColumns = { @JoinColumn(name = "question_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "story_id", referencedColumnName = "id") })
    private Set<Question> questions = new HashSet<>();
	
	//@ManyToMany(mappedBy = "stories")
	//private Set<Question> questions = new HashSet<>();
	
//	@JsonBackReference
//	@OneToMany(mappedBy = "story")
//	private Set<StoryQuestion> questions = new HashSet<>();

	
//	public Story(String title, String situation, String taskAction, String result, StoryType sType,
//			Company company) {
//		super();
//		this.title = title;
//		this.situation = situation;
//		this.taskAction = taskAction;
//		this.result = result;
//		this.sType = sType;
//		this.company = company;
//		this.dateCreated = Calendar.getInstance().getTime();
//	}
	
//	public Story(String title, Question...questions){
//		this(title, null, null, null, null, null);
//		this.questions = Stream.of(questions).collect(Collectors.toSet());
//        this.questions.forEach(x -> x.getStories().add(this));
//	}
	
//	public Story(Story copy){
//		this(copy.title, copy.situation, 
//				copy.taskAction, copy.result,
//				copy.sType,	copy.company);
//	}

	public Story() {
		this.dateCreated = Calendar.getInstance().getTime();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getTaskAction() {
		return taskAction;
	}

	public void setTaskAction(String taskAction) {
		this.taskAction = taskAction;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public StoryType getsType() {
		return sType;
	}

	public void setsType(StoryType sType) {
		this.sType = sType;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	
	@Override
	public String toString() {
		return "Story [id=" + id + ", title=" + title + ", situation=" + situation + ", taskAction=" + taskAction
				+ ", result=" + result + ", sType=" + sType + ", company=" + company + ", dateCreated=" + dateCreated
				+ ", questions=" + questions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Story other = (Story) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
