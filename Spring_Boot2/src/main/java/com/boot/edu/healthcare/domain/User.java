package com.boot.edu.healthcare.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Sergey Zhernovoy
 * create on 03.01.2018.
 */

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(
                name  = "findByEmail",
                query = "from User u where u.email = :email"
        ),
        @NamedQuery(
                name  = "findByEmailAndPassword",
                query = "from User u where u.email = :email and u.password = :password"
        )
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name") private String firstName;
    @Column(name = "last_name")  private String lastName;
    private String email;
    private String password;
    private int age;
    private int gender;
    @Column(name = "contact_number") private String contactNumber;
    @Column(name = "alternate_contact_number") private String alternateContactNumber;
    private String address;
    @Column(name = "city_code")  private String cityCode;
    @Column(name = "state_code") private String stateCode;
    @Column(name = "country_code") private String countryCode;
    @Column(name = "create_time") private Timestamp createTime;
    @Column(name = "last_update") private Timestamp lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAlternateContactNumber() {
        return alternateContactNumber;
    }

    public void setAlternateContactNumber(String alternateContactNumber) {
        this.alternateContactNumber = alternateContactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

    