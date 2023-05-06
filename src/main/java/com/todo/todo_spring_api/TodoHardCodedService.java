package com.todo.todo_spring_api;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TodoHardCodedService {

    private static List<Todo> todos = new ArrayList();
    private static long counter = 0;

    static {
        todos.add(new Todo(++counter, "Kavita", "Learn Angular", new Date(), false));
        todos.add(new Todo(++counter, "Kavita", "Learn Quarkus", new Date(), false));
        todos.add(new Todo(++counter, "Kavita", "Learn React", new Date(), false));
        todos.add(new Todo(++counter, "Kavita", "Learn Grafana", new Date(), false));
    }

    private long idCounter;

    public List<Todo> findAll(String username) {
        return todos;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);
        if (todo == null) return null;
        todos.remove(todo);
        return todo;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) return todo;
        }
        return null;
    }

    public Todo create(Todo todo) {
        todo.setId(++idCounter);
        todos.add(todo);
        return todo;
    }

    public Todo save(Todo todo) {
        Todo oldTodo = findById(todo.getId());
        if (oldTodo == null) return null;

        deleteById(todo.getId());
        todos.add(todo);
        return todo;
    }
}
