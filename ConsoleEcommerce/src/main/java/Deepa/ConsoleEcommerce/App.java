package Deepa.ConsoleEcommerce;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

/**
 * Hello world!
 *
 */
public class App
{	
	static File ItemFile=new File("C:\\Users\\Public\\deepa\\Shopping\\Item.doc");
	static File LogiFile=new File("C:\\Users\\Public\\deepa\\Shopping\\Login.doc");
	static File BinFile;
	static File ItemBinFile;
	static LoginProcess lp=new LoginProcess();
	static File UserF;
	static Scanner scan=new Scanner(System.in);
    public static void main( String[] args )
   {    	
    	ShowList();
    	LoginProcess();
		

    }
    
    public static void LoginProcess() {
    	List<LoginProcess> LogiLi=new ArrayList();
    	System.out.println("Login, Logout");
    	if(scan.next().equalsIgnoreCase("Login")) {
    		System.out.println("Enter Login Name");
    		lp.setUName(scan.next());
    		System.out.println("Enter Password");
    		lp.setUPass(scan.next());
    		//LogiLi.add(lp);
    		boolean loginbool=false;
			try {
				FileInputStream fis = new FileInputStream(LogiFile);
				ObjectInputStream ois=new ObjectInputStream(fis);
				LogiLi=(ArrayList)ois.readObject();
				ois.close();fis.close();

				for(int i=0;i<LogiLi.size();i++) {
					String Data=LogiLi.get(i).toString().trim();
					if(lp.toString().trim().equalsIgnoreCase(Data)) {
						loginbool=true;
					}
				}
				if(!loginbool) {
					System.out.println("New Register ");
					System.out.println("Enter Login Name");
		    		lp.setUName(scan.next());
		    		System.out.println("Enter Password");
		    		lp.setUPass(scan.next());
		    		FileOutputStream fos = new FileOutputStream(LogiFile);
					ObjectOutputStream oos=new ObjectOutputStream(fos);
					oos.writeObject(LogiLi);
					oos.close();fos.close();
		    		LogiLi.add(lp);
		    		try {
						FileOutputStream fos2 = new FileOutputStream(LogiFile);
						ObjectOutputStream oos2=new ObjectOutputStream(fos2);
						oos2.writeObject(LogiLi);
						System.out.println("Sucess Register ");

						loginbool=true;
						oos2.close();fos2.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("New Register");

				LogiLi=new ArrayList();
				// TODO Auto-generated catch block
				System.out.println("Enter Login Name");
	    		lp.setUName(scan.next());
	    		System.out.println("Enter Password");
	    		lp.setUPass(scan.next());
	    		LogiLi.add(lp);
				try {
					FileOutputStream fos = new FileOutputStream(LogiFile);
					ObjectOutputStream oos=new ObjectOutputStream(fos);
					oos.writeObject(LogiLi);
					System.out.println("Sucess Register ");

					oos.close();fos.close();
					loginbool=true;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			if(loginbool) {
				if(lp.getUName().equalsIgnoreCase("Admin")&& lp.getUPass().equalsIgnoreCase("Admin")) {
				//	System.out.println("AdminProcess");
					AdminProcess();
				}else {
					//System.out.println("UserProcess");
					UserProcess();
				}
			}
    		

    	}else {
    		return;
    	}
    }
    public static void ShowList() {
    	boolean Itembool=false;
    	System.out.println("Welcome E Shopping ");
    	List<ItemListDeepa> itemLi=new ArrayList();
    	//File ItemFile=new File("C:\\Users\\Public\\deepa\\Shopping\\Item.doc");
    	try {

			FileInputStream fis=new FileInputStream(ItemFile);
			ObjectInputStream ois=new ObjectInputStream(fis);
			itemLi=(ArrayList)ois.readObject();
			ois.close();fis.close();
			
		} catch (IOException | ClassNotFoundException e) {		

			try {
				/*ItemListDeepa id=new ItemListDeepa("Bluetooth","Easy Access","50% Off",500);
				ItemListDeepa id1=new ItemListDeepa("Mobile","Android","50% Off",15000);
				ItemListDeepa id2=new ItemListDeepa("Laptop","Touch High Speed","50% Off",25000);
				ItemListDeepa id3=new ItemListDeepa("IronBox","Low Power","50% Off",2500);
				ItemListDeepa id4=new ItemListDeepa("Charger","Easy Charge","70% Off",650);

				
				itemLi.add(id);
				itemLi.add(id1);
				itemLi.add(id2);
				itemLi.add(id3);
				itemLi.add(id4);*/
				FileOutputStream fos = new FileOutputStream(ItemFile);
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(itemLi);
				oos.close();fos.close();
				Itembool=true;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    	if(Itembool) {

		try {
			itemLi=new ArrayList();
			FileInputStream fis = new FileInputStream(ItemFile);
			ObjectInputStream ois=new ObjectInputStream(fis);
			itemLi=(ArrayList)ois.readObject();
			ois.close();fis.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
		System.out.println(itemLi);
	
    }
    static public void AdminProcess() {//ItemFile
    	ItemBinFile=new File("C:\\Users\\Public\\deepa\\Shopping\\"+lp.toString().trim()+"_Bin.doc");
    	List<ItemListDeepa> UserProcess=new ArrayList();
    	List<ItemListDeepa> List=new ArrayList();
		ListInterfaceImplent adl=new ListInterfaceImplent();
    	do {
    		System.out.println("Add , Update, View , DeleteItem, DeleteForAll, ViewBin,BinToCart, Quit");
    		switch(scan.next()){
    		case "Add":				
    			adl.AddAdminItem(ItemFile);				
    			  System.out.println("Do You want contine y/n");
    			  if(scan.next().equalsIgnoreCase("y")) {
    				  continue;
    			  }else {
    				  System.out.println("Do You want exit y/n");
    	 				 if(scan.next().equalsIgnoreCase("y")) {
    	 	   				  return;
    	 	   			  }else {
    	   				  break;
    	 	   			  }
    			  }
    		case "Update":				
    			adl.AddUpdateItem(ItemFile,UserF,BinFile,ItemBinFile);				
    			  System.out.println("Do You want contine y/n");
    			  if(scan.next().equalsIgnoreCase("y")) {
    				  continue;
    			  }else {
    				  System.out.println("Do You want exit y/n");
    	 				 if(scan.next().equalsIgnoreCase("y")) {
    	 	   				  return;
    	 	   			  }else {
    	   				  break;
    	 	   			  }
    			  }
    		case "View":
    			try {
					FileInputStream fisIte = new FileInputStream(ItemFile);
					ObjectInputStream oisIte=new ObjectInputStream(fisIte);
					List=(ArrayList)oisIte.readObject();
					oisIte.close();fisIte.close();
					System.out.println(List);
	    			 
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("Item List Is Empty");
					
				}	
    			 System.out.println("Do You want contine y/n");
				 if(scan.next().equalsIgnoreCase("y")) {
	   				  continue;
	   			  		}else {
	   			  			System.out.println("Do You want exit y/n");
	   			  			if(scan.next().equalsIgnoreCase("y")) {
	   			  				return;
	   	 	   			  	}else {
	   	 	   			  		break;
	   	 	   			  	}
	   			  		}
    			
    		case "DeleteItem":
    			adl.TempAdminUserItem(ItemFile,UserF,BinFile,ItemBinFile);
   			 System.out.println("Do You want contine y/n");
    			 if(scan.next().equalsIgnoreCase("y")) {
     				  continue;
     			  		}else {
     			  			System.out.println("Do You want exit y/n");
     			  			if(scan.next().equalsIgnoreCase("y")) {
     			  				return;
     	 	   			  	}else {
     	 	   			  		break;
     	 	   			  	}
     			  		}
    			
    		case "DeleteForAll":
    			adl.TempAdminUserItemAll(ItemFile,UserF,BinFile,ItemBinFile);
   			 System.out.println("Do You want contine y/n");
        			 if(scan.next().equalsIgnoreCase("y")) {
          				  continue;
          			  		}else {
          			  			System.out.println("Do You want exit y/n");
          			  			if(scan.next().equalsIgnoreCase("y")) {
          			  				return;
          	 	   			  	}else {
          	 	   			  		break;
          	 	   			  	}
          			  		}
    		
    			
    		case "ViewBin":
    			try {
					FileInputStream fisIte = new FileInputStream(ItemBinFile);
					ObjectInputStream oisIte=new ObjectInputStream(fisIte);
					List=(ArrayList)oisIte.readObject();
					oisIte.close();fisIte.close();
					System.out.println(List);
	    			 
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("Your BinFile Is Empty");
					
				}	
    			 System.out.println("Do You want contine y/n");
				 if(scan.next().equalsIgnoreCase("y")) {
	   				  continue;
	   			  		}else {
	   			  			System.out.println("Do You want exit y/n");
	   			  			if(scan.next().equalsIgnoreCase("y")) {
	   			  				return;
	   	 	   			  	}else {
	   	 	   			  		break;
	   	 	   			  	}
	   			  		}
    		case "BinToCart":
    			 adl.BinToCart(ItemFile,UserF,BinFile,ItemBinFile);
    			 System.out.println("Do You want contine y/n");
				 if(scan.next().equalsIgnoreCase("y")) {
	   				  continue;
	   			  		}else {
	   			  			System.out.println("Do You want exit y/n");
	   			  			if(scan.next().equalsIgnoreCase("y")) {
	   			  				return;
	   	 	   			  	}else {
	   	 	   			  		break;
	   	 	   			  	}
	   			  		}
    		case "Quit":
    			return;
			 default:
				 return;
    		}
		}while(true);
    	

    }
    static public void UserProcess() {
    	UserF=new File("C:\\Users\\Public\\deepa\\Shopping\\"+lp.toString().trim()+".doc");
    	BinFile=new File("C:\\Users\\Public\\deepa\\Shopping\\"+lp.toString().trim()+"_Bin.doc");

    	List<ItemListDeepa> UserProcess=new ArrayList();
    	List<ItemListDeepa> List=new ArrayList();
		ListInterfaceImplent adl=new ListInterfaceImplent();

    	boolean AddBool=false;

    	do {
    		System.out.println("Add , View , DeleteItem, DeleteForAll, ViewBin,BinToCart, Quit");
    		switch(scan.next()){
    		case "Add":				
    			adl.AddUserItem(ItemFile,UserF);				
    			  System.out.println("Do You want contine y/n");
    			  if(scan.next().equalsIgnoreCase("y")) {
    				  continue;
    			  }else {
    				  System.out.println("Do You want exit y/n");
    	 				 if(scan.next().equalsIgnoreCase("y")) {
    	 	   				  return;
    	 	   			  }else {
    	   				  break;
    	 	   			  }
    			  }
    		case "View":
    			try {
					FileInputStream fisIte = new FileInputStream(UserF);
					ObjectInputStream oisIte=new ObjectInputStream(fisIte);
					List=(ArrayList)oisIte.readObject();
					oisIte.close();fisIte.close();
					System.out.println(List);
	    			 
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("Your Cart Is Empty");
					
				}	
    			 System.out.println("Do You want contine y/n");
				 if(scan.next().equalsIgnoreCase("y")) {
	   				  continue;
	   			  		}else {
	   			  			System.out.println("Do You want exit y/n");
	   			  			if(scan.next().equalsIgnoreCase("y")) {
	   			  				return;
	   	 	   			  	}else {
	   	 	   			  		break;
	   	 	   			  	}
	   			  		}
    			
    		case "DeleteItem":
    			adl.TempUserItem(UserF,BinFile);
   			 System.out.println("Do You want contine y/n");
    			 if(scan.next().equalsIgnoreCase("y")) {
     				  continue;
     			  		}else {
     			  			System.out.println("Do You want exit y/n");
     			  			if(scan.next().equalsIgnoreCase("y")) {
     			  				return;
     	 	   			  	}else {
     	 	   			  		break;
     	 	   			  	}
     			  		}
    			
    		case "DeleteForAll":
    			adl.TempUserItemAll(UserF,BinFile);
   			 System.out.println("Do You want contine y/n");
        			 if(scan.next().equalsIgnoreCase("y")) {
          				  continue;
          			  		}else {
          			  			System.out.println("Do You want exit y/n");
          			  			if(scan.next().equalsIgnoreCase("y")) {
          			  				return;
          	 	   			  	}else {
          	 	   			  		break;
          	 	   			  	}
          			  		}
    		
    			
    		case "ViewBin":
    			try {
					FileInputStream fisIte = new FileInputStream(BinFile);
					ObjectInputStream oisIte=new ObjectInputStream(fisIte);
					List=(ArrayList)oisIte.readObject();
					oisIte.close();fisIte.close();
					System.out.println(List);
	    			 
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("Your BinFile Is Empty");
					
				}	
    			 System.out.println("Do You want contine y/n");
				 if(scan.next().equalsIgnoreCase("y")) {
	   				  continue;
	   			  		}else {
	   			  			System.out.println("Do You want exit y/n");
	   			  			if(scan.next().equalsIgnoreCase("y")) {
	   			  				return;
	   	 	   			  	}else {
	   	 	   			  		break;
	   	 	   			  	}
	   			  		}
    		case "BinToCart":
    			 adl.BinToCart(UserF,BinFile);
    			 System.out.println("Do You want contine y/n");
				 if(scan.next().equalsIgnoreCase("y")) {
	   				  continue;
	   			  		}else {
	   			  			System.out.println("Do You want exit y/n");
	   			  			if(scan.next().equalsIgnoreCase("y")) {
	   			  				return;
	   	 	   			  	}else {
	   	 	   			  		break;
	   	 	   			  	}
	   			  		}
    		case "Quit":
    			return;
			 default:
				 return;
    		}
		}while(true);
    }
   
}
