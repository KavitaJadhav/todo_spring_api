package com.todo.todo_spring_api.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigInteger;
import java.util.Date;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private String username;
    private boolean complete;
    private Date targetDate;
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getUsername() {
        return username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isComplete() {
        return complete;
    }

    public Date getTargetDate() {
        return targetDate;
    }
    public Todo() {
    }
    public Todo(Long id, String username, String description, Date targetDate, boolean complete) {
        this.id = id;
        this.description = description;
        this.username = username;
        this.complete = complete;
        this.targetDate = targetDate;
    }
}
