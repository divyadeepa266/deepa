package Deepa.ConsoleEcommerce;

import java.io.Serializable;
import java.util.List;

public class ListItem implements Serializable{
	private String ItemName;
	private String Detail;
	private String ItemOffers;
	private int price;	
	public ListItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListItem(String itemName, String detail, String itemOffers, int price) {
		super();
		ItemName = itemName;
		Detail = detail;
		ItemOffers = itemOffers;
		this.price = price;
	
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}
	public String getItemOffers() {
		return ItemOffers;
	}
	public void setItemOffers(String itemOffers) {
		ItemOffers = itemOffers;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ListItem [ItemName=" + ItemName + ", Detail=" + Detail + ", ItemOffers=" + ItemOffers + ", price="
				+ price + "]";
	}

	
	
	
}
