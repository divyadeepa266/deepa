package WindowsGui.Frame;

import java.io.Serializable;

public class ItemListDeepa implements Serializable{
private String ListName;
private String ListDesc;
private String Offer;
private int price;
public ItemListDeepa(String listName, String listDesc, String offer, int price) {
	super();
	ListName = listName;
	ListDesc = listDesc;
	Offer = offer;
	this.price = price;
}
public ItemListDeepa() {
	super();
	// TODO Auto-generated constructor stub
}
public String getListName() {
	return ListName;
}
public void setListName(String listName) {
	ListName = listName;
}
public String getListDesc() {
	return ListDesc;
}
public void setListDesc(String listDesc) {
	ListDesc = listDesc;
}
public String getOffer() {
	return Offer;
}
public void setOffer(String offer) {
	Offer = offer;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
@Override
public String toString() {
	return  ListName + ", ListDesc=" + ListDesc + ", Offer=" + Offer + ", price=" + price
			+ "\n";
}

}
