package com.repo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.models.Posts;
import com.models.Users;

public class PostsRepoImplTest {

	private static PostsRepo postsDao;
	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		postsDao = appContext.getBean("postsRepo", PostsRepoImpl.class);
	}

	@Test
	public void testSelectById() {
		Posts post = postsDao.selectById(2);
		assertEquals(2, post.getPostId());
	}

	@Test
	public void testSelectByAuthor() {
		Users u = new Users("daniels", "updatelast", "jackdaniels", "passwordi", "test@mail.com");
		u.setUserId(1);
		List<Posts> posts = postsDao.selectByAuthor(u);
		assert (!posts.isEmpty());
		for(Posts p : posts) {
			assert(p.getAuthor().getUserName().equals("drew4"));
		}
	}

	@Test
	public void testSelectAll() {
		List<Posts> posts = postsDao.selectAll();
		assert(!posts.isEmpty());
	}

}
