package net.javaguides.gson;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;

/**
 * 
 * @author Ramesh Fadatare
 *
 */
public class GSONComplexObjectExample {
	public static void main(String[] args) {
		deserializeUserObject();
	}

	private static void deserializeUserObject() {
		Gson gson = new Gson();
		String jsonStr = "{\r\n" + 
				"  \"studentId\": 1000,\r\n" + 
				"  \"studentName\": \"Ramesh\",\r\n" + 
				"  \"studentPhoneNumbers\": [\r\n" + 
				"    {\r\n" + 
				"      \"phoneId\": 100,\r\n" + 
				"      \"phoneType\": \"Mobile Phone\",\r\n" + 
				"      \"phoneNumber\": \"1234567890\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"phoneId\": 101,\r\n" + 
				"      \"phoneType\": \"Landline Phone\",\r\n" + 
				"      \"phoneNumber\": \"2222 3333 44\"\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		Student student = gson.fromJson(jsonStr, Student.class);
		System.out.println(student.toString());
	}
}

class Student {

	private long studentId;
	private String studentName;
	private Set<Phone> studentPhoneNumbers = new HashSet<Phone>(0);

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Set<Phone> getStudentPhoneNumbers() {
		return studentPhoneNumbers;
	}

	public void setStudentPhoneNumbers(Set<Phone> studentPhoneNumbers) {
		this.studentPhoneNumbers = studentPhoneNumbers;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentPhoneNumbers="
				+ studentPhoneNumbers + "]";
	}
	
}

class Phone {

	private long phoneId;
	private String phoneType;
	private String phoneNumber;

	public Phone() {
	}

	public Phone(String phoneType, String phoneNumber) {
		this.phoneType = phoneType;
		this.phoneNumber = phoneNumber;
	}

	public long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}