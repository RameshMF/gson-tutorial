package net.javaguides.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Since;

/**
 * 
 * @author Ramesh Fadatare
 *
 */
public class GSONVersionSupport {
	public static void main(String[] args) {
		User user = new User();
		user.setFirstName("Ramesh");
		user.setLastName("Fadatare");
		user.setGender("Male");
		user.setAge(28);
		user.setId(100);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String result = gson.toJson(user);
		System.out.println("Without version: " + result);

		gson = new GsonBuilder().setVersion(1.0).setPrettyPrinting().create();
		result = gson.toJson(user);
		System.out.println("Version 1.0: " + result);

		gson = new GsonBuilder().setVersion(1.1).setPrettyPrinting().create();
		result = gson.toJson(user);
		System.out.println("Version 1.1: " + result);
		
		gson = new GsonBuilder().setVersion(1.2).setPrettyPrinting().create();
		result = gson.toJson(user);
		System.out.println("Version 1.2: " + result);
		
		gson = new GsonBuilder().setVersion(1.3).setPrettyPrinting().create();
		result = gson.toJson(user);
		System.out.println("Version 1.3: " + result);
	}
}

class User {

	@Since(1.0)
	private int id;

	private String firstName;
	private String lastName;

	@Since(1.1)
	private int age;

	@Since(1.2)
	private String gender;

	@Since(1.3)
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender="
				+ gender + "]";
	}
}
