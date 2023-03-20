package com.project.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.project.exception.EmpException;
import com.project.pojo.User;

@Component
public class UserDAO extends DAO{
    public UserDAO() {
    }

    public void save(User user) throws EmpException {
        try {
            begin();
            getSession().save(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new EmpException("Could not create user " + user.getFname() + " " + user.getLname(), e);
        }
    }
    
    
    public void delete(User user) throws EmpException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new EmpException("Could not delete the user" + user.getFname() + " " + user.getLname(), e);
        }
    }
    
    public void update(User user) throws EmpException {
        try {
            begin();
            getSession().update(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new EmpException("Could not update user " + user.getFname() + " " + user.getLname(), e);
        }
    }

	public User checkEmpLogin(String emailid, String pwd) {
		// TODO Auto-generated method stub
		Query query = getSession().getNamedQuery("logininfo");
		query.setParameter("emailid",emailid);
		query.setParameter("pwd",pwd);
		
		return (User)query.uniqueResult();
	}

	public User checkEmp(String emailid) {
		// TODO Auto-generated method stub
		Query query = getSession().getNamedQuery("deleteemp");
		query.setParameter("emailid",emailid);
		
		return (User)query.setMaxResults(1).uniqueResult();		
	}
	
    public List<User> list() {
		Query<User> query = getSession().createQuery("FROM User");
		List<User> list = query.list();
		return list;
	}
}
