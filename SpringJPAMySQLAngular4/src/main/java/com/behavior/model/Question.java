package com.behavior.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "question")
public class Question implements Serializable {
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 500)
	@Column(name = "question")
	private String question;
	
	@ManyToOne
	private QuestionType qType;
	
	@Column(name = "date_created")
	private Date dateCreated;

//	@ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "story_question",
//        joinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id"),
//        inverseJoinColumns = @JoinColumn(name = "story_id", referencedColumnName = "id"))
//    private Set<Story> stories;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
	@JoinTable(name = "question_story", 
	joinColumns = @JoinColumn(name = "story_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id"))
	private Set<Story> stories;
	
	//@JsonIgnore
//	@JsonBackReference
//	@OneToMany(mappedBy = "question")
//	private Set<StoryQuestion> stories = new HashSet<>();
	
//	public Question(String question, QuestionType qtype, Story...stories) {
//		super();
//		this.question = question;
//		this.qType = qtype;
////		this.stories = Stream.of(stories).collect(Collectors.toSet());
////      this.stories.forEach(x -> x.getQuestions().add(this));
//		this.dateCreated = Calendar.getInstance().getTime();
//	}
	
	public Question() {
		
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

	@Override
	public String toString() {
		return "Question [" + id + "= " + question + ", qType=" + qType + "]";
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
		Question other = (Question) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
