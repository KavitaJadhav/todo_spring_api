package com.todo.todo_spring_api.basic_auth;

import java.util.Date;

public class BasicAuthBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public BasicAuthBean(String message) {
        this.message = message;
    }
}
