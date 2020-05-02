package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; 

@RestController()
@CrossOrigin()
public class TaskRestController {

	@Autowired
	private TaskRepository repository;

	@GetMapping("tasklist")
	public List<Task> getAll() {
		return repository.findAll();
	}
	
	@GetMapping("tasklist/{id}")
	public Optional<Task> getById(@PathVariable("id")int id) {
		return repository.findById(id);
	}
	
	
	@PostMapping("tasklist")
	public Task createNewTask(@RequestBody Task task) {
		return repository.save(task);
	}
	
	@PutMapping("tasklist/{id}")
	public Task updateTask(@PathVariable("id")int id,@RequestBody Task task) {
		task.setId(id);
		return repository.save(task);
	}
}
