package com.boot.edu.healthcare.domain;

import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 03.01.2018.
 */

public class DoctorList {

    private List<Doctor> doctors;
    public DoctorList(List<Doctor> doctors){
        this.doctors = doctors;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}

    