package NewProject.Samle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	/*BikeController bis=new BikeController();
    	BikeInformation bi=new BikeInformation("Tvs",9874,"2nd Hand",25000);
    	BikeInformation bi2=new BikeInformation("Bajaj",9875,"2nd Hand",30000);//String bikeName, int bikeNumber, String bikeHandlerInfo, int price
    	*/
    //	bis.CreateDetails(bi);
    	BikeController bc=new BikeController();
    	// System.out.println(bis.CreateDetails(bi));
    	 System.out.println(bc.getBikeAll());
    	//bis.getBikeAll();
    }
}
