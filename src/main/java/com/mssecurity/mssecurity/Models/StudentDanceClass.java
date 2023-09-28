package com.mssecurity.mssecurity.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document

public class StudentDanceClass {
    @Id
    private String _id;
    @DBRef
    private Student student;
    @DBRef
    private DanceClass danceClass;

    public StudentDanceClass(){
    }

    public StudentDanceClass(Student student, DanceClass danceClass) {
        this.student = student;
        this.danceClass = danceClass;
    }

    public String get_id() {
        return _id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public DanceClass getDanceClass() {
        return danceClass;
    }

    public void setDanceClass(DanceClass danceClass) {
        this.danceClass = danceClass;
    }
}
