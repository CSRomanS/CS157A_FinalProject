package entity;

import java.util.List;

public class Order {
	
	private Integer orderID;
	
	private Integer userID;
	
	private String datePlaced;
	
	private Float cost;
	
	private Float taxes;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private Integer zipCode;
	
	private List<OrderItems> orderItems;

	public Order() {
	}

	public Order(Integer orderID, Integer userID, String datePlaced, Float cost, Float taxes, String address,
			String city, String state, Integer zipCode, List<OrderItems> orderItems) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.datePlaced = datePlaced;
		this.cost = cost;
		this.taxes = taxes;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.orderItems = orderItems;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getDatePlaced() {
		return datePlaced;
	}

	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Float getTaxes() {
		return taxes;
	}

	public void setTaxes(Float taxes) {
		this.taxes = taxes;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", userID=" + userID + ", datePlaced=" + datePlaced + ", cost=" + cost
				+ ", taxes=" + taxes + ", address=" + address + ", city=" + city + ", state=" + state + ", zipCode="
				+ zipCode + ", orderItems=" + orderItems + "]";
	}

}
