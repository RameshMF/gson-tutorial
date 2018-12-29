package net.javaguides.gson;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GSONDynamicallyExcludeFields {

	public static void main(String[] args) {
		Order1 order = new Order1();
		order.setId(100);
		order.setOrderName("Book purchase");
		order.setOrderDesc("Java Head First");
		order.setOrderStatus("New");
		order.setOrderAmount(1100.0);
		// normal serialization
        Gson gson = new GsonBuilder().create();
        String result = gson.toJson(order);
		System.out.println(result);
		
		// dynamic serialization on order
        gson = new GsonBuilder()
                .registerTypeAdapter(Order1.class, new OrderSerializer())
                .create();
        result = gson.toJson(order);
        System.out.println(result);
        
	
	}

}

class OrderSerializer implements JsonSerializer<Order1> {

	@Override
	public JsonElement serialize(Order1 order, Type srcType, JsonSerializationContext context) {
		JsonObject jObj = (JsonObject)new GsonBuilder().create().toJsonTree(order);
		
		if(order.getOrderAmount() > 1000.0) {
			jObj.remove("orderStatus");
		}
		
		// change order status dynamically
		jObj.addProperty("orderStatus", "Completed");
		return jObj;
	}
}

class Order1 {
	private int id;
	private String orderName;
	private String orderDesc;
	private double orderAmount;
	private String orderStatus;

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

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
