package test2;

import java.util.List;

public class OrderCommand {

	private List<OrderItem> orderItems;
	private Address address;

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
