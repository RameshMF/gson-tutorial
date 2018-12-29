package net.javaguides.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSONObjectExample {
	
	private static final Gson gson = new Gson();

	public static void main(String[] args) {
		GSONObjectExample gsonObjectExample = new GSONObjectExample();
		gsonObjectExample.serializeUserObject();
		gsonObjectExample.deserializeUserObject();
		gsonObjectExample.printPrintJsonObject();
	}

	private void serializeUserObject() {
		User user = new User();
		user.setFirstName("Ramesh");
		user.setLastName("Fadatare");
		user.setGender("Male");
		user.setAge(28);
		user.setId(100);

		String userJson = gson.toJson(user);
		System.out.println(userJson);
	}

	private void deserializeUserObject() {
		String userJson = "{\"id\":100,\"firstName\":\"Ramesh\",\"lastName\":\"Fadatare\",\"age\":28,\"gender\":\"Male\"}";
		User user = gson.fromJson(userJson, User.class);
		System.out.println(user.toString());
	}
	
	private void printPrintJsonObject() {
		Gson pGson = new GsonBuilder().setPrettyPrinting().create();
		User user = new User();
		user.setFirstName("Ramesh");
		user.setLastName("Fadatare");
		user.setGender("Male");
		user.setAge(28);
		user.setId(100);

		String userJson = pGson.toJson(user);
		System.out.println(userJson);
	}
}
