package com.restaurant.entity;

public class Expand {
	private int id;
	private String date;
	private String type;
	private double money;
	private String message;

	public Expand(double money) {
		this.money = money;
	}

	public Expand(int id, String date, String type, double money, String message) {
		this.id = id;
		this.date = date;
		this.type = type;
		this.money = money;
		this.message = message;
	}

	public Expand(String date, String type, double money, String message) {
		this.date = date;
		this.type = type;
		this.money = money;
		this.message = message;
	}

	public Expand(int id, String date, String type, double money) {
		this.id = id;
		this.date = date;
		this.type = type;
		this.money = money;
	}

	public Expand() {
	}

	@Override
	public String toString() {
		return "Expand{" +
				"id=" + id +
				", date='" + date + '\'' +
				", type='" + type + '\'' +
				", money=" + money +
				", message='" + message + '\'' +
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
