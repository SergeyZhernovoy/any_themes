package ru.database.domain;

import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "gen_person",sequenceName = "seq_person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen_person")
    private Long id;
    private String fio;
    @Embedded
    private Address address;
}
