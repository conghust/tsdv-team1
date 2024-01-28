package com.tsdv.tvm.db.orm;

import java.util.List;

public class Order {
	public static final String ORDER_ID = "OrderID";
	public static final String NUMBER_CERTIFICATES= "NumberCertificatesID";
	public static final String GTIN = "GTIN";
	public static final String TRAVEL_CERTIFICATES_ID = "TravelCertificatesID";
	
	long orderID;
	int numberCertificates;
	
	public Order(long orderID) {
        this.orderID = orderID;
    }
}
