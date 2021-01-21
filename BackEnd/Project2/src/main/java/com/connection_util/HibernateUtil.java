package com.connection_util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	/// THIS IS OLD CODE FROM MAKING IT ON TUESDAY
//	private static SessionFactory sf= 
//			new Configuration()
//			.configure("hibernate.cfg.xml")
//			.buildSessionFactory();
	
	
	
//	public static Session getSession() {
		//return sf.openSession();
//	}
	
	private static Configuration conf = new Configuration()
			.configure("hibernate.cfg.xml");
	
	static {
		conf.setProperty("hibernate.connection.password", System.getenv("database_password"));
		conf.setProperty("hibernate.connection.url", 
				"jdbc:postgresql://"+ System.getenv("database_link")
				+"/Social_Media");
	}
	
	private static SessionFactory sf = conf
			.buildSessionFactory();
	
	private static Session ses;
	
	public static Session getSession() {
		
		if(ses==null) {
			ses = sf.openSession();
		}
		return ses;
	}
	
	public static void closeSession() {
		ses.close();
		ses=null;
		sf.close();
	}

	
	
	
}
