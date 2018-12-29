package net.javaguides.gson;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GSONCollectionsExample {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Collection<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);

		// Serialization of integer
		String json = gson.toJson(ints); 
		System.out.println(json);
		
		// Serialization of collection of employees
		Collection<Employee> employees = Arrays.asList(new Employee("firstName1", "lastName1"),
				new Employee("firstName2", "lastName2"),
				new Employee("firstName3", "lastName3"),
				new Employee("firstName4", "lastName4"),
				new Employee("firstName5", "lastName5"));
		
		String empJson = gson.toJson(employees); 
		System.out.println(empJson);
		
		
		// Deserialization of integer
		Type collectionType = new TypeToken<Collection<Integer>>() {}.getType();
		Collection<Integer> ints2 = gson.fromJson(json, collectionType);
		System.out.println(ints2);
		
		// De-serialization of employee json to Collection of employee Java objects
		String employeeJson = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"firstName1\",\r\n" + 
				"    \"lastName\": \"lastName1\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"firstName2\",\r\n" + 
				"    \"lastName\": \"lastName2\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"firstName3\",\r\n" + 
				"    \"lastName\": \"lastName3\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"firstName4\",\r\n" + 
				"    \"lastName\": \"lastName4\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"firstName5\",\r\n" + 
				"    \"lastName\": \"lastName5\"\r\n" + 
				"  }\r\n" + 
				"]";
		Type type = new TypeToken<Collection<Employee>>() {}.getType();
		Collection<Employee> collectionOfEmp = gson.fromJson(employeeJson, type);
		System.out.println(collectionOfEmp);
	}
}

class Employee{
	private String firstName;
	private String lastName;
	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
