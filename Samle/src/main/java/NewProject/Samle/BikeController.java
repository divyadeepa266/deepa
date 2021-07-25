package NewProject.Samle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BikeController implements BikeInterface{
	
	
	File file;
	FileInputStream fis;//=new FileInputStream(file);// read file
	FileOutputStream fos;//wrute file
	ObjectInputStream ois;
	ObjectOutputStream oos;	
	List<BikeInformation> li=new ArrayList<BikeInformation>();
	
	BikeController(){
		file=new File("BikeInFfo");
	}
	@Override
	public List<BikeInformation> CreateDetails(BikeInformation bi) {
		// TODO Auto-generated method stub
		li.add(bi);
		try {
			fis=new FileInputStream(file);
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(li);
			fos.close();oos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block	
				e.printStackTrace();	
		}
		
		return li;
	}

	@Override
	public List<BikeInformation> getBikeAll() {
		// TODO Auto-generated method stub
		//li.add(bi);
		List<BikeInformation> obj=new ArrayList<BikeInformation>();
		try {
			
			fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			try {
				li = (List<BikeInformation>)ois.readObject();
				fis.close();ois.close();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public String SaveBikeDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBikeDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBikeDetailsfromBike(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBikeDetailsfromHandler(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBikeFromName(String Name, int Number) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
