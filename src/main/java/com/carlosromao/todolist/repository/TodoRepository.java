package com.carlosromao.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlosromao.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}