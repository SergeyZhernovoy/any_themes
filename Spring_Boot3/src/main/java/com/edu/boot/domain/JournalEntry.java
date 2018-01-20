package com.edu.boot.domain;

import com.edu.boot.utils.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "entry")
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date created;
    private String summary;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public JournalEntry(String title, String summary, String date) throws ParseException {
        this.title = title;
        this.created = format.parse(date);
        this.summary = summary;
    }

    public JournalEntry() {
        this.title = "New";
        this.created = new Date();
        this.summary = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonIgnore
    public String getCreatedAsShort(){
        return format.format(created);
    }
    @Override
    public String toString() {
        StringBuilder value = new StringBuilder("JournalEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(", Title: ");
        value.append(title);
        value.append(", Summary: ");
        value.append(summary);
        value.append(", Created: ");
        value.append(getCreatedAsShort());
        value.append(")");
        return value.toString();
    }
}
