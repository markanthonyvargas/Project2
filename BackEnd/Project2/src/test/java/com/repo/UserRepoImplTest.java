package com.repo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.models.Users;

public class UserRepoImplTest {
	
	private static UserRepo userDao;
	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userDao = appContext.getBean("userRepo", UserRepoImpl.class);
	}

	@Test
	public void testSelectById() {
		Users u = userDao.selectById(1);
		assertEquals(1, u.getUserId());
	}

	@Test
	public void testSelectAll() {
		List<Users> list = userDao.selectAll();
		assert(!list.isEmpty());
	}

	@Test
	public void testSelectByFullName() {
		List<Users> u = userDao.selectByFullName("Jack", "Doe");
		if(!u.isEmpty()) {
			for(Users u1 : u) {
				assertEquals("Jack", u1.getFirstname());
				assertEquals("Doe", u1.getLastname());
			}
		}
	}

	@Test
	public void testSelectByCredentials() {
		Users u = userDao.selectByCredentials("JackieBoy", "pasword");
		assertEquals("JackieBoy", u.getUserName());
		assertEquals(1, u.getUserId());
	}

	@Test
	public void testSelectByUsername() {
		Users u = userDao.selectByUsername("JackieBoy");
		assertEquals("JackieBoy", u.getUserName());
	}

	@Test
	public void testSelectByEmail() {
		Users u = userDao.selectByEmail("Mail@mail.com");
		assertEquals("Mail@mail.com", u.getEmail());
	}

}
