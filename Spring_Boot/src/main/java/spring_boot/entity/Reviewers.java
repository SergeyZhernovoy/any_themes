package spring_boot.entity;/**
 * @author Sergey Zhernovoy
 * create on 21.11.2017.
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Reviewers {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    protected Reviewers() {

    }

    public Reviewers(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

    