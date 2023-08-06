package entity;

public class CartItem {

	private Integer userID;
	
	private Integer itemCount;
	
	private Item item;
	

	public CartItem() {
		super();
	}

	public CartItem(Integer userID, Integer itemCount, Item item) {
		super();
		this.userID = userID;
		this.itemCount = itemCount;
		this.item = item;
	}


	public Integer getUserID() {
		return userID;
	}


	public void setUserID(Integer userID) {
		this.userID = userID;
	}


	public Integer getItemCount() {
		return itemCount;
	}


	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	@Override
	public String toString() {
		return "Cart [userID=" + userID + ", itemCount=" + itemCount + ", item=" + item + "]";
	}
	
	
}
