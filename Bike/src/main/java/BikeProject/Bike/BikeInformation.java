package BikeProject.Bike;

import java.io.Serializable;

public class BikeInformation implements Serializable{
	private String BikeName;
	private int BikeModel;
	private String BikeType;
	private Double Milage;
	private Double Price;
	
	BikeInformation(){
		super();
	}

	public BikeInformation(String bikeName, int bikeModel, String bikeType, Double milage, Double price) {
		super();
		BikeName = bikeName;
		BikeModel = bikeModel;
		BikeType = bikeType;
		Milage = milage;
		Price = price;
	}

	@Override
	public String toString() {
		return "BikeInformation [BikeName=" + BikeName + ", BikeModel=" + BikeModel + ", BikeType=" + BikeType
				+ ", Milage=" + Milage + ", Price=" + Price + "]"+"\n";
	}

	public String getBikeName() {
		return BikeName;
	}

	public void setBikeName(String bikeName) {
		BikeName = bikeName;
	}

	public int getBikeModel() {
		return BikeModel;
	}

	public void setBikeModel(int bikeModel) {
		BikeModel = bikeModel;
	}

	public String getBikeType() {
		return BikeType;
	}

	public void setBikeType(String bikeType) {
		BikeType = bikeType;
	}

	public Double getMilage() {
		return Milage;
	}

	public void setMilage(Double milage) {
		Milage = milage;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}
	
	
}
