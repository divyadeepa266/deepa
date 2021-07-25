package BikeProject.BikeInformation;

import java.util.List;

import BikeProject.Bike.BikeInformation;

public interface BikeDetailsInterface {
	List<BikeInformation> SaveBike(BikeInformation binfor);	
	List<BikeInformation> getbiBikeAll();
	List<BikeInformation> getBikeName(String name);
	List<BikeInformation> deleteBikeName(String Name);
	List<BikeInformation> deleteBikeAll();
	
}
