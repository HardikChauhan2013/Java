package com.example.demo;

 
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface TaskRepository extends JpaRepositoryImplementation<Task, Integer> {

	
	
}
