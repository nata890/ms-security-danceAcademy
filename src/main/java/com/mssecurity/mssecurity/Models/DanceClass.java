package com.mssecurity.mssecurity.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document

public class DanceClass {
    @Id
    private String _id;
    private String difficulty;
    private int duration;
    @DBRef
    private Instructor instructor_id;

    public DanceClass (){
    }

    public DanceClass(String difficulty, int duration, Instructor instructor_id) {
        this.difficulty = difficulty;
        this.duration = duration;
        this.instructor_id = instructor_id;
    }

    public String get_id() {
        return _id;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Instructor getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(Instructor instructor_id) {
        this.instructor_id = instructor_id;
    }
}

