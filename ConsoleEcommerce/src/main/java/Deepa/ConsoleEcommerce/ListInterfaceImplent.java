package Deepa.ConsoleEcommerce;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class ListInterfaceImplent implements ListInterFaces{
	Scanner scan=new Scanner(System.in);
	@Override
	public void AddAdminItem(File ItemFile) {
		// TODO Auto-generated method stub
		ItemListDeepa il=new ItemListDeepa();
    	List<ItemListDeepa> List=new ArrayList();
    	boolean Item=false;
    	try {
			FileInputStream fisIte = new FileInputStream(ItemFile);
			ObjectInputStream oisIte=new ObjectInputStream(fisIte);
			List=(ArrayList)oisIte.readObject();
			oisIte.close();fisIte.close();
			Item=true;

		} catch (IOException | ClassNotFoundException e1) {		
			Item=false;
			List=new ArrayList(); 
		}    
		System.out.println("***** Space not Accepted if space need use "+"'"+"."+"'"+" ***** ");

		System.out.println("How Many Number item Added");		

		/*
		 ItemListDeepa id=new ItemListDeepa("Bluetooth","Easy Access","50% Off",500);
				ItemListDeepa id1=new ItemListDeepa("Mobile","Android","50% Off",15000);
				ItemListDeepa id2=new ItemListDeepa("Laptop","Touch High Speed","50% Off",25000);
				ItemListDeepa id3=new ItemListDeepa("IronBox","Low Power","50% Off",2500);
				ItemListDeepa id4=new ItemListDeepa("Charger","Easy Charge","70% Off",650);
		 */
		int n=Integer.parseInt(scan.next());
		for(int i=0;i<n;i++) {
			System.out.println(i);
			il=new ItemListDeepa();
			System.out.println("Enter Item Name");
			il.setListName(scan.next());
			System.out.println("Enter item Details");
			String Details=scan.next();
			Details=Details.replace(".", " ");
			il.setListDesc(Details);
			System.out.println("Enter item offer");
			String Offer=scan.next();
			Offer=Offer.replace(".", " ");
			il.setOffer(Offer);
			System.out.println("Enter Price");
			il.setPrice(Integer.parseInt(scan.next()));
		
			
			List.add(il);
			
		}
		try {
			FileOutputStream fos = new FileOutputStream(ItemFile);
			ObjectOutputStream ois=new ObjectOutputStream(fos);
			ois.writeObject(List);
			System.out.println("Successfully Added.....");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

	}


	@Override
	public void AddUserItem(File ItemFile,File UserF) {
		// TODO Auto-generated method stub
    	List<ItemListDeepa> List=new ArrayList();
    	List<ItemListDeepa> UserProcess=new ArrayList();
    	boolean AddBool=false;
		try {
			FileInputStream fisIte = new FileInputStream(ItemFile);
			ObjectInputStream oisIte=new ObjectInputStream(fisIte);
			List=(ArrayList)oisIte.readObject();
			oisIte.close();fisIte.close();
		} catch (IOException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("List Is Emty");
		}				
		
		try {
			FileInputStream fis=new FileInputStream(UserF);
			ObjectInputStream ois=new ObjectInputStream(fis);
			UserProcess=(ArrayList)ois.readObject();
			ois.close();fis.close();
			AddBool=true;
		} catch (IOException | ClassNotFoundException e) {
			UserProcess=new ArrayList();
			AddBool=true;					
		}
		if(AddBool) {
			if(List.size()!=0) {
				System.out.println("Select One Number");
				for(int i=0;i<List.size();i++) {
					String Data=i+ " "+List.get(i).getListName();
					System.out.println(Data);
				}
			}
		}
		int n=Integer.parseInt(scan.next());
		if(n<List.size()) {
			UserProcess.add(List.get(n));
		}
		try {
			FileOutputStream fos = new FileOutputStream(UserF);
			ObjectOutputStream ois=new ObjectOutputStream(fos);
			ois.writeObject(UserProcess);
			System.out.println("Successfully Added.....");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}

	@Override
	public void TempUserItemAll(File UserF,File BinFile) {
		// TODO Auto-generated method stub

		System.out.println("Do You want To Delete cart or Bin");
		if(scan.next().equalsIgnoreCase("Bin")) {
			List<ItemListDeepa> BinList=new ArrayList();
			boolean checkfile=false;
			try {
				FileInputStream fis = new FileInputStream(BinFile);
				ObjectInputStream oos1=new ObjectInputStream(fis);
				BinList=(ArrayList)oos1.readObject();
				oos1.close();fis.close();

				checkfile=true;
				} catch (IOException | ClassNotFoundException e) {
					checkfile=false;
					BinList=new ArrayList();
				}
			if(checkfile) {
				System.out.println("Are You Sure Delete Permanently y/n");
				if(scan.next().equalsIgnoreCase("y")) {
					try {
						BinList=new ArrayList();
						FileOutputStream fis = new FileOutputStream(BinFile);
						ObjectOutputStream oos1=new ObjectOutputStream(fis);
						oos1.writeObject(BinList);
						checkfile=true;
						oos1.close();fis.close();
						System.out.println("Successfully Deleted.....");

						} catch (IOException e) {
							checkfile=false;
						}
				}

			}else {
				System.out.println("Your Bin Is Empty");
			}
		}else {
			
		
		boolean delbool=false;
		List<ItemListDeepa> List=new ArrayList();
		List<ItemListDeepa> BinList=new ArrayList();
		try {
			FileInputStream fisIte = new FileInputStream(UserF);
			ObjectInputStream oisIte=new ObjectInputStream(fisIte);
			List=(ArrayList)oisIte.readObject();
			oisIte.close();fisIte.close();
			delbool=true;
		} catch (IOException | ClassNotFoundException e1) {
			delbool=false;
		}	

		if(delbool) {
			boolean empty=false;
			boolean checkfile=false;
			if(List.size()!=0) {
			System.out.println("Do You want To Delete Temporary or Permanent");
			if(scan.next().equalsIgnoreCase("Temporary")) {
				try {
				FileInputStream fis = new FileInputStream(BinFile);
				ObjectInputStream oos1=new ObjectInputStream(fis);
				BinList=(ArrayList)oos1.readObject();
				checkfile=true;
				} catch (IOException | ClassNotFoundException e) {
					BinList=new ArrayList();
					checkfile=false;
				}
				
				try {
					FileOutputStream fisIte = new FileOutputStream(BinFile);
					ObjectOutputStream oos=new ObjectOutputStream(fisIte);
					if(checkfile) {
					if(BinList.size()!=0) {
						oos.writeObject(BinList);
					}	
					}
					oos.writeObject(List);
					oos.close();fisIte.close();
					System.out.println("Successfully Deleted But Stored In Bin.....");

					empty=true;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					empty=false;
				}
				if(!empty) {
					try {
					FileOutputStream fisIte = new FileOutputStream(BinFile);
					ObjectOutputStream oos=new ObjectOutputStream(fisIte);
					oos.writeObject(List);
					oos.close();fisIte.close();
					System.out.println("Successfully Deleted But Stored In Bin.....");

					} catch (IOException e) {
						
					}
				}
			
				try {
					List=new ArrayList();
					FileOutputStream fis = new FileOutputStream(UserF);
					ObjectOutputStream oos=new ObjectOutputStream(fis);
					oos.writeObject(List);
					oos.close();fis.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}	else {
				try {
					List=new ArrayList();
					FileOutputStream fis = new FileOutputStream(UserF);
					ObjectOutputStream oos=new ObjectOutputStream(fis);
					oos.writeObject(List);
					oos.close();fis.close();
					System.out.println("Successfully Deleted.....");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
			else {
				System.out.println("Your Cart is Empty.....");
			}
	}else {
		System.out.println("Your Cart is Empty.....");
	}
		}
}
	@Override
	public void BinToCart(File UserF,File BinFile) {
		// TODO Auto-generated method stub
		boolean binBool=false;
		List<ItemListDeepa> List=new ArrayList();
		List<ItemListDeepa> BinList=new ArrayList();
		try {
			FileInputStream fisIte = new FileInputStream(BinFile);
			ObjectInputStream oisIte=new ObjectInputStream(fisIte);
			List=(ArrayList)oisIte.readObject();
			oisIte.close();fisIte.close();
			binBool=true;
		} catch (IOException | ClassNotFoundException e1) {
			binBool=false;
		}	
		try {
			FileInputStream fisIte = new FileInputStream(UserF);
			ObjectInputStream oisIte=new ObjectInputStream(fisIte);
			BinList=(ArrayList)oisIte.readObject();
			oisIte.close();fisIte.close();
		} catch (IOException | ClassNotFoundException e1) {
			BinList=new ArrayList();
		}	
//write
		if(binBool) {
			boolean empty=false;
			boolean checkfile=false;
			if(List.size()!=0) {
				System.out.println("Select One Number");
				for(int i=0;i<List.size();i++) {
					String Data=List.get(i).getListName().toString().trim();
					System.out.println(i+" "+Data);
				}
				int n=Integer.parseInt(scan.next());
				if(n<List.size()) {
					BinList.add(List.get(n));	
					List.remove(n);
				}
				try {
					FileOutputStream fos = new FileOutputStream(UserF);
					ObjectOutputStream ois=new ObjectOutputStream(fos);
					ois.writeObject(BinList);
					ois.close();fos.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				try {
					
					FileOutputStream fos = new FileOutputStream(BinFile);
					ObjectOutputStream ois=new ObjectOutputStream(fos);
					ois.writeObject(List);
					ois.close();fos.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				System.out.println("Bin To Cart moved");

			}
			else {
				System.out.println("Your Bin Cart is Empty.....");
			}
	}else {
		System.out.println("Your Bin Cart is Empty.....");
	}
}



	@Override
	public void TempUserItem(File UserF, File BinFile) {
		// TODO Auto-generated method stub
		System.out.println("Do You want To Delete Cart or Bin");
		if(scan.next().equalsIgnoreCase("Bin")) {
			List<ItemListDeepa> ItemBinList=new ArrayList();
			boolean checkfile=false;
			try {
				FileInputStream fis = new FileInputStream(BinFile);
				ObjectInputStream oos1=new ObjectInputStream(fis);
				ItemBinList=(ArrayList)oos1.readObject();
				oos1.close();fis.close();

				checkfile=true;
				} catch (IOException | ClassNotFoundException e) {
					checkfile=false;
					ItemBinList=new ArrayList();
				}
			if(checkfile) {
				if(ItemBinList.size()!=0) {
					for(int i=0;i<ItemBinList.size();i++) {
						String Data=ItemBinList.get(i).getListName().toString().trim();
						System.out.println(i+" "+Data);
					}
					int n=Integer.parseInt(scan.next());
					if(n<ItemBinList.size()) {
						System.out.println("Are You Sure Delete Permanently y/n");
						if(scan.next().equalsIgnoreCase("y")) {
							try {
								ItemBinList.remove(n);
								FileOutputStream fis = new FileOutputStream(BinFile);
								ObjectOutputStream oos1=new ObjectOutputStream(fis);
								oos1.writeObject(ItemBinList);
								checkfile=true;
								oos1.close();fis.close();
								System.out.println("Successfully Deleted.....");

								} catch (IOException e) {
									checkfile=false;
								}
						}

					}
					
					}
				else {
					System.out.println("No Item In Bin");
				}
				
			}else {
				System.out.println("Your Bin Is Empty");
			}
		}
		else {
		boolean delbool=false;
		List<ItemListDeepa> List=new ArrayList();
		List<ItemListDeepa> BinList=new ArrayList();
		try {
			FileInputStream fisIte = new FileInputStream(UserF);
			ObjectInputStream oisIte=new ObjectInputStream(fisIte);
			List=(ArrayList)oisIte.readObject();
			oisIte.close();fisIte.close();
			delbool=true;
		} catch (IOException | ClassNotFoundException e1) {
			delbool=false;
		}	

		if(delbool) {
			boolean empty=false;
			boolean checkfile=false;
			if(List.size()!=0) {
				System.out.println("Select One Number");
				if(List.size()!=0) {
					for(int i=0;i<List.size();i++) {
						String Data=List.get(i).getListName().toString().trim();
						System.out.println(i+" "+Data);
					}
					int n=Integer.parseInt(scan.next());
					if(n<List.size()) {
						System.out.println("Do You want To Delete Temporary or Permanent");
						if(scan.next().equalsIgnoreCase("Temporary")) {							
							try {
								FileInputStream fis = new FileInputStream(BinFile);
								ObjectInputStream oos1=new ObjectInputStream(fis);
								BinList=(ArrayList)oos1.readObject();
								oos1.close();fis.close();
								checkfile=true;
								} catch (IOException | ClassNotFoundException e) {
									BinList=new ArrayList();
									checkfile=false;
								}							
						
							try {
								
								if(checkfile) {						
									
								if(BinList.size()!=0) {
									BinList.add(List.get(n));	
									List.remove(n);
									FileOutputStream fisIte = new FileOutputStream(BinFile);
									ObjectOutputStream oos=new ObjectOutputStream(fisIte);
									oos.writeObject(BinList);
									oos.close();fisIte.close();
									System.out.println("Successfully Deleted But Move to Bin");
									empty=true;
								}	
								}
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								empty=false;
							}
							if(!empty) {
								BinList.add(List.get(n));	
								List.remove(n);
								try {
								FileOutputStream fisIte = new FileOutputStream(BinFile);
								ObjectOutputStream oos=new ObjectOutputStream(fisIte);
								oos.writeObject(BinList);
								System.out.println("Successfully Deleted But Move to Bin");

								oos.close();fisIte.close();
								} catch (IOException e) {
									
								}
							}
							try {
								FileOutputStream fis = new FileOutputStream(UserF);
								ObjectOutputStream oos=new ObjectOutputStream(fis);
								oos.writeObject(List);
								oos.close();fis.close();

							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
								
						}else {
							try {
								List.remove(n);
								FileOutputStream fis = new FileOutputStream(UserF);
								ObjectOutputStream oos=new ObjectOutputStream(fis);
								oos.writeObject(List);
								oos.close();fis.close();
								System.out.println("Successfully Deleted......");

							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						

					}						
				}
			
			}
			else {
				System.out.println("Your Cart is Empty.....");
			}
	}else {
		System.out.println("Your Cart is Empty.....");
	}
	}
	}


	@Override
	public void TempAdminUserItem(File ItemFile, File UserF, File BinFile1, File ItemBinFile) {
		// TODO Auto-generated method stub
		System.out.println("Do You want To Delete Cart or Bin");

		if(scan.next().equalsIgnoreCase("Bin")) {
			List<ItemListDeepa> ItemBinList=new ArrayList();
			boolean checkfile=false;
			try {
				FileInputStream fis = new FileInputStream(ItemBinFile);
				ObjectInputStream oos1=new ObjectInputStream(fis);
				ItemBinList=(ArrayList)oos1.readObject();
				oos1.close();fis.close();

				checkfile=true;
				} catch (IOException | ClassNotFoundException e) {
					checkfile=false;
					ItemBinList=new ArrayList();
				}
			if(checkfile) {
				if(ItemBinList.size()!=0) {
					for(int i=0;i<ItemBinList.size();i++) {
						String Data=ItemBinList.get(i).getListName().toString().trim();
						System.out.println(i+" "+Data);
					}
					int n=Integer.parseInt(scan.next());
					if(n<ItemBinList.size()) {
						System.out.println("Are You Sure Delete Permanently y/n");
						if(scan.next().equalsIgnoreCase("y")) {
							try {
								ItemBinList.remove(n);
								FileOutputStream fis = new FileOutputStream(ItemBinFile);
								ObjectOutputStream oos1=new ObjectOutputStream(fis);
								oos1.writeObject(ItemBinList);
								checkfile=true;
								System.out.println("Successfully Deleted......");

								oos1.close();fis.close();
								} catch (IOException e) {
									checkfile=false;
								}
						}

					}
					
					}
				else {
					System.out.println("No Item In Bin");
				}
				
			}else {
				System.out.println("Your Bin Is Empty");
			}
		}
		else {
		boolean delbool=false;
		boolean checkfile=false;
		boolean empty=false;
		List<ItemListDeepa> ItemList=new ArrayList();
		List<ItemListDeepa> ItemBinList=new ArrayList();
		try {
			FileInputStream fisIte = new FileInputStream(ItemFile);
			ObjectInputStream oisIte=new ObjectInputStream(fisIte);
			ItemList=(ArrayList)oisIte.readObject();
			oisIte.close();fisIte.close();
			delbool=true;
		} catch (IOException | ClassNotFoundException e1) {
			delbool=false;
		}	
		if(delbool) {
			if(ItemList.size()!=0) {
				System.out.println("Select One Number");
				if(ItemList.size()!=0) {
					for(int i=0;i<ItemList.size();i++) {
						String Data=ItemList.get(i).getListName().toString().trim();
						System.out.println(i+" "+Data);
					}
					int n=Integer.parseInt(scan.next());
					if(n<ItemList.size()) {
						System.out.println("Do You want To Delete Temporary or Permanent");
						if(scan.next().equalsIgnoreCase("Temporary")) {							
							try {
								FileInputStream fis = new FileInputStream(ItemBinFile);
								ObjectInputStream oos1=new ObjectInputStream(fis);
								ItemBinList=(ArrayList)oos1.readObject();
								oos1.close();fis.close();
								checkfile=true;
								} catch (IOException | ClassNotFoundException e) {
									ItemBinList=new ArrayList();
									checkfile=false;
								}							
						
							try {
								
								if(checkfile) {						
									
								if(ItemBinList.size()!=0) {
									ItemBinList.add(ItemList.get(n));	
									ItemBinList.remove(n);
									FileOutputStream fisIte = new FileOutputStream(ItemBinFile);
									ObjectOutputStream oos=new ObjectOutputStream(fisIte);
									oos.writeObject(ItemBinList);
									oos.close();fisIte.close();
									System.out.println("Successfully Deleted but Move To Bin");

									oos.close();fisIte.close();
									empty=true;
								}	
								}
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								empty=false;
							}
							if(!empty) {
								ItemBinList.add(ItemList.get(n));	
								ItemList.remove(n);
								try {
								FileOutputStream fisIte = new FileOutputStream(ItemBinFile);
								ObjectOutputStream oos=new ObjectOutputStream(fisIte);
								oos.writeObject(ItemBinList);
								System.out.println("Successfully Deleted but Move To Bin");

								oos.close();fisIte.close();
								} catch (IOException e) {
									
								}
							}
							try {
								FileOutputStream fis = new FileOutputStream(ItemFile);
								ObjectOutputStream oos=new ObjectOutputStream(fis);
								oos.writeObject(ItemList);
								oos.close();fis.close();

							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
								
						}//temp
						else {
							try {
								ItemList.remove(n);
								FileOutputStream fis = new FileOutputStream(ItemFile);
								ObjectOutputStream oos=new ObjectOutputStream(fis);
								oos.writeObject(ItemList);
								oos.close();fis.close();
								System.out.println("Successfully Deleted...........");

							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						

					}						
				}
			
			}
			
		}else {
			System.out.println("Item List is Empty.....");
		}
	}
		
	}


	@Override
	public void TempAdminUserItemAll(File ItemFile, File UserF, File BinFile, File ItemBinFile) {
		// TODO Auto-generated method stub
		System.out.println("Do You want To Delete cart or Bin");

		if(scan.next().equalsIgnoreCase("Bin")) {
			List<ItemListDeepa> ItemBinList=new ArrayList();
			boolean checkfile=false;
			try {
				FileInputStream fis = new FileInputStream(ItemBinFile);
				ObjectInputStream oos1=new ObjectInputStream(fis);
				ItemBinList=(ArrayList)oos1.readObject();
				oos1.close();fis.close();

				checkfile=true;
				} catch (IOException | ClassNotFoundException e) {
					checkfile=false;
					ItemBinList=new ArrayList();
				}
			if(checkfile) {
				System.out.println("Are You Sure Delete Permanently y/n");
				if(scan.next().equalsIgnoreCase("y")) {
					try {
						ItemBinList=new ArrayList();
						FileOutputStream fis = new FileOutputStream(ItemBinFile);
						ObjectOutputStream oos1=new ObjectOutputStream(fis);
						oos1.writeObject(ItemBinList);
						checkfile=true;
						System.out.println("Successfully Deleted...........");

						oos1.close();fis.close();
						} catch (IOException e) {
							checkfile=false;
						}
				}

			}else {
				System.out.println("Your Bin Is Empty");
			}
		}else {
		boolean delbool=false;
		List<ItemListDeepa> ItemList=new ArrayList();
		List<ItemListDeepa> ItemBinList=new ArrayList();
		try {
			FileInputStream fisIte = new FileInputStream(ItemFile);
			ObjectInputStream oisIte=new ObjectInputStream(fisIte);
			ItemList=(ArrayList)oisIte.readObject();
			oisIte.close();fisIte.close();
			delbool=true;
		} catch (IOException | ClassNotFoundException e1) {
			delbool=false;
		}	

		if(delbool) {
			boolean empty=false;
			boolean checkfile=false;
			if(ItemList.size()!=0) {
			System.out.println("Do You want To Delete Temporary or Permanent");
			if(scan.next().equalsIgnoreCase("Temporary")) {
				try {
				FileInputStream fis = new FileInputStream(ItemBinFile);
				ObjectInputStream oos1=new ObjectInputStream(fis);
				ItemBinList=(ArrayList)oos1.readObject();
				checkfile=true;
				} catch (IOException | ClassNotFoundException e) {
					ItemBinList=new ArrayList();
					checkfile=false;
				}
				
				try {
					FileOutputStream fisIte = new FileOutputStream(ItemBinFile);
					ObjectOutputStream oos=new ObjectOutputStream(fisIte);
					if(checkfile) {
					if(ItemBinList.size()!=0) {
						oos.writeObject(ItemBinList);
					}	
					}
					oos.writeObject(ItemList);
					oos.close();fisIte.close();
					System.out.println("Successfully Deleted but move to Bin");

					empty=true;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					empty=false;
				}
				if(!empty) {
					try {
					FileOutputStream fisIte = new FileOutputStream(ItemBinFile);
					ObjectOutputStream oos=new ObjectOutputStream(fisIte);
					oos.writeObject(ItemList);
					System.out.println("Successfully Deleted but move to Bin");

					oos.close();fisIte.close();
					} catch (IOException e) {
						
					}
				}
			
				try {
					ItemList=new ArrayList();
					FileOutputStream fis = new FileOutputStream(ItemFile);
					ObjectOutputStream oos=new ObjectOutputStream(fis);
					oos.writeObject(ItemList);
					oos.close();fis.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}	else {
				try {
					ItemList=new ArrayList();
					FileOutputStream fis = new FileOutputStream(ItemFile);
					ObjectOutputStream oos=new ObjectOutputStream(fis);
					oos.writeObject(ItemList);
					oos.close();fis.close();
					System.out.println("Successfully Deleted......");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
			else {
				System.out.println("Your Cart is Empty.....");
			}
	}else {
		System.out.println("Your Cart is Empty.....");
	}
	}
	}


	@Override
	public void BinToCart(File ItemFile, File UserF, File BinFile, File ItemBinFile) {
		// TODO Auto-generated method stub
		boolean binBool=false;
		List<ItemListDeepa> ItemList=new ArrayList();
		List<ItemListDeepa> ItemBinList=new ArrayList();
		try {
			FileInputStream fisIte = new FileInputStream(ItemBinFile);
			ObjectInputStream oisIte=new ObjectInputStream(fisIte);
			ItemList=(ArrayList)oisIte.readObject();
			oisIte.close();fisIte.close();
			binBool=true;
		} catch (IOException | ClassNotFoundException e1) {
			binBool=false;
		}	
		try {
			FileInputStream fisIte = new FileInputStream(ItemFile);
			ObjectInputStream oisIte=new ObjectInputStream(fisIte);
			ItemBinList=(ArrayList)oisIte.readObject();
			oisIte.close();fisIte.close();
		} catch (IOException | ClassNotFoundException e1) {
			ItemBinList=new ArrayList();
		}	
//write
		if(binBool) {
			boolean empty=false;
			boolean checkfile=false;
			if(ItemList.size()!=0) {
				System.out.println("Select One Number");
				for(int i=0;i<ItemList.size();i++) {
					String Data=ItemList.get(i).getListName().toString().trim();
					System.out.println(i+" "+Data);
				}
				int n=Integer.parseInt(scan.next());
				if(n<ItemList.size()) {
					ItemBinList.add(ItemList.get(n));	
					ItemList.remove(n);
				}
				try {
					FileOutputStream fos = new FileOutputStream(ItemFile);
					ObjectOutputStream ois=new ObjectOutputStream(fos);
					ois.writeObject(ItemBinList);
					ois.close();fos.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				try {
					
					FileOutputStream fos = new FileOutputStream(ItemBinFile);
					ObjectOutputStream ois=new ObjectOutputStream(fos);
					ois.writeObject(ItemList);
					ois.close();fos.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				System.out.println("Successfully Bin To cart Moved......");

			}
			else {
				System.out.println("Your Bin Cart is Empty.....");
			}
	}else {
		System.out.println("Your Bin Cart is Empty.....");
	}
	}


	@Override
	public void AddUpdateItem(File ItemFile, File UserF, File BinFile, File ItemBinFile) {
		// TODO Auto-generated method stub
		List<ItemListDeepa> ItemList=new ArrayList();
		List<ItemListDeepa> UpdateItemList=new ArrayList();
		ItemListDeepa il=new ItemListDeepa();

		boolean AddBool=false;
		try {
			FileInputStream fisIte = new FileInputStream(ItemFile);
			ObjectInputStream oisIte=new ObjectInputStream(fisIte);
			UpdateItemList=(ArrayList)oisIte.readObject();
			oisIte.close();fisIte.close();
		} catch (IOException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("List Is Emty");
		}				
		
		//if(UpdateItemList.size()!=0) {
			if(UpdateItemList.size()!=0) {
				Boolean bool=false;
				//for(int i=0;i<UpdateItemList.size();i++) {
					//String Data=UpdateItemList.get(i).getListName().toString().trim();

					//System.out.println("i="+Data);
					//int i=Integer.parseInt(scan.next());
				System.out.println("Enter One Number");
				for(int i=0;i<UpdateItemList.size();i++) {
					String Data=UpdateItemList.get(i).getListName().toString().trim();
					System.out.println(i+"= "+Data);

				}
				int i=Integer.parseInt(scan.next());
				System.out.println("which is Update Item 1. Name, 2.Detil, 3.Offer, 4.Price 5.All \n enter One Numbr");	

				int ds=Integer.parseInt(scan.next());

				if(ds==1) {
					System.out.println("The Old Item is ="+UpdateItemList.get(i));
					System.out.println("The Old Item Name is="+UpdateItemList.get(i).getListName()+"Enter The New Item");
					UpdateItemList.get(i).setListName(scan.next());
					bool=true;
				}
				else if(ds==2) {
					System.out.println("The Old Item is ="+UpdateItemList.get(i)+"\n ***** Space not Accepted if space need use \"+\"'\"+\".\"+\"'\"+\" ***** \"");						
					System.out.println("The Old Item Offer is="+UpdateItemList.get(i).getListDesc()+"Enter The Desc Item");
					UpdateItemList.get(i).setListDesc(scan.next());
					bool=true;
				}
				else if(ds==3) {
					System.out.println("The Old Item is ="+UpdateItemList.get(i)+"\n ***** Space not Accepted if space need use \"+\"'\"+\".\"+\"'\"+\" ***** \"");						
					System.out.println("The Old Item Offer is="+UpdateItemList.get(i).getOffer()+"Enter New Offer Item");
					UpdateItemList.get(i).setOffer(scan.next());
					bool=true;
				}
				else if(ds==4) {
					System.out.println("The Old Item is ="+UpdateItemList.get(i));						
					System.out.println("The Old Item Price is="+UpdateItemList.get(i).getPrice()+"Enter New Price Item");
					UpdateItemList.get(i).setPrice(Integer.parseInt(scan.next()));
					bool=true;
				}
				else if(ds==5) {
					System.out.println("The Old Item is ="+UpdateItemList.get(i));
					System.out.println("Enter Item Name");
					UpdateItemList.get(i).setListName(scan.next());
					System.out.println("Enter item Details");
					String Details=scan.next();
					Details=Details.replace(".", " ");
					UpdateItemList.get(i).setListDesc(Details);
					System.out.println("Enter item offer");
					String Offer=scan.next();
					Offer=Offer.replace(".", " ");
					UpdateItemList.get(i).setOffer(Offer);
					System.out.println("Enter Price");
					UpdateItemList.get(i).setPrice(Integer.parseInt(scan.next()));
					bool=true;
				}
				else {
					System.out.println("No Option Available");
					bool=false;

				}
				if(bool) {
				try {
		 						
		 			FileOutputStream fos = new FileOutputStream(ItemFile);
		 			ObjectOutputStream ois=new ObjectOutputStream(fos);
		 			ois.writeObject(UpdateItemList);
		 				ois.close();fos.close();

		 			} catch (IOException e) {
		 						// TODO Auto-generated catch block
		 						//e.printStackTrace();
		 			}


					}
				System.out.println("The Item sucessfully Updated");

				}
					
					//}while(true);
					
					
				//}

			else {
				System.out.println("The Item Cannot Be Available");
			}
			
		
		
	}
	

	
}
