package com.digitalwave.recrutatech.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conhecimento")
public class Conhecimento {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "c_content")
	    private String content;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

	    public void saveConhecimento(String jsonResponse) {
	        this.content = jsonResponse;
	    }

	    @Override
	    public String toString() {
	        return "Knowledge{" +
	                "Content='" + content + '\'' +
	                '}';
	    }

}
