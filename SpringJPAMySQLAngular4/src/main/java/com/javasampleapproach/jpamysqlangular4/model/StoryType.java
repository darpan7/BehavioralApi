package com.javasampleapproach.jpamysqlangular4.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "storyType")
public class StoryType implements Serializable{
	private static final long serialVersionUID = -3009157732242241606L;
	
	@Id
	@Column(name = "type")
	private String type;

	protected StoryType() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "StoryType [type=" + type + "]";
	}

	
}
