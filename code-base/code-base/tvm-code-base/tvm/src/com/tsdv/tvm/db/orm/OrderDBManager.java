package com.tsdv.tvm.db.orm;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.tsdv.tvm.db.dbms.DBManager;
import com.tsdv.tvm.db.dbms.InMemoryDBManager;

/**
 * Class for managing the order
 */
public class OrderDBManager {
	private final DBManager dbOrder;	
	public static final String ORDER_NAME = "Order";
	private static OrderDBManager orderDBManager;
	
	private OrderDBManager() {
		dbOrder = InMemoryDBManager.instance();
    }
	
	public static OrderDBManager instance() {
    	if (orderDBManager == null) {
    		orderDBManager = new OrderDBManager();
    		
    		orderDBManager.clean();
    		//orderDBManager.init();
    	}
    	return orderDBManager;
    }
	
	public void clean() {
        List<Properties> rows = dbOrder.get(ORDER_NAME);
        for (Properties row : rows) {
        	dbOrder.delete(ORDER_NAME, row);
        }
    }
	
	private void addOrder(Order order) {
        Properties orderProperties = new Properties();

        orderProperties.put(
                Order.ORDER_ID,
                order.orderID);

        orderProperties.put(
        		Order.NUMBER_CERTIFICATES,
        		order.numberCertificates);

        dbOrder.insert(ORDER_NAME, orderProperties);
    }
	
	public List<Order> getAllOrders() {
        List<Order> allOrders = new ArrayList<>();
        List<Properties> rows = dbOrder.get(ORDER_NAME);
        for (Properties row : rows) {
            long orderID = Long.parseLong(row.getProperty(Order.ORDER_ID));
            allOrders.add(new Order(orderID));
        }
        return allOrders;
    }
}
