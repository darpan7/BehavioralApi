package com.behavior.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.behavior.controller.CompanyDeserializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CompanyDeserializer.class)
@Entity
@Table(name = "company")
public class Company implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EST")
	@Column(name = "joined_at")
	private Date joinedAt;
	
	@Column(name = "left_at")
	private Date leftAt;
	
	@Column(name = "start_salary")
	private Double startSalary;
	
	@Column(name = "end_salary")
	private Double endSalary;
	
	@Column(name = "job_title")
	private String jobTitle;
	
//	@Lob
	@Column(columnDefinition = "TEXT", name = "image_path")
	private String imagePath;
	
	@Column(name = "date_created")
	private Date dateCreated;
	
	@JsonBackReference
	@OneToMany(mappedBy = "company")
	private Set<Story> stories = new HashSet<>();


	public Company() {
		this.dateCreated = Calendar.getInstance().getTime();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Set<Story> getStories() {
		return stories;
	}
	
	public void setStories(Set<Story> stories) {
		this.stories = stories;
	}

	public Date getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(Date joinedAt) {
		this.joinedAt = joinedAt;
	}

	public Date getLeftAt() {
		return leftAt;
	}

	public void setLeftAt(Date leftAt) {
		this.leftAt = leftAt;
	}

	public double getStartSalary() {
		return startSalary;
	}

	public void setStartSalary(double startSalary) {
		this.startSalary = startSalary;
	}

	public double getEndSalary() {
		return endSalary;
	}

	public void setEndSalary(double endSalary) {
		this.endSalary = endSalary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", joinedAt=" + joinedAt + ", leftAt=" + leftAt
				+ ", startSalary=" + startSalary + ", endSalary=" + endSalary + ", jobTitle=" + jobTitle
				+ ", imagePath=" + imagePath + ", dateCreated=" + dateCreated + "]";
	}
	
}
