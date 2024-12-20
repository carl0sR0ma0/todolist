package com.carlosromao.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.carlosromao.todolist.entity.Todo;
import com.carlosromao.todolist.repository.TodoRepository;

@Service
public class TodoService {
	private TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public List<Todo> create(Todo todo) {
		todoRepository.save(todo);
		return list();
	}
	
	public List<Todo> list() {
		Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
		return todoRepository.findAll(sort);
	}
	
	public Todo getById(Long id) {
		return todoRepository.findById(id).orElse(null);
	}

	public List<Todo> update(Todo todo) {
		todoRepository.save(todo);
		return list();
	}
	
	public List<Todo> delete(Long id) {
		todoRepository.deleteById(id);
		return list();
	}
}
