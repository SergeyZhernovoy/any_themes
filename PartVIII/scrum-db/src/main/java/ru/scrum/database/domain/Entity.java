package ru.scrum.database.domain;

/**
 * Created by Sergey on 29.03.2017.
 */
public abstract class Entity {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
