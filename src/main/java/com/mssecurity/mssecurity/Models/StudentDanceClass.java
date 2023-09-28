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
    private Student student_id;
    @DBRef
    private DanceClass danceClass_id;

    public StudentDanceClass(){
    }

    public StudentDanceClass(Student student_id, DanceClass danceClass_id) {
        this.student_id = student_id;
        this.danceClass_id = danceClass_id;
    }

    public String get_id() {
        return _id;
    }

    public Student getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }

    public DanceClass getDanceClass_id() {
        return danceClass_id;
    }

    public void setDanceClass_id(DanceClass danceClass_id) {
        this.danceClass_id = danceClass_id;
    }
}
