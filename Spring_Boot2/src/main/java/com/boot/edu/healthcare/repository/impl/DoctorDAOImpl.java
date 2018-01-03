package com.boot.edu.healthcare.repository.impl;/**
 * @author Sergey Zhernovoy
 * create on 03.01.2018.
 */

import com.boot.edu.healthcare.domain.Doctor;
import com.boot.edu.healthcare.repository.DoctorDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DoctorDAOImpl implements DoctorDAO {

    private SessionFactory sessionFactory;

    public DoctorDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Doctor> findByLocationAndSpecification(String location, String specification) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Doctor> query = (TypedQuery<Doctor>) session.getNamedQuery("findByLocationAndSpecification");
        query.setParameter("location",location);
        query.setParameter("specification",specification);
        return query.getResultList();
    }
}

    