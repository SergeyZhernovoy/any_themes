package spring_boot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 21.11.2017.
 */

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String isbn;
    private String title;
    private String description;

    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    private List<Reviewer> reviewers;

    public Book(String isbn, String title, Author author, Publisher publisher) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    protected Book(){

    }
}

    