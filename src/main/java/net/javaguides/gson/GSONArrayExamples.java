package net.javaguides.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSONArrayExamples {
	public static void main(String[] args) {
		multiDimensionalArray();
	}
	
	private static void multiDimensionalArray() {
		Gson gson = new GsonBuilder().create();
		int[][] multiIntArray = new int[][]{{1, 2, 3}, {4, 5, 6}};

		// serialization
		gson.toJson(multiIntArray);     // => [[1,2,3],[4,5,6]]

		// deserialization
		int[][] intArray2 = gson.fromJson("[[1,2,3],[4,5,6]]", int[][].class);
	}
}
