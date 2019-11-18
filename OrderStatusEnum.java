package com.msr.oms.utils;

/**
 * The Enum OrderStatusEnum.
 * @author vamshib
 */
public enum OrderStatusEnum {

	/** The order create. */
	ORDER_CREATE(0,"CREATE"),

	/** The order delete. */
	ORDER_DELETE(1,"DELETE"),

	/** The order update. */
	ORDER_UPDATE(2,"UPDATED"),

	/** The order active. */
	ORDER_ACTIVE(3,"ACTIVE"),

	/** The order finalize. */
	ORDER_FINALIZE(4,"FINALIZED"),

	ORDER_CONFIRMATION(5,"ORDER CONFIRMATION");

	/** The value. */
	private final int value;

	/** The status. */
	private final String status;


	/**
	 * Instantiates a new order status enum.
	 *
	 * @param value the value
	 * @param status the status
	 */
	OrderStatusEnum(int value,String status) {
		this.value = value;
		this.status = status;
	}


	/**
	 * Return the integer value of this status code.
	 *
	 * @return the int
	 */
	public int value() {
		return this.value;
	}

	/**
	 * Return the integer value of this status code.
	 *
	 * @return the int
	 */
	public String status() {
		return this.status;
	}
}
