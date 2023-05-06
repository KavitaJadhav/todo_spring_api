package com.todo.todo_spring_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @DeleteMapping("users/{username}/todos/{id}")
    public ResponseEntity deleteTodo(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoHardCodedService.deleteById(id);
        if (todo != null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("users/{username}/todos/{id}")
    public ResponseEntity getTodo(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoHardCodedService.findById(id);
        if (todo == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(todo, HttpStatus.OK);
    }

    @PostMapping("users/{username}/todos")
    public ResponseEntity createTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo createdTodo = todoHardCodedService.create(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return new ResponseEntity(uri, HttpStatus.CREATED);
    }

    @PutMapping("users/{username}/todos/{id}")
    public ResponseEntity updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
        Todo updatedTodo = todoHardCodedService.save(todo);
        if (updatedTodo != null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
