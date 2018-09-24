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
@Table(name = "question")
public class Question implements Serializable {
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "question")
	private String question;
	
	//@ManyToOne
	//private QuestionType qType;
	
	@Column(name = "date_created")
	private Date dateCreated;

	/*protected Question(String question, QuestionType qtype) {
		super();
		this.question = question;
		this.qType = qtype;
		this.dateCreated = Calendar.getInstance().getTime();
	}*/
	
	protected Question(String question) {
		super();
		this.question = question;
		this.dateCreated = Calendar.getInstance().getTime();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

//	public QuestionType getqType() {
//		return qType;
//	}
//
//	public void setqType(QuestionType qType) {
//		this.qType = qType;
//	}
	
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

//	@Override
//	public String toString() {
//		return "Question [" + id + "= " + question + ", qType=" + qType + "]";
//	}

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
		Question other = (Question) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
