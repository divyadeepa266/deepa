package BikeProject.Bike;

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
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import BikeProject.BikeInformation.BikeDetailsInterface;

public class Bike implements BikeDetailsInterface{
	
	File f;
	File login;
	FileOutputStream fos;
	ObjectOutputStream oos;
	FileInputStream fis;
	ObjectInputStream ois;
	DeflaterOutputStream dos;
	InflaterInputStream ios;
	boolean Authorizebool=false;	
	List<LoginInfo> li=new ArrayList();		
	List<BikeInformation> lis=new ArrayList<BikeInformation>();
	List<BikeInformation> bin=new ArrayList<BikeInformation>();
	Bike(String User,String Pass){	
		/*try {
			login.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		login=new File("C:\\Users\\dell\\Desktop\\"+"Login1.Docx");		
    	LoginInfo sin2=new LoginInfo("dee","dee");
		li.add(sin2);
		/*try {
			fos=new FileOutputStream(login);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			oos=new ObjectOutputStream(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			oos.writeObject(li);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		try {
			fis=new FileInputStream(login);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ois=new ObjectInputStream(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			li=(List<LoginInfo>) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(LoginInfo l:li) {
			if(l.getUserName().equalsIgnoreCase(User)&& l.getPassword().equalsIgnoreCase(Pass)) {
				Authorizebool=true;
				f=new File("C:\\Users\\dell\\Desktop\\"+User+".Docx");

			}
		}
		if(!Authorizebool) {
			login=new File("C:\\Users\\dell\\Desktop\\"+"Login1.Docx");
			
			System.out.println("create Login y/n?");
			Scanner Aut=new Scanner(System.in);
			String Authorized=Aut.nextLine();	
			if(Authorized.equalsIgnoreCase("y")) {
				System.out.println("Enter Login Name");
				Scanner u=new Scanner(System.in);
				String us=u.nextLine();					
				System.out.println("Enter Login Password");
				Scanner p=new Scanner(System.in);
				String pd=p.nextLine();
				LoginInfo sin=new LoginInfo(us,pd);
				li.add(sin);
				try {
					fos=new FileOutputStream(login);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					oos=new ObjectOutputStream(fos);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					oos.writeObject(li);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				f=new File("C:\\Users\\dell\\Desktop\\"+us.trim()+".Docx");
				Authorizebool=true;
			}
			else {
				Authorizebool=false;
			}
		
			
		}
		
		
	}
	public boolean isAuthorizebool() {
		return Authorizebool;
	}

	public void setAuthorizebool(boolean authorizebool) {
		Authorizebool = authorizebool;
	}



	@Override
	public List<BikeInformation> SaveBike(BikeInformation binfor) {
		lis=getbiBikeAll();
		if(!Authorizebool) {
			return new ArrayList();
		}
		lis.add((BikeInformation) binfor);
		try {
			fos=new FileOutputStream(f);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			oos=new ObjectOutputStream(fos);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			oos.writeObject(lis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos.close();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lis;
	}

	@Override
	public List<BikeInformation> getbiBikeAll() {
		// TODO Auto-generated method stub
		if(!Authorizebool) {
			return new ArrayList();
		}
		List<BikeInformation>li=new ArrayList();
		try {
		fis=new FileInputStream(f);
		ois=new ObjectInputStream(fis);
		
		li=(List<BikeInformation>) ois.readObject();
		fis.close();ois.close();

		} catch (FileNotFoundException e) {
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}
	boolean bool=false;
	boolean Delbool=false;

	@Override
	public List<BikeInformation> getBikeName(String Name) {
		// TODO Auto-generated method stub
		if(!Authorizebool) {
			return new ArrayList();
		}
		List<BikeInformation> lis=getbiBikeAll();
		List<BikeInformation> li=new ArrayList();
		for(BikeInformation bi:lis) {
			if(bi.getBikeName().equalsIgnoreCase(Name)) {
				li.add(bi);
				bool=true;
			}
			
		}
		return li;
	}
	@Override
	public List<BikeInformation> deleteBikeName(String Name) {
		// TODO Auto-generated method stub
		if(!Authorizebool) {
			return new ArrayList();
		}
		List<BikeInformation> lis=getbiBikeAll();
		List<BikeInformation> temp=new ArrayList();
		for(BikeInformation bi:lis) {
			if(bi.getBikeName().equalsIgnoreCase(Name)) {
				Delbool=true;
				bin.add(bi);				
			}else {
				
				temp.add(bi);

			}
		}
		try {
			fos=new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			oos=new ObjectOutputStream(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			oos.writeObject(temp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	boolean Restorebool=false;
	public List<BikeInformation> restore() {
		if(!Authorizebool) {
			return new ArrayList();
		}
		List<BikeInformation> li=new ArrayList();
		List<BikeInformation> olis=getbiBikeAll();
		boolean bool=false;
		for(BikeInformation b:bin) {
		
			System.out.println("Do you want to restore? y or n?");
			Scanner ReS=new Scanner(System.in);
			String value=ReS.nextLine();
			if(value.equalsIgnoreCase("y")) {
				bool=true;
				olis.add(b);
				Restorebool=true;

				System.out.println("Successfully restored....");

			}
			
		}
		if(bool) {
			System.out.print("Do you want to see files y or n? ");
			Scanner ReS=new Scanner(System.in);
			String value=ReS.nextLine();
			if(value.equalsIgnoreCase("y")) {
				try {
					fos=new FileOutputStream(f);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					oos=new ObjectOutputStream(fos);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					oos.writeObject(olis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fos.close();
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Restorebool=true;
			}
			else {
				Restorebool=false;
			}
		}
		else {
			System.out.println("No more data available in restored....");

			Restorebool=false;
		}
		return li;
		
		
	}


	@Override
	public List<BikeInformation> deleteBikeAll() {
		// TODO Auto-generated method stub
		List<BikeInformation> lis=getbiBikeAll();

		return null;
	}

}
