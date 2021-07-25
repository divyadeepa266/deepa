package NewProject.Samle;

import java.io.Serializable;
import java.util.Date;

class BikeInformation implements Serializable{
	private String BikeName;
	private int BikeNumber;
	private String BikeInsurance;
	private String BikeHandlerInfo;
	private int Price;
	private Date StartDate;
	/*private BikeInformation bI=new BikeInformation();
	
	public BikeInformation bikeInko() {
		return bI;
	}*/
	
	public BikeInformation(String bikeName, int bikeNumber, String bikeHandlerInfo, int price) {
		super();
		BikeName = bikeName;
		BikeNumber = bikeNumber;
		BikeHandlerInfo = bikeHandlerInfo;
		Price = price;
	}


	@Override
	public String toString() {
		return "BikeInformation [getBikeName()=" + getBikeName() + ", getBikeNumber()=" + getBikeNumber()
				+ ", getBikeInsurance()=" + getBikeInsurance() + ", getBikeHandlerInfo()=" + getBikeHandlerInfo()
				+ ", getPrice()=" + getPrice() + ", getStartDate()=" + getStartDate();
	}


	public BikeInformation(String bikeName, int bikeNumber, String bikeInsurance, String bikeHandlerInfo,
			int price, Date startDate) {
		super();
		BikeName = bikeName;
		BikeNumber = bikeNumber;
		BikeInsurance = bikeInsurance;
		BikeHandlerInfo = bikeHandlerInfo;
		Price = price;
		StartDate = startDate;
	}

	
	public BikeInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBikeName() {
		return BikeName;
	}
	public int getBikeNumber() {
		return BikeNumber;
	}
	public String getBikeInsurance() {
		return BikeInsurance;
	}
	public String getBikeHandlerInfo() {
		return BikeHandlerInfo;
	}
	public int getPrice() {
		return Price;
	}
	public Date getStartDate() {
		return StartDate;
	}
	
	public void setBikeName(String bikeName) {
		BikeName = bikeName;
	}
	public void setBikeNumber(int bikeNumber) {
		BikeNumber = bikeNumber;
	}
	public void setBikeInsurance(String bikeInsurance) {
		BikeInsurance = bikeInsurance;
	}
	public void setBikeHandlerInfo(String bikeHandlerInfo) {
		BikeHandlerInfo = bikeHandlerInfo;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
}
