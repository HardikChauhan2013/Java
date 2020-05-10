package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todo")
public class TodoDocument {

	@Id
	private int Id;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	private String taskName;
	 
	private boolean complate;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public boolean isComplate() {
		return complate;
	}

	public void setComplate(boolean complate) {
		this.complate = complate;
	}
	
	//private List<TodoLog> log;
	
}

/*
 * class TodoLog{ private String log; }
 */

