package com.project.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.project.exception.EmpException;
import com.project.pojo.Post;
import com.project.pojo.User;


@Component
public class PostDAO extends DAO{
    public void save(Post post) throws EmpException {
        try {
            begin();
            getSession().save(post);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new EmpException("Could not create post", e);
        }
    }
  
    public void delete(Post post) throws EmpException {
        try {
            begin();
            getSession().delete(post);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new EmpException("Could not delete the post", e);
        }
    }
    
    public List<Post> list() {
		Query<Post> query = getSession().createQuery("FROM Post");
		List<Post> list = query.list();
		return list;
	}
    
	public Post checkPost(long postid) {
		// TODO Auto-generated method stub
		Query query = getSession().getNamedQuery("deletepost");
		query.setParameter("postid",postid);
		
		return (Post)query.uniqueResult();		
	}


}
