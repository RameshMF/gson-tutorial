package net.javaguides.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author Ramesh Fadatare
 *
 */
public class GSONExcludingFieldsExample {
	public static void main(String[] args) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		User user = new User();
		user.setFirstName("Ramesh");
		user.setLastName("Fadatare");
		user.setGender("Male");
		user.setAge(28);
		user.setId(100);
		user.setPassword("secret");

		// Serialization without excludeFieldsWithoutExposeAnnotation() method
		String userJson = gson.toJson(user);
		System.out.println(userJson);

		// Serialization with excludeFieldsWithoutExposeAnnotation() method
		gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		String result = gson.toJson(user);
		System.out.println("-------- Serialization using @Expose annotation -----");
		System.out.println(result);
	}
}
