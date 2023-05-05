package com.todo.todo_spring_api;

import java.math.BigInteger;
import java.util.Date;

public class Todo {
    private Long id;
    private String description;
    private String username;
    private boolean complete;
    private Date targetDate;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getUsername() {
        return username;
    }

    public boolean isComplete() {
        return complete;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public Todo(Long id, String username, String description, Date targetDate, boolean complete) {
        this.id = id;
        this.description = description;
        this.username = username;
        this.complete = complete;
        this.targetDate = targetDate;
    }
}
