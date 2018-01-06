package com.boot.edu.healthcare.repository.impl;/**
 * @author Sergey Zhernovoy
 * create on 05.01.2018.
 */

import com.boot.edu.healthcare.domain.User;
import com.boot.edu.healthcare.repository.UserDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("all")
    public List<User> findByEmail(String email) {
        Session session =  this.sessionFactory.getCurrentSession();
        Query query  = session.getNamedQuery("findByEmail");
        query.setString("email",email);
        return query.list();
    }

    @Override
    public List<User> findByEmailAndPassword(String email, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createCriteria(User.class)
                .add(Restrictions.eq("email",email))
                .add(Restrictions.eq("password",password))
                .list();
    }

    @Override
    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        User persistenceUser = (User) session.load(User.class,new Long(user.getId()));
        Transaction tx = session.beginTransaction();
        persistenceUser.setFirstName(user.getFirstName());
        persistenceUser.setLastName(user.getLastName());
        session.update(persistenceUser);
        tx.commit();
    }
}

    