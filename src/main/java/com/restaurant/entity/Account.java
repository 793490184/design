package com.restaurant.entity;

public class Account {
	private int id;
	private String date;
	private String name;
	private String message;
	private double money;
	private int paidFlag;

	public Account(int id, String date, String name, String message, double money, int paidFlag) {
		this.id = id;
		this.date = date;
		this.name = name;
		this.message = message;
		this.money = money;
		this.paidFlag = paidFlag;
	}

	public Account(String date, String name, String message, double money, int paidFlag) {
		this.date = date;
		this.name = name;
		this.message = message;
		this.money = money;
		this.paidFlag = paidFlag;
	}

	public Account() {
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", date='" + date + '\'' +
				", name='" + name + '\'' +
				", message='" + message + '\'' +
				", money=" + money +
				", paidFlag=" + paidFlag +
				'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getPaidFlag() {
		return paidFlag;
	}

	public void setPaidFlag(int paidFlag) {
		this.paidFlag = paidFlag;
	}
}
