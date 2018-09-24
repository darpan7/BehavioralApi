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
@Table(name = "question")
public class Question implements Serializable {
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "question")
	private String question;
	
	@ManyToOne
	private QuestionType qType;

	protected Question() {
		super();
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

	public QuestionType getqType() {
		return qType;
	}

	public void setqType(QuestionType qType) {
		this.qType = qType;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", qType=" + qType + "]";
	}
	
}
