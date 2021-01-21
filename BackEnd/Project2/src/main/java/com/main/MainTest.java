package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.models.Posts;
import com.models.Users;
import com.repo.PostsRepo;
import com.repo.PostsRepoImpl;
import com.repo.UserRepo;
import com.repo.UserRepoImpl;
import com.servicepack.PostsService;
import com.servicepack.PostsServiceImpl;
import com.servicepack.UserService;
import com.servicepack.UserServiceImpl;


public class MainTest {
	public static ApplicationContext appContext=
			new ClassPathXmlApplicationContext("applicationContext.xml");
	public static UserService userServi = new UserServiceImpl();
	public static PostsService postServi = new PostsServiceImpl();
	
    
   public static PostsRepo postsRepo = appContext.getBean("postsRepo", PostsRepoImpl.class);
  public static UserRepo usersRepo = appContext.getBean("userRepo", UserRepoImpl.class);
	
	public static void main(String[] args) {
		insertInitialValues();
		
//		Users testObj= new Users();
//		testObj.setUserId(1);
//		testObj.setUserName("JACK");
//		testObj.setPassWord("trains");
//		testObj.setEmail("email");
//		testObj.setName("Namu");
		
		System.out.println("\n Going to get by id");
		System.out.println(userServi.getUserById(1));
		
		System.out.println("Going to get by name");
		System.out.println(userServi.getUserByName("daniels", "dan"));
		
		System.out.println("Going to get by credentials");
		System.out.println(userServi.getUserByCredentials("JackieBoy", "pasword"));
		
		System.out.println("Getting all users");
		System.out.println(userServi.getAllUsers());
		
		System.out.println("Getting all posts");
		System.out.println(postServi.getAllPosts());
		
		System.out.println("Getting posts by id");
		System.out.println(postServi.getPostById(2));
		
		System.out.println("Getting all of authors posts");
		System.out.println(postServi.getPostsByAuthor(userServi.getUserById(1)));
		
		//HibernateUtil.closeSession();
		
		
		
		System.out.println("Test 1, all of our users: " + usersRepo.selectAll());
		System.out.println("Testing service layer" + userServi.getAllUsers());
	}

	private static void insertInitialValues() {
		
		Users user1 = new Users("Jack", "Doe", "JackieBoy", "pasword", "Mail@mail.com");
		Users user2 = new Users("daniels", "dan", "jackdaniels", "paswordi", "test@mail.com");
		Users user3 = new Users("Nick", "Deters", "trainsst", "paswordo", "anothertest@mail.com");
		
		Posts post1 = new Posts("the first test post", user2);
		Posts post2 = new Posts("the second test post", user1);
		Posts post3 = new Posts("the third test post", user3);
		Posts post4 = new Posts("the fourth test post", user2);
		
		post1.getLikes().add(user2);
		post1.getLikes().add(user3);
		
		post2.getLikes().add(user1);
		post2.getLikes().add(user3);
		
		post3.getLikes().add(user1);
		
		post4.getLikes().add(user3);
//		
//		//List<Posts> authored1 = new ArrayList<>();
		user1.getAuthoredPosts().add(post2);
		user2.getAuthoredPosts().add(post1);
		user2.getAuthoredPosts().add(post4);
		user3.getAuthoredPosts().add(post3);
		
		user1.getLikedPosts().add(post2);
		user1.getLikedPosts().add(post3);
		
		user2.getLikedPosts().add(post1);
		
		user3.getLikedPosts().add(post1);
		user3.getLikedPosts().add(post2);
		user3.getLikedPosts().add(post4);
	
//		user1.setAuthoredPosts(authored1);
//		user2.setAuthoredPosts(authored2);
//		user3.setAuthoredPosts(authored3);
		
//		List<Users> likes1 = new ArrayList<>();
//		likes1.add(user2);
//		
//		List<Users> likes2 = new ArrayList<>();
//		likes2.add(user1);
//		likes2.add(user3);
//		
//		List<Users> likes3 = new ArrayList<>();
//		likes3.add(user1);
//		
//		List<Users> likes4 = new ArrayList<>();
//		likes4.add(user2);
//		
//		post1.setLikes(likes1);
//		post2.setLikes(likes2);
//		post3.setLikes(likes3);
//		post4.setLikes(likes4);
		
		//user1.setLikedPosts(likedPosts);
		usersRepo.insert(user1);
//		usersRepo.insert(user2);
//		usersRepo.insert(user3);
//		
	//	postServi.addPost(post1);
	//	postServi.addPost(post2);
	//	postServi.addPost(post3);
	//	postServi.addPost(post4);
		
		
	}

}

