package net.javaguides.gson;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GSONCustomSerDerExample {
	public static void main(String[] args) {
		Order order = new Order();
		order.setId(100);
		order.setOrderName("Book purchase");
		order.setOrderDesc("Java Head First");
		order.setOrderCreatedDate(LocalDate.now());
		order.setOrderCreatedDateTime(LocalDateTime.now());

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());

		gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());

		gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());

		gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());

		Gson gson = gsonBuilder.setPrettyPrinting().create();

		// Convert to JSON
		System.out.println(gson.toJson(order));

		String orderJson = "{\r\n" + "  \"id\": 100,\r\n" + "  \"orderName\": \"Book purchase\",\r\n"
				+ "  \"orderDesc\": \"Java Head First\",\r\n" + "  \"orderCreatedDate\": \"26-Oct-2018\",\r\n"
				+ "  \"orderCreatedDateTime\": \"26::Oct::2018 11::09::05\",\r\n"
				+ "  \"orderCreatedZonedDateTime\": \"Oct 26 2018  11:09 AM\"\r\n" + "}";
		// Convert to java objects
		System.out.println(gson.fromJson(orderJson, Order.class));

	}

}

class Order {
	private int id;
	private String orderName;
	private String orderDesc;
	private LocalDate orderCreatedDate;
	private LocalDateTime orderCreatedDateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public LocalDate getOrderCreatedDate() {
		return orderCreatedDate;
	}

	public void setOrderCreatedDate(LocalDate orderCreatedDate) {
		this.orderCreatedDate = orderCreatedDate;
	}

	public LocalDateTime getOrderCreatedDateTime() {
		return orderCreatedDateTime;
	}

	public void setOrderCreatedDateTime(LocalDateTime orderCreatedDateTime) {
		this.orderCreatedDateTime = orderCreatedDateTime;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderName=" + orderName + ", orderDesc=" + orderDesc + ", orderCreatedDate="
				+ orderCreatedDate + ", orderCreatedDateTime=" + orderCreatedDateTime + "]";
	}
}

class LocalDateSerializer implements JsonSerializer<LocalDate> {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

	@Override
	public JsonElement serialize(LocalDate localDate, Type srcType, JsonSerializationContext context) {
		return new JsonPrimitive(formatter.format(localDate));
	}
}

class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss");

	@Override
	public JsonElement serialize(LocalDateTime localDateTime, Type srcType, JsonSerializationContext context) {
		return new JsonPrimitive(formatter.format(localDateTime));
	}
}

class LocalDateDeserializer implements JsonDeserializer<LocalDate> {
	@Override
	public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return LocalDate.parse(json.getAsString(),
				DateTimeFormatter.ofPattern("d-MMM-yyyy").withLocale(Locale.ENGLISH));
	}
}

class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {
	@Override
	public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return LocalDateTime.parse(json.getAsString(),
				DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss").withLocale(Locale.ENGLISH));
	}
}

