package entity;

import java.util.Date;
import java.util.List;

public class Item {
	
private Integer itemID;
	
	private String itemName;
	
	private String mainDescription;
	
	private String categoryDescription;
	
	private Float price;
	
	private Float salePrice;
	
	private Date saleEnds;
	
	private Float scheduledPrice;
	
	private Integer stock;
	
	private String coverPicture;
	
	private Integer categoryID;
	
	private int isFeatured;
	
	private List<String> photos;
	
	private List<Review> reviews;
	
	public Item() {
	}

	public Item(Integer itemID, String itemName, String mainDescription, String categoryDescription, Float price,
			Float salePrice, Date saleEnds, Float scheduledPrice, Integer stock, String coverPicture,
			Integer categoryID, int isFeatured, List<String> photos, List<Review> reviews) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.mainDescription = mainDescription;
		this.categoryDescription = categoryDescription;
		this.price = price;
		this.salePrice = salePrice;
		this.saleEnds = saleEnds;
		this.scheduledPrice = scheduledPrice;
		this.stock = stock;
		this.coverPicture = coverPicture;
		this.categoryID = categoryID;
		this.isFeatured = isFeatured;
		this.photos = photos;
		this.reviews = reviews;
	}

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getMainDescription() {
		return mainDescription;
	}

	public void setMainDescription(String mainDescription) {
		this.mainDescription = mainDescription;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}

	public Date getSaleEnds() {
		return saleEnds;
	}

	public void setSaleEnds(Date saleEnds) {
		this.saleEnds = saleEnds;
	}

	public Float getScheduledPrice() {
		return scheduledPrice;
	}

	public void setScheduledPrice(Float scheduledPrice) {
		this.scheduledPrice = scheduledPrice;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCoverPicture() {
		return coverPicture;
	}

	public void setCoverPicture(String coverPicture) {
		this.coverPicture = coverPicture;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public int getIsFeatured() {
		return isFeatured;
	}

	public void setIsFeatured(int isFeatured) {
		this.isFeatured = isFeatured;
	}
	
	

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}
	
	

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", mainDescription=" + mainDescription
				+ ", categoryDescription=" + categoryDescription + ", price=" + price + ", salePrice=" + salePrice
				+ ", saleEnds=" + saleEnds + ", scheduledPrice=" + scheduledPrice + ", stock=" + stock
				+ ", coverPicture=" + coverPicture + ", categoryID=" + categoryID + ", isFeatured=" + isFeatured
				+ ", photos=" + photos + ", reviews=" + reviews + "]";
	}


}
