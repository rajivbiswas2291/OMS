package com.msr.oms.dto;

public class OrderAssignDto {

	/** The order id. */
	private Long orderAssignToId;
	
	
	/** The assigned to. */
	private String assignedTo;


	public Long getOrderAssignToId() {
		return orderAssignToId;
	}


	public void setOrderAssignToId(Long orderAssignToId) {
		this.orderAssignToId = orderAssignToId;
	}


	public String getAssignedTo() {
		return assignedTo;
	}


	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

}
