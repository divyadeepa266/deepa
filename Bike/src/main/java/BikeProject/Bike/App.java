package BikeProject.Bike;

import java.util.Arrays;
import java.util.Scanner;
//import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Welcome Bike Conusultancy");
		System.out.println("Enter Login Name");
		Scanner u=new Scanner(System.in);
		String us=u.nextLine();		
		System.out.println("Enter Login Password");
		Scanner p=new Scanner(System.in);
		String ps=u.nextLine();	
		
    	
    	Bike b=new Bike(us,ps);
    	boolean bool=b.isAuthorizebool();
    	if(!bool) {
    		System.out.println("Thank you");
    	}else {
    		String Name="";
    		if(Name.trim().length()==0) {
    			for(int i=0;i<1000;i++) {
    				boolean bool1=GetStart(b);
    				if(bool1) {
    					continue;
    				}
    				else {
    					return;
    				}
    			}
        		
        		
    		}
    		
    	}
    	//String bikeName, int bikeModel, String bikeType, Double milage, Double price
    	
    	
    }
    public static boolean GetStart(Bike b) {
    	boolean bool=false;
    	System.out.println("1.Create Data"+"\n"+"2.Show Data"+"\n"+"3.Filter By Name"+"\n"+"4.Delete By Name"+"\n"+"5.Restore");
		System.out.println("Give one Number");
		Scanner s=new Scanner(System.in);
		String Name=s.nextLine();
		switch(Name) {
		case "1":
				        	
    			detUserData(b);
    			System.out.println("Do want to See Save the Data Y/N");
        		Scanner ConfirmData=new Scanner(System.in);
        		String value=ConfirmData.nextLine();
        		if(value.equalsIgnoreCase("Y")) {
            		System.out.println(b.getbiBikeAll());
            		return true;
        		}
        		else {
        			System.out.println("Do  u want to exit Y/N");
            		Scanner EData=new Scanner(System.in);
            		String Evalue=EData.nextLine();
            		if(Evalue.equalsIgnoreCase("Y")) {
            			break;
            		}
            		else {
            			return true;
            		}
            		
        		}        		
    		    	    	
		case "2":
			System.out.println("Show All Data="+b.getbiBikeAll());
			System.out.println("Do  u want to exit Y/N");
    		Scanner EData=new Scanner(System.in);
    		String Evalue=EData.nextLine();
    		if(Evalue.equalsIgnoreCase("Y")) {
    			break;
    		}
    		else {
    			return true;
    		}
		case "3":
			boolean boolFil=filterData(b);
			if(boolFil) {
				System.out.println("Do u want to exit Y/N");
	    		Scanner FData=new Scanner(System.in);
	    		String Fvalue=FData.nextLine();
	    		if(Fvalue.equalsIgnoreCase("Y")) {
	    			break;
	    		}
	    		else {
	    			return true;
	    		}	
			}
		case "4":
			System.out.println("Enter deleted Bike Name");
			Scanner DData=new Scanner(System.in);
			String Fvalue=DData.nextLine();
			b.deleteBikeName(Fvalue);
			if(!b.Delbool) {
		    	System.out.println("No Data Available");

			}else {
		    	System.out.println("Do want to See the Data? Y/N");
		    	Scanner Data=new Scanner(System.in);
				String dataval=Data.nextLine();
				if(dataval.equalsIgnoreCase("Y")) {
					System.out.println(b.getbiBikeAll());
					System.out.println("Do u want to exit Y/N");
		    		Scanner EEData=new Scanner(System.in);
		    		String EEvalue=EEData.nextLine();
		    		if(EEvalue.equalsIgnoreCase("Y")) {
		    			break;
		    		}
		    		else {
		    			return true;
		    		}	
				}
				else {
					System.out.println("Do u want to exit Y/N");
		    		Scanner EEData=new Scanner(System.in);
		    		String EEvalue=EEData.nextLine();
		    		if(EEvalue.equalsIgnoreCase("Y")) {
		    			break;
		    		}
		    		else {
		    			return true;
		    		}	
				}
			}
	    	
		case "5":    	
			b.restore();
			if(!b.Restorebool) {				
				System.out.println("Do u want to exit Y/N");
	    		Scanner EEData=new Scanner(System.in);
	    		String EEvalue=EEData.nextLine();
	    		if(EEvalue.equalsIgnoreCase("Y")) {
	    			break;
	    		}
	    		else {
	    			return true;
	    		}	
			}
			else {
				System.out.println("Show All Data="+b.getbiBikeAll());
				System.out.println("Do u want to exit Y/N");
	    		Scanner EEData=new Scanner(System.in);
	    		String EEvalue=EEData.nextLine();
	    		if(EEvalue.equalsIgnoreCase("Y")) {
	    			break;
	    		}
	    		else {
	    			return true;
	    		}	
			}
	    default:
			System.out.println("All="+b.getbiBikeAll());


		}
		return bool;
    }
    public static  void detUserData(Bike b) {
    	String dataval="";
    	for(int i=0;i<=1000;i++) {    		
    	System.out.println("Give Bike Name, Year, Type, Millage and Price");
		Scanner BName=new Scanner(System.in);
		String BiName=BName.nextLine();
		Scanner BYar=new Scanner(System.in);
		int BYear=BYar.nextInt();
		Scanner BType=new Scanner(System.in);
		String Btype=BType.nextLine(); 
		Scanner BMillage=new Scanner(System.in);
		Double bmillage=BMillage.nextDouble();
		Scanner Bprice=new Scanner(System.in);
		Double bprice=Bprice.nextDouble();
		BikeInformation binfor1=new BikeInformation(BiName,BYear,Btype,bmillage,bprice);
    	b.SaveBike(binfor1);		
		System.out.println("Do want to contiue Create Data? Y/N");
    	Scanner Data=new Scanner(System.in);
		dataval=Data.nextLine();
		if(dataval.equalsIgnoreCase("Y")) {
			continue;
		}
		else {
			return;

		}
    	}
		
	}
    public static boolean filterData(Bike b) {
    	boolean bool=false;
    	String Fvalue="";
    	for(int  i=0;i<=1000;i++) {
    	System.out.println("Enter Bike Name");
		Scanner FData=new Scanner(System.in);
		Fvalue=FData.nextLine();
		b.getBikeName(Fvalue.trim());
		if(b.bool) {
	    	System.out.println("filter="+b.getBikeName(Fvalue));
	    	System.out.println("Do want to contiue Filter Data? Y/N");
	    	Scanner Data=new Scanner(System.in);
			String dataval=Data.nextLine();
			if(dataval.equalsIgnoreCase("Y")) {
				continue;
			}
			else {
				return true;

			}
		}
		else {
			System.out.println("No data Available");
			System.out.println("Do want to contiue Filter Data? Y/N");
	    	Scanner Data=new Scanner(System.in);
			String dataval=Data.nextLine();
			if(dataval.equalsIgnoreCase("Y")) {
				continue;
			}
			else {
				return true;

			}
		}
		
    	}
		return bool;
    }
}
