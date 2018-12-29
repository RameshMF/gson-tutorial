package net.javaguides.gson;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GSONGenericsExample {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		Box<User> type2 = new Box<>();
		User user = new User();
		user.setId(100);
		user.setFirstName("Ramesh");
		user.setLastName("Fadatare");
		user.setGender("Male");
		user.setAge(28);
		type2.set(user);

		// Serialization of generic User type to json
		
		Type fooType2 = new TypeToken<Box<User>>() {
		}.getType();
		String userJson = gson.toJson(type2, fooType2);
		System.out.println(userJson);
		
		//  De-serialization of generic User type to json
		Box<User> box = gson.fromJson(userJson, fooType2);
		System.out.println(box.get().toString());
	}
}

class Box<T> {
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}
}