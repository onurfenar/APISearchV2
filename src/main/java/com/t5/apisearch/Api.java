package com.t5.apisearch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Api {
    @Id
    @SequenceGenerator(name = "eSGen", sequenceName = "employeeSeq",
            initialValue = 50)
    @GeneratedValue(generator = "eSGen")
    
    private long id;
    private long user_id;
    private long application_id;
    private String name;
    private String description;
    private String category;
    private String isactive;
    private String sample_uri;    
    private String sample_request;
    private String sample_response;
    

    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getApplication_id() {
		return application_id;
	}
	public void setApplication_id(long application_id) {
		this.application_id = application_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public String getSample_uri() {
		return sample_uri;
	}
	public void setSample_uri(String sample_uri) {
		this.sample_uri = sample_uri;
	}
	public String getSample_request() {
		return sample_request;
	}
	public void setSample_request(String sample_request) {
		this.sample_request = sample_request;
	}
	public String getSample_response() {
		return sample_response;
	}
	public void setSample_response(String sample_response) {
		this.sample_response = sample_response;
	}

}