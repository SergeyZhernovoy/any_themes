package com.boot.edu.healthcare.service.impl;/**
 * @author Sergey Zhernovoy
 * create on 03.01.2018.
 */

import com.boot.edu.healthcare.domain.Doctor;
import com.boot.edu.healthcare.repository.DoctorDAO;
import com.boot.edu.healthcare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDAO doctorDAO;

    @Override
    public List<Doctor> find(String location, String speciality) {
        return doctorDAO.findByLocationAndSpecification(location,speciality);
    }
}

    