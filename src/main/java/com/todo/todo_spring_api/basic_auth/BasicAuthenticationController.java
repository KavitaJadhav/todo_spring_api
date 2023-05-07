package com.todo.todo_spring_api.basic_auth;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthenticationController {
    @GetMapping("/basicauth")
    public BasicAuthBean login() {
        return new BasicAuthBean("You are authenticated");
    }
}
