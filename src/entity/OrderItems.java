package entity;

public class OrderItems {

	
	private Integer itemID;
	
	private Integer itemCount;
	
	private Integer itemCost;
	
	private Integer orderID;
	

	public OrderItems() {
	}

	public OrderItems(Integer itemID, Integer itemCount, Integer itemCost, Integer orderID) {
		super();
		this.itemID = itemID;
		this.itemCount = itemCount;
		this.itemCost = itemCost;
		this.orderID = orderID;
	}

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	public Integer getItemCount() {
		return itemCount;
	}

	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	public Integer getItemCost() {
		return itemCost;
	}

	public void setItemCost(Integer itemCost) {
		this.itemCost = itemCost;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	@Override
	public String toString() {
		return "OrderItems [itemID=" + itemID + ", itemCount=" + itemCount + ", itemCost=" + itemCost + ", orderID="
				+ orderID + "]";
	}
	
	
}
