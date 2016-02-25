package com.sample.proteintracker;

public class HistoryItem {
	private int id;
	private int amount;
	private String operation;
	private int total;

	public HistoryItem() {}
	
	public HistoryItem(int id, int amount, String operation, int total) {
		super();
		this.id = id;
		this.amount = amount;
		this.operation = operation;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
