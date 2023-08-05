package entity;

public class Review {

	private int reviewsID;

	private int starRating;

	private String reviewText;

	private String picture;

	private int authorID;
	
	private String authorName;

	private int ItemID;

	public Review() {
	}


	public Review(int reviewsID, int starRating, String reviewText, String picture, int authorID, String authorName,
			int itemID) {
		super();
		this.reviewsID = reviewsID;
		this.starRating = starRating;
		this.reviewText = reviewText;
		this.picture = picture;
		this.authorID = authorID;
		this.authorName = authorName;
		ItemID = itemID;
	}



	public int getReviewsID() {
		return reviewsID;
	}

	public void setReviewsID(int reviewsID) {
		this.reviewsID = reviewsID;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public int getItemID() {
		return ItemID;
	}

	public void setItemID(int itemID) {
		ItemID = itemID;
	}
	

	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	@Override
	public String toString() {
		return "Review [reviewsID=" + reviewsID + ", starRating=" + starRating + ", reviewText=" + reviewText
				+ ", picture=" + picture + ", authorID=" + authorID + ", authorName=" + authorName + ", ItemID="
				+ ItemID + "]";
	}


}
