package com.cts.avijeet.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menus")
public class Menu {
	@Id
	private int MenuId;
	private String MenuName;
	private double price;
	private Date date;
	public int getMenuId() {
		return MenuId;
	}
	public void setMenuId(int menuId) {
		MenuId = menuId;
	}
	public String getMenuName() {
		return MenuName;
	}
	public void setMenuName(String menuName) {
		MenuName = menuName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Menu [MenuId=" + MenuId + ", MenuName=" + MenuName + ", price=" + price 
				+ ", date=" + date + "]";
	}
	public Menu(int menuId, String menuName, double price, double volume, Date date) {
		super();
		MenuId = menuId;
		MenuName = menuName;
		this.price = price;
		
		this.date = date;
	}
	
	

}
