package com.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.models.Users;

/**
 * This is the implementation of the methods found in UsersRepo. This is responsible for running all transactions
 *  of our database involving the Users table
 * @author Nicholas Deters, Andrew Kellar, William Stone, Mark Anthony Vargas, Justin Wen
 *
 */
@Repository("userRepo")
@Transactional
public class UserRepoImpl implements UserRepo {

private SessionFactory sesFact;
	
	public UserRepoImpl() {
	}
	
	
	@Autowired
	public UserRepoImpl(SessionFactory sesFact) {
		super();
		this.sesFact = sesFact;
	}
	
	@Override
	public void insert(Users userObj) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//		
//		ses.save(userObj);
//		
//		tx.commit();
		
		sesFact.getCurrentSession().save(userObj);
		

	}

	@Override
	public void update(Users userObj) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//		
//		ses.update(userObj);
//		
//		tx.commit();
		sesFact.getCurrentSession().merge(userObj);

	}

	@Override
	public void delete(Users userObj) {
//		Session ses = HibernateUtil.getSession();
//		Transaction tx = ses.beginTransaction();
//		
//		ses.delete(userObj);
//		
//		tx.commit();
		
		sesFact.getCurrentSession().delete(userObj);
		

	}

	@Override
	public Users selectById(int id) {
//		Session ses = HibernateUtil.getSession();
//		
//		
//		Users use = ses.get(Users.class, id);
//		
//		
//		return use;
		
		return sesFact.getCurrentSession().get(Users.class, id);
	}

	@Override
	public List<Users> selectAll() {
//		Session ses = HibernateUtil.getSession();
//
//		//List<SuperVillain> villList = ses.createQuery("from SuperVillain", SuperVillain.class).list();
//		
//		CriteriaBuilder cb = ses.getCriteriaBuilder();
//		CriteriaQuery<Users> cr = cb.createQuery(Users.class);
//		Root<Users> root = cr.from(Users.class);
//		
//		cr.select(root);
//		
//		Query<Users> query = ses.createQuery(cr);
//		List<Users> usersList = query.getResultList();
//		
//		
//		
//		return usersList;
		
		return sesFact.getCurrentSession().createQuery("from Users", Users.class).list();

	}


	@Override
	public List<Users> selectByFullName(String firstName, String lastName) {
		Session ses = sesFact.getCurrentSession();
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<Users> cr = cb.createQuery(Users.class);
		Root<Users> root = cr.from(Users.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		predicates.add(cb.equal(root.get("firstname"), firstName));
		predicates.add(cb.equal(root.get("lastname"), lastName));
		
		cr.select(root)
			.where(predicates.toArray(new Predicate[]{}));
		
		Query<Users> query = ses.createQuery(cr);
		List<Users> usersList = query.getResultList();
		
		
		
		if(usersList.size() == 0) {
			System.out.println("doesnt exist");
			return null;
		}
		
		return usersList;

		
	}

	@Override
	public Users selectByCredentials(String username, String password) {
		
		Session ses = sesFact.getCurrentSession();
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<Users> cr = cb.createQuery(Users.class);
		Root<Users> root = cr.from(Users.class);
		
		cr.select(root)
			.where(cb.equal(root.get("userName"), username))
			.where(cb.equal(root.get("passWord"), password));
		
		Query<Users> query = ses.createQuery(cr);
		List<Users> usersList = query.getResultList();
		
		
		
		if(usersList.size() == 0) {
			System.out.println("doesnt exist");
			return null;
		}
		
		return usersList.get(0);
	}


	@Override
	public Users selectByUsername(String username) {
		Session ses = sesFact.getCurrentSession();
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<Users> cr = cb.createQuery(Users.class);
		Root<Users> root = cr.from(Users.class);
		
		cr.select(root)
			.where(cb.equal(root.get("userName"), username));
		
		Query<Users> query = ses.createQuery(cr);
		List<Users> usersList = query.getResultList();
		
		
		
		if(usersList.size() == 0) {
			System.out.println("doesnt exist");
			return null;
		}
		
		return usersList.get(0);
	}


	@Override
	public Users selectByEmail(String email) {
		Session ses = sesFact.getCurrentSession();
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<Users> cr = cb.createQuery(Users.class);
		Root<Users> root = cr.from(Users.class);
		
		cr.select(root)
			.where(cb.equal(root.get("email"), email));
		
		Query<Users> query = ses.createQuery(cr);
		List<Users> usersList = query.getResultList();
		
		
		
		if(usersList.size() == 0) {
			System.out.println("doesnt exist");
			return null;
		}
		
		return usersList.get(0);
	}
	




	




}
