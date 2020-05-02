package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 

@Entity
@Table(name = "Task")
public class Task{

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TASK_ID")
	private int id;
	
	@Column(name = "TASK_NAME")
	private String taskName;
	
	@Column(name="TASK_COMPLATED")
	private boolean complate;
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	
	
}
