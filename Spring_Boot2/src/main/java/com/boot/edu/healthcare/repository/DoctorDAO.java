package com.boot.edu.healthcare.repository;

import com.boot.edu.healthcare.domain.Doctor;

import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 03.01.2018.
 */

public interface DoctorDAO {
    List<Doctor> findByLocationAndSpecification(String location, String specification);
}

    