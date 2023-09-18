package com.digitalwave.recrutatech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="job")

public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "job_id")
	private long id;
	
	@Column(name="job_title")
	private String title;
	
	@Column(name="job_level")
	private String level;
	
	@Column(name="job_description")
	private String description;
	
	@Column (name="cha")
	private String cha;

	public Job(String title, String level, String description, String cha) {
		this.title = title;
		this.level = level;
		this.description = description;
		this.cha= cha;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getCha() {
		return cha;
	}

	public void setCha(String cha) {
		this.cha = cha;
	}


}


