package spring_boot.entity;/**
 * @author Sergey Zhernovoy
 * create on 21.11.2017.
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Publisher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    protected Publisher() {

    }

    public Publisher(String name) {
        this.name = name;
    }
}

    