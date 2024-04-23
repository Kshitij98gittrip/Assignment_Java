package com.app.customer;

//Enum for the service plan 
public enum ServicePlan {
	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000);
	
	private double planAmount;
	
	private ServicePlan(double planAmount) {
		this.planAmount = planAmount;
	}
	
	public String toString() {
		return name()+":"+planAmount;
	}
	
	public double getPlanAmount() {
		return planAmount;
	}
}
