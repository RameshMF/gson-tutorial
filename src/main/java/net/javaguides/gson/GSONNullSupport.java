/*package net.javaguides.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

*//**
 * 
 * @author Ramesh Fadatare
 *
 *//*
public class GSONNullSupport {
	public static void main(String[] args) {
		GsonBuilder builder = new GsonBuilder();
		builder.serializeNulls();
		builder.setPrettyPrinting();
		Gson gson = builder.create();

		User user = new User();
		user.setId(100);
		user.setLastName("Fadatare");
		user.setAge(28);

		String userJson = gson.toJson(user);
		System.out.println(userJson);

		User user2 = gson.fromJson(userJson, User.class);
		System.out.println(user2);
	}
}

class User {

	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
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
}*/