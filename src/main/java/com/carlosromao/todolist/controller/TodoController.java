package com.carlosromao.todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlosromao.todolist.entity.Todo;
import com.carlosromao.todolist.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@PostMapping
	List<Todo> create(@Valid @RequestBody Todo todo) {
		return todoService.create(todo);
	}
	
	@GetMapping
	List<Todo> list() {
		return todoService.list();
	}
	
	@GetMapping("{id}")
	Todo getById(@PathVariable Long id) {
		return todoService.getById(id);
	}
	
	@PutMapping
	List<Todo> update(@RequestBody Todo todo) {
		return todoService.update(todo);
	}
	
	@DeleteMapping("{id}")
	List<Todo> delete(@PathVariable("id") Long id) {
		return todoService.delete(id);
	}
}
