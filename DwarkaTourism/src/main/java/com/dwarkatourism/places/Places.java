package com.dwarkatourism.places;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Places {
	private Integer id;
	
	@Size(min=5, message="Name should have atleast two characters")
	private String name;
	
	@NotNull
	private String desc;
	
	@Future
	private Date contentCreate;
	
	protected Places(){}
	
	public Places(Integer id, String name, String desc, Date contentCreate) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.contentCreate = contentCreate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getContentCreate() {
		return contentCreate;
	}
	public void setContentCreate(Date contentCreate) {
		this.contentCreate = contentCreate;
	}
	@Override
	public String toString() {
		return "Places [id=" + id + ", name=" + name + ", desc=" + desc + ", contentCreate=" + contentCreate + "]";
	}
	
	
}
