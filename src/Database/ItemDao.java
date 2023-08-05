package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Item;
import entity.Review;

public class ItemDao {

	/**
	 * get item by itemID
	 * 
	 * @return item
	 */
	public Item getItem(Integer itemID) {

		Connection con = DBConnect.Connect();
		Item item = new Item();
		List<String> photos = new ArrayList<String>();
		List<Review> reviews = new ArrayList<Review>();
		

		try {
			Statement statement = con.createStatement();
			statement.executeQuery(
					"SELECT ItemID, ItemName, MainDescription, CategoryDescription, Price, SalePrice, SaleEnds, ScheduledPrice, Stock, CoverPicture, CategoryID, IsFeatured, CoverPicture FROM items "
							+ "WHERE ItemID=" + itemID + ";");
			ResultSet rs = statement.getResultSet();
			
			while (rs.next()) {
				item.setItemID(rs.getInt(1));
				item.setItemName(rs.getString(2));
				item.setMainDescription(rs.getString(3));
				item.setCategoryDescription(rs.getString(4));
				item.setPrice(rs.getFloat(5));
				item.setSalePrice(rs.getFloat(6));
				item.setSaleEnds(rs.getDate(7));
				item.setScheduledPrice(rs.getFloat(8));
				item.setStock(rs.getInt(9));
				item.setCoverPicture(rs.getString(10));
				item.setCategoryID(rs.getInt(11));
				item.setIsFeatured(rs.getInt(12));
			}
			
			//get item photos
			statement.executeQuery("SELECT Link FROM pictures WHERE ItemID =" + itemID + ";");
			ResultSet rs2 = statement.getResultSet();
			while (rs2.next()) {
				photos.add(rs2.getString(1));
			}
			
			item.setPhotos(photos);
			
			statement.executeQuery("SELECT r.ReviewsID, r.StarRating, r.ReviewText, r.Picture, r.AuthorID, u.FirstName, u.LastName FROM reviews r, users u WHERE ItemID = " + itemID + " AND r.AuthorID = u.UserID;");
			ResultSet rs3 = statement.getResultSet();
			while (rs3.next()) {
				Review r = new Review();
				r.setReviewsID(rs3.getInt(1));
				r.setStarRating(rs3.getInt(2));
				r.setReviewText(rs3.getString(3));
				r.setPicture(rs3.getString(4));
				r.setAuthorID(rs3.getInt(5));
				r.setAuthorName(rs3.getString(6) + " " + rs3.getString(7));
				reviews.add(r);
			}
			item.setReviews(reviews);
			
			DBConnect.close(con, statement, rs);
			return item;
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * select all featured items to show on the homepage banner
	 * 
	 * @return list of featured items
	 */
	public List<Item> getFeaturedItems() {

		Connection con = DBConnect.Connect();
		List<Item> items = new ArrayList<Item>();

		try {
			Statement statement = con.createStatement();
			statement.executeQuery("SELECT ItemId, CoverPicture FROM items " + "WHERE IsFeatured=1 LIMIT 5;");
			ResultSet rs = statement.getResultSet();

			while (rs.next()) {
				Item item = new Item();
				item.setItemID(rs.getInt(1));
				item.setCoverPicture(rs.getString(2));
				items.add(item);
			}
			DBConnect.close(con, statement, rs);
			return items;
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * select items by categoryID
	 * 
	 * @return list of items under the category
	 */
	public List<Item> getItemsByCate(Integer categoryID) {

		Connection con = DBConnect.Connect();
		List<Item> items = new ArrayList<Item>();

		try {
			Statement statement = con.createStatement();
			statement.executeQuery("SELECT ItemId, CoverPicture, ItemName, Price FROM items " + "WHERE CategoryID="
					+ categoryID + " LIMIT 8;");
			ResultSet rs = statement.getResultSet();

			while (rs.next()) {
				Item item = new Item();
				item.setItemID(rs.getInt(1));
				item.setCoverPicture(rs.getString(2));
				item.setItemName(rs.getString(3));
				item.setPrice(rs.getFloat(4));
				items.add(item);
			}
			DBConnect.close(con, statement, rs);
			return items;
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

}