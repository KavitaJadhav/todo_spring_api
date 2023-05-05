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

    public List<Todo> findAll(String username) {
        return todos;
    }
}
