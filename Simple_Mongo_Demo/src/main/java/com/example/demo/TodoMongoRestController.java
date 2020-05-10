package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TodoMongoRestController {

	@Autowired
	private TodoRepository respository;

	@GetMapping(value = "/api/todo")
	public List getAll() {
		// NoSQL Query : todo.find({})
		// SQL Qeuery : select * from todo
		return respository.findAll();
	}

	@PostMapping(value = "/api/todo")
	public TodoDocument createTodo(@RequestBody() TodoDocument todo) {
		// NoSQL Query : todo.insert({})
		// SQL Qeuery : insert into todo ...


		//int id = select max(id) from todo
		
		return respository.save(todo);
	}

	/*
	 * @PutMapping(value = "/api/todo/{id}") public TodoDocument
	 * Update(@RequestBody() TodoDocument todo) { // NoSQL Query : todo.insert({})
	 * // SQL Qeuery : insert into todo ...
	 * 
	 * 
	 * //int id = select max(id) from todo
	 * 
	 * return respository.save(todo); }
	 */
}
