package com.javasampleapproach.jpamysqlangular4.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

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
	private StoryType sType;
	
	@ManyToOne
	private Company company;
	
	@Column(name = "date_created")
	private Date dateCreated;

	
	public Story(String title, String situation, String taskAction, String result, StoryType sType,
			Company company) {
		super();
		this.title = title;
		this.situation = situation;
		this.taskAction = taskAction;
		this.result = result;
		this.sType = sType;
		this.company = company;
		this.dateCreated = Calendar.getInstance().getTime();
	}
	
	public Story(Story copy){
		this(copy.title, copy.situation, 
				copy.taskAction, copy.result,
				copy.sType,	copy.company);
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

	@Override
	public String toString() {
		return "Story [" + id + "= " + title + ", S: " + situation + ", company: " + company + "]";
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
