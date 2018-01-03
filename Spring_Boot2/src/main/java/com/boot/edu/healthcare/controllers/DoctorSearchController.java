package com.boot.edu.healthcare.controllers;/**
 * @author Sergey Zhernovoy
 * create on 31.12.2017.
 */

import com.boot.edu.healthcare.domain.DoctorList;
import com.boot.edu.healthcare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorSearchController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "/doctors", produces = "application/json")
    public DoctorList searchDoctors(@RequestParam(required = false) String location,
                                    @RequestParam(required = false) String speciality){
        return null;

    }

}

    