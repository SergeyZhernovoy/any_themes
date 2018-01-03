package com.boot.edu.healthcare.service;

import com.boot.edu.healthcare.domain.Doctor;

import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 03.01.2018.
 */
public interface DoctorService {
    List<Doctor> find(String location, String speciality);
}
