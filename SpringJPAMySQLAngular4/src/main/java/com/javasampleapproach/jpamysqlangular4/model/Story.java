package com.javasampleapproach.jpamysqlangular4.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "story")
public class Story implements Serializable {
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	private QuestionType qType;
	
	@ManyToOne
	private StoryType sType;
	
	@ManyToOne
	private Project project;
	
	@ManyToOne
	private Company company;

	
	public Story(String title, String situation, String taskAction, String result, QuestionType qType, StoryType sType,
			Project project, Company company) {
		super();
		this.title = title;
		this.situation = situation;
		this.taskAction = taskAction;
		this.result = result;
		this.qType = qType;
		this.sType = sType;
		this.project = project;
		this.company = company;
	}
	
	public Story(Story copy){
		this(copy.title, copy.situation, 
				copy.taskAction, copy.result,
				copy.qType, copy.sType, copy.project, 
				copy.company);
	}

	protected Story() {
		super();
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

	public QuestionType getqType() {
		return qType;
	}

	public void setqType(QuestionType qType) {
		this.qType = qType;
	}

	public StoryType getsType() {
		return sType;
	}

	public void setsType(StoryType sType) {
		this.sType = sType;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", title=" + title + ", situation=" + situation + ", taskAction=" + taskAction
				+ ", result=" + result + ", qType=" + qType + ", sType=" + sType + ", project=" + project + ", company="
				+ company + "]";
	}
	
	
	
}
