package net.javaguides.gson;

import com.google.gson.Gson;

public class GSONPrimitiveExamples {
	public static void main(String[] args) {
		// Serialization
		Gson gson = new Gson();

		// Serialization of integer
		System.out.println(gson.toJson(1));

		// Serialization of String
		System.out.println(gson.toJson("abcd"));

		// Serialization of Long
		System.out.println(gson.toJson(new Long(10)));

		// Serialization of int array
		int[] values = { 1 };
		System.out.println(gson.toJson(values));

		// Serialization of Double
		System.out.println(gson.toJson(new Double(10.0d)));

		// Serialization of Character
		System.out.println(gson.toJson(new Character('A')));

		// Deserialization of int
		System.out.println(gson.fromJson("1", int.class));

		// Deserialization of Integer
		System.out.println(gson.fromJson("1", Integer.class));

		// Deserialization of Long
		System.out.println(gson.fromJson("1", Long.class));

		// Deserialization of Boolean
		System.out.println(gson.fromJson("false", Boolean.class));

		// Deserialization of String
		System.out.println(gson.fromJson("\"abc\"", String.class));

		// Deserialization of String[]
		System.out.println(gson.fromJson("[\"abc\"]", String[].class));

		// Deserialization of Character
		System.out.println(gson.fromJson("A", Character.class));
	}
}
