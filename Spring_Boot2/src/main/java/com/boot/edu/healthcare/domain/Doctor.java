package com.boot.edu.healthcare.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Sergey Zhernovoy
 * create on 03.01.2018.
 */

@Entity
@Table(name = "doctor")
@NamedQueries({
        @NamedQuery(
                name = "findBySpeciality",
                query = "from Doctor u where u.specialityCode = :specialityCode"
        ),
        @NamedQuery(
                name = "findAll",
                query = "from Doctor"
        ),
        @NamedQuery(
                name = "findAllCount",
                query = "select count(d) from Doctor d"
        ),
        @NamedQuery(
                name = "findById",
                query = "from Doctor d where d.user.id = :id"
        ),
})
public class Doctor implements Serializable {


    private static final long serialVersionUID = 1146039219074072803L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    @Column(name = "speciality_code")
    private String specialityCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialityCode() {
        return specialityCode;
    }

    public void setSpecialityCode(String specialityCode) {
        this.specialityCode = specialityCode;
    }
}

    