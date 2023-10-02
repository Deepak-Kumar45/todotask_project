package com.hiber.factory;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.hiber.modal.Task;

public class Factory {
	private static SessionFactory factroy=null;
	
	static {
		if(factroy==null){
			try {
				Configuration configure=new Configuration();
				
				// create Properties object to contain hibernate and database properties
				Properties settings=new Properties();
				// database properties
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatedb2");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "");
				
				// hibernate properties
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL55Dialect");
				settings.put(Environment.HBM2DDL_AUTO, "update");  
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.SHOW_SQL, "true");
				
				// set all the hibernate and database properties
				configure.setProperties(settings);
				
				
				// map the persistence classes
				configure.addAnnotatedClass(Task.class);
				
				factroy=configure.buildSessionFactory();
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
	public static SessionFactory getSessionFactory() {  
		return factroy;
	}
}
