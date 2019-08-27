package com.internousdev.ecsite.dto;

public class ItemInfoDTO {
	private String itemName;
	private String itemPrice;
	private String itemstock;
	private String id;
	private String insert_date;
	private String update_date;
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemstock() {
		return itemstock;
	}
	public void setItemstock(String itemstock) {
		this.itemstock = itemstock;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
