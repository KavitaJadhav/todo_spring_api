package com.todo.todo_spring_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {
    @Autowired
    TodoHardCodedService todoHardCodedService;

    @GetMapping("users/{username}/todos")
    public List<Todo> getTodos(@PathVariable String username) {
        return todoHardCodedService.findAll(username);
    }
    @GetMapping("todos")
    public List<Todo> todos() {
        return todoHardCodedService.findAll("username");
    }
}
