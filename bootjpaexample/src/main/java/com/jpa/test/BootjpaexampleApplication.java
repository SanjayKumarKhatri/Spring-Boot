package com.jpa.test;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

import antlr.collections.List;
import ch.qos.logback.core.spi.LifeCycle;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
	
	UserRepository userRepository = context.getBean(UserRepository.class);
	
	/*
	 * User user = new User(); 
	 * user.setName("Sanjay Kumar");
	 * user.setCity("Umerkot"); 
	 * user.setStatus("I am a Java Developer");
	 * 
	 * User user2 = userRepository.save(user);
	 * 
	 * System.out.println(user2);
	 */
	
	/*
	 * User user = new User(); 
	 * user.setName("Manoj Kumar");
	 *  user.setCity("Umerkot");
	 * user.setStatus("I am a Java Developer");
	 * 
	 * User user2 = new User(); 
	 * user2.setName("Saqib Ali"); 
	 * user2.setCity("Hyd");
	 * user2.setStatus("He is Developer");
	 */
	
	//Saving Single user
   // User resultUser = userRepository.save(user);
	
	/*
	 * java.util.List<User> list = new ArrayList<User>(); 
	 * list.add(user);
	 * list.add(user2);
	 * 
	 * //save multiple object
	 *  Iterable<User> result = userRepository.saveAll(list);
	 */
	
	/*
	 * result.forEach(users -> { 
	 * 		System.out.println(users);
	 *  });
	 */
    
	//System.out.println( resultUser);
	//System.out.println("Done");
	
	/*
	 * User user2 = new User(); 
	 * user.setName("Aman Kumar");
	 *  user.setCity("Umerkot");
	 * user.setStatus("I am a Java Developer"); 
	 * User resultUser2 = userRepository.save(user); 
	 * System.out.println( resultUser);
	 */
	
	  //update the user by id 2
	/*
	 * Optional<User> optional = userRepository.findById(2); 
	 * User user = optional.get(); 
	 * user.setName("Aman Kumar"); 
	 * User result = userRepository.save(user);
	 * System.out.println(result);
	 */
	
	//how to get the data
	//findById(id)- return Optional Containing your data
	
	/*
	 * Iterable<User> itr = userRepository.findAll(); 
	 * itr.forEach(user -> {
	 *	 System.out.println(user);
	 *  });
	 */
	
	//Deleting the user elements
	//userRepository.deleteById(7);
	//System.out.println("Deleted");
	
	//java.util.List<User> users = userRepository.findByNameAndCity("Sanjay Kumar","Umerkot");
	//users.forEach(e -> System.out.println(e));
	
	java.util.List<User> allUser = userRepository.getAllUser();
	allUser.forEach(e ->System.out.println(e));
	
	System.out.println("---------------------------------");
	
    java.util.List<User> getUserWithName = userRepository.getUserByName("Manoj Kumar", "Umerkot");
    getUserWithName.forEach(e ->System.out.println(e));
    
    System.out.println("____________________________________________");
    
    userRepository.getUsers().forEach(e ->System.out.println(e));
	
	
	
	
	}

}
