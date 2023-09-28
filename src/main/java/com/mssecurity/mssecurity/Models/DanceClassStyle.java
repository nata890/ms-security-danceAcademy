package com.mssecurity.mssecurity.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class DanceClassStyle {

    @Id
    private String _id;
    private String choreography;

    @DBRef
    private Style style;

    @DBRef
    private DanceClass danceClass;

    public DanceClassStyle() {
    }

    public DanceClassStyle(String choreography) {
        this.choreography = choreography;
    }

    public String get_id() {
        return _id;
    }

    public String getChoreography() {
        return choreography;
    }

    public void setChoreography(String choreography) {
        this.choreography = choreography;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public DanceClass getDanceClass() {
        return danceClass;
    }

    public void setDanceClass(DanceClass danceClass) {
        this.danceClass = danceClass;
    }
}
