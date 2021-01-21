package com.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.connection_util.HibernateUtil;
import com.models.Posts;
import com.models.Users;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is the implementation of the methods found in PostsRepo. This is responsible for running all transactions
 *  of our database involving the Posts table
 * @author Nicholas Deters, Andrew Kellar, William Stone, Mark Anthony Vargas, Justin Wen
 *
 */
@Repository("postsRepo")
@Transactional
public class PostsRepoImpl implements PostsRepo {
	
	private SessionFactory sesFact;
	
	public PostsRepoImpl() {
	}
	
	
	
	@Autowired
	public PostsRepoImpl(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}


	@Override
	public void insert(Posts postObj) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//		
//		ses.save(postObj);
//		
//		tx.commit();
		
		sesFact.getCurrentSession().save(postObj);
	}

	
	@Override
	public void update(Posts postObj) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//		
//		ses.update(postObj);
//		
//		tx.commit();
		
		sesFact.getCurrentSession().merge(postObj);
	}

	
	@Override
	public void delete(Posts postObj) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//		
//		ses.delete(postObj);
//		
//		tx.commit();
		
		sesFact.getCurrentSession().delete(postObj);
	}

	
	@Override
	public Posts selectById(int id) {
//		Session ses = HibernateUtil.getSession();
//		
//		Posts post = ses.get(Posts.class, id);
//		
//		return post;
		
		return sesFact.getCurrentSession().get(Posts.class, id);
	}

	
	@Override
	public List<Posts> selectByAuthor(Users u) {
//		Session ses = HibernateUtil.getSession();
		Session ses = sesFact.getCurrentSession();
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<Posts> cr = cb.createQuery(Posts.class);
		Root<Posts> root = cr.from(Posts.class);
		
		cr.select(root)
			.where(cb.equal(root.get("author"), u));
		
		Query<Posts> query = ses.createQuery(cr);
		List<Posts> postsList = query.getResultList();
		
		
		if(postsList.size() == 0) {
			System.out.println("doesnt exist");
			return null;
		}
		
		return postsList;
	}

	
	@Override
	public List<Posts> selectAll() {
//		Session ses = HibernateUtil.getSession();
//		
//		CriteriaBuilder cb = ses.getCriteriaBuilder();
//		CriteriaQuery<Posts> cr = cb.createQuery(Posts.class);
//		Root<Posts> root = cr.from(Posts.class);
//		
//		cr.select(root);
//		
//		Query<Posts> query = ses.createQuery(cr);
//		List<Posts> postsList = query.getResultList();
//		
//		
//		return postsList;
		
		return sesFact.getCurrentSession().createQuery("from Posts", Posts.class).list();
	}
}

