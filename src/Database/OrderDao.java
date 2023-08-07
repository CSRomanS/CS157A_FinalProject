package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import entity.Item;
import entity.Order;
import entity.OrderItems;

public class OrderDao {

	private ItemDao iDao = new ItemDao();

	public List<Order> getOrderList(Integer userID) {
		List<Order> orders = new ArrayList<Order>();

		Connection conn = DBConnect.Connect();

		try {

			// Fetch the orders for a particular user
			String orderSql = "SELECT * FROM orders WHERE userID = ? ORDER BY DatePlaced DESC";
			PreparedStatement orderPs = conn.prepareStatement(orderSql);
			orderPs.setInt(1, userID);

			ResultSet orderRs = orderPs.executeQuery();

			// Using a map to avoid nested queries for order items
			Map<Integer, Order> orderMap = new HashMap<>();

			while (orderRs.next()) {
				Order order = new Order();
				order.setOrderID(orderRs.getInt("OrderId"));
				order.setUserID(orderRs.getInt("UserID"));
				order.setDatePlaced(orderRs.getString("DatePlaced"));
				order.setCost(orderRs.getFloat("Cost"));
				order.setTaxes(orderRs.getFloat("Taxes"));
				order.setAddress(orderRs.getString("AddressLineOne"));
				order.setCity(orderRs.getString("City"));
				order.setState(orderRs.getString("State"));
				order.setZipCode(orderRs.getInt("ZipCode"));
				order.setOrderItems(new ArrayList<>());

				orders.add(order);
				orderMap.put(order.getOrderID(), order);
			}

			// Fetch the order items for these orders
			// Make orderId to a String split with ","
			String placeholders = String.join(",", Collections.nCopies(orderMap.keySet().size(), "?"));

			String orderItemsSql = "SELECT oi.* FROM orderitems oi WHERE oi.orderID IN (" + placeholders + ")";
			PreparedStatement orderItemsPs = conn.prepareStatement(orderItemsSql);

			int index = 1;
			for (Integer orderId : orderMap.keySet()) {
			    orderItemsPs.setInt(index++, orderId);
			}

			ResultSet orderItemsRs = orderItemsPs.executeQuery();

			while (orderItemsRs.next()) {
				OrderItems orderItem = new OrderItems();
				orderItem.setItemID(orderItemsRs.getInt("itemID"));
				orderItem.setItemCount(orderItemsRs.getInt("itemCount"));
				orderItem.setItemCost(orderItemsRs.getInt("itemCost"));
				orderItem.setOrderID(orderItemsRs.getInt("orderID"));

				Item item = iDao.getItem(orderItem.getItemID());
				orderItem.setItem(item);

				Order associatedOrder = orderMap.get(orderItem.getOrderID());
				associatedOrder.getOrderItems().add(orderItem);
			}
			DBConnect.close(conn, orderPs, null);
			return orders;
		} catch (java.sql.SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}

	}

}
