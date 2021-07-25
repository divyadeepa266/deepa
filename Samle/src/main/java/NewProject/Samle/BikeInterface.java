package NewProject.Samle;

import java.util.List;

public interface BikeInterface {
	List<BikeInformation> CreateDetails(BikeInformation bI);
	List<BikeInformation> getBikeAll();
	String SaveBikeDetails();
	String getBikeDetails();
	String getBikeDetailsfromBike(String Name);
	String getBikeDetailsfromHandler(String Name);
	String deleteBikeFromName(String Name,int Number);
	
	
	
}
