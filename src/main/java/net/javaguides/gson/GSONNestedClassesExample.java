package net.javaguides.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSONNestedClassesExample {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		OuterClass outerClass = new OuterClass();
		outerClass.setValue1("value1");
		outerClass.setValue2("value2");
		
		OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
		innerClass.value3 = "value3";
		innerClass.value4 = "value4";
		outerClass.setInnerClass(innerClass);
		
		String jsonStr = gson.toJson(outerClass);
		System.out.println(jsonStr);
	}

}

class OuterClass {
	private String value1;
	private String value2;
	private InnerClass innerClass;

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public void setInnerClass(InnerClass innerClass) {
		this.innerClass = innerClass;
	}

	public InnerClass getInnerClass() {
		return innerClass;
	}

	static class InnerClass {
		public String value3;
		public String value4;

	}
}