package com.mydiary.mydiary;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Diary {
    
    // Vi vill att id ska vara A I - auto increment = id:t genereras automatiskt då annoterar vi id med @Id och @GeneratedValue
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String title; 
    private String content;
    private LocalDate date = LocalDate.now();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    
}
