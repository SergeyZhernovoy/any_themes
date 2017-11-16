package lesson1_ibatis.domain;

import java.util.Date;

/**
 * @author Sergey Zhernovoy
 * create on 14.11.2017.
 */

public class Student {
    private Integer id;
    private String name;
    private String email;
    private Date dob;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}

    