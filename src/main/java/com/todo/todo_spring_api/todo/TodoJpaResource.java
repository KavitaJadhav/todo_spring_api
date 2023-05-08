package com.todo.todo_spring_api.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoJpaResource {

    @Autowired
    TodoJpaRepository todoJpaRepository;

    @GetMapping("jpa/users/{username}/todos")
    public List<Todo> getTodos(@PathVariable String username) {
        return todoJpaRepository.findByUsername(username);
    }

    @DeleteMapping("jpa/users/{username}/todos/{id}")
    public ResponseEntity deleteTodo(@PathVariable String username, @PathVariable long id) {
        todoJpaRepository.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("jpa/users/{username}/todos/{id}")
    public ResponseEntity getTodo(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoJpaRepository.findById(id).get();
        if (todo == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(todo, HttpStatus.OK);
    }

    @PostMapping("jpa/users/{username}/todos")
    public ResponseEntity createTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setUsername(username);
        Todo createdTodo = todoJpaRepository.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return new ResponseEntity(uri, HttpStatus.CREATED);
    }

    @PutMapping("jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
        Todo updatedTodo = todoJpaRepository.save(todo);

        return new ResponseEntity(updatedTodo, HttpStatus.OK);
    }
}
