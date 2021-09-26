package WindowsGui.Deepa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class View extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	List<ItemListDeepa> BinLi=new ArrayList();
	List<ItemListDeepa> UseritemLi=new ArrayList();
	String Name="";
	File ufile;
	File Bfile;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	LoginProcess lp;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public View(File UFile,File bfile,String name,final LoginProcess Lp) {
		setForeground(new Color(123, 104, 238));
		setBackground(new Color(123, 104, 238));
		setResizable(false);
		lp=Lp;
		Name=name;
		ufile=UFile;
		Bfile=bfile;
		
		setTitle(name+" List");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 50, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homes.class.getResource("/background.jpg")));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(31, 33);
		scrollPane.setSize(372, 185);
		//scrollPane.setBounds(422, 53, -386, 190);
		contentPane.add(scrollPane, BorderLayout.CENTER);	
		model=new DefaultTableModel();		
		model.addColumn("Item Name");
		model.addColumn("Offer");
		model.addColumn("Price");
			
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Action(name);	
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int[] Row=table.getSelectedRows();//.replaceAll("[", "").replaceAll("]", "").trim();
				System.out.println("Row="+Row);	
				if(Name.equalsIgnoreCase("View")||Name.equalsIgnoreCase("AdminView")) {
				RemoveRow(Row);
				}
				else if(Name.equalsIgnoreCase("Trash")||Name.equalsIgnoreCase("AdminTrash")) {
					AddtoCart(Row);
				}
				else if(Name.equalsIgnoreCase("Update")||Name.equalsIgnoreCase("AdminUpdate")) {
					Update(Row);
				}
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View.this.dispose();
				if(Name.equalsIgnoreCase("AdminView")||Name.equalsIgnoreCase("AdminUpdate")||
						Name.equalsIgnoreCase("AdminTrash")) {
					Amin frame = new Amin(lp);
					frame.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(153, 50, 204));
		btnNewButton.setBounds(169, 229, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel(Name+" List");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel.setBounds(145, 7, 200, 20);
		contentPane.add(lblNewLabel);
	}
	public void Action(String Name) {
		
		UseritemLi=new ArrayList();
		if(Name.equalsIgnoreCase("View")||Name.equalsIgnoreCase("AdminView")) {
			try {
				//if(fis.read()!=-1)
				FileInputStream fis=new FileInputStream(ufile);
				ObjectInputStream ois=new ObjectInputStream(fis);
				UseritemLi=(ArrayList)ois.readObject();
					ois.close();
					fis.close();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				UseritemLi=new ArrayList();
			} 
			for(int index=0;index<UseritemLi.size();index++)
			{
				Vector obj=new Vector();
				obj.add(UseritemLi.get(index).getListName());
				obj.add(UseritemLi.get(index).getListDesc());
				obj.add(UseritemLi.get(index).getPrice());
				model.addRow(obj);
			}
		}
		else if(Name.equalsIgnoreCase("Trash")||Name.equalsIgnoreCase("AdminTrash")) {
			try {
				//if(fis.read()!=-1)
				FileInputStream fis=new FileInputStream(Bfile);
				ObjectInputStream ois=new ObjectInputStream(fis);
				BinLi=(ArrayList)ois.readObject();
					ois.close();
					fis.close();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				BinLi=new ArrayList();
			} 
			for(int index=0;index<BinLi.size();index++)
			{
				Vector obj=new Vector();
				obj.add(BinLi.get(index).getListName());
				obj.add(BinLi.get(index).getListDesc());
				obj.add(BinLi.get(index).getPrice());
				model.addRow(obj);
			}
		}	else {
			try {
				//if(fis.read()!=-1)
				FileInputStream fis=new FileInputStream(ufile);
				ObjectInputStream ois=new ObjectInputStream(fis);
				UseritemLi=(ArrayList)ois.readObject();
					ois.close();
					fis.close();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				UseritemLi=new ArrayList();
			} 
			for(int index=0;index<UseritemLi.size();index++)
			{
				Vector obj=new Vector();
				obj.add(UseritemLi.get(index).getListName());
				obj.add(UseritemLi.get(index).getListDesc());
				obj.add(UseritemLi.get(index).getPrice());
				model.addRow(obj);
			}
		}
		
	}
	public void RemoveRow(int[] Row) {
		try {
			//if(fis.read()!=-1)
			FileInputStream fis=new FileInputStream(ufile);
			ObjectInputStream ois=new ObjectInputStream(fis);
			UseritemLi=(ArrayList)ois.readObject();
				ois.close();
				fis.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			UseritemLi=new ArrayList();
		} 
		try {
			//if(fis.read()!=-1)
			FileInputStream fis=new FileInputStream(Bfile);
			ObjectInputStream ois=new ObjectInputStream(fis);
			BinLi=(ArrayList)ois.readObject();
				ois.close();
				fis.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			BinLi=new ArrayList();
		} 
		int op=JOptionPane.showConfirmDialog(this, "Do You Want to Remove from the Cart", "Remove", JOptionPane.YES_NO_OPTION);
		if (op==JOptionPane.YES_OPTION)
	      {
			int val=-1;
			for(int i=0;i<Row.length;i++) {
				 val=Row[i];
			}
			BinLi.add(UseritemLi.get(val));
			UseritemLi.remove(val);
			try {
				FileOutputStream fos = new FileOutputStream(Bfile);
				ObjectOutputStream ois=new ObjectOutputStream(fos);
				ois.writeObject(BinLi);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			try {
				FileOutputStream fos = new FileOutputStream(ufile);
				ObjectOutputStream ois=new ObjectOutputStream(fos);
				ois.writeObject(UseritemLi);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			JOptionPane.showConfirmDialog(this, "Successfully Removed..", "Removed", JOptionPane.CLOSED_OPTION);
			model.removeRow(val);

	      }
		else {
			
		}
		
	}
	public void AddtoCart(int[] Row) {
		try {
			//if(fis.read()!=-1)
			FileInputStream fis=new FileInputStream(ufile);
			ObjectInputStream ois=new ObjectInputStream(fis);
			UseritemLi=(ArrayList)ois.readObject();
				ois.close();
				fis.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			UseritemLi=new ArrayList();
		} 
		try {
			//if(fis.read()!=-1)
			FileInputStream fis=new FileInputStream(Bfile);
			ObjectInputStream ois=new ObjectInputStream(fis);
			BinLi=(ArrayList)ois.readObject();
				ois.close();
				fis.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			BinLi=new ArrayList();
		} 
		
		int op=JOptionPane.showConfirmDialog(this, "Do You Want to Restore from the Cart", "Restore", JOptionPane.YES_NO_OPTION);
		if (op==JOptionPane.YES_OPTION)
	      {
			System.out.println("Row.length="+Row.length);
			int val=-1;
			for(int i=0;i<Row.length;i++) {
				 val=Row[i];
			}
			UseritemLi.add(BinLi.get(val));
			BinLi.remove(val);
			try {
				FileOutputStream fos = new FileOutputStream(ufile);
				ObjectOutputStream ois=new ObjectOutputStream(fos);
				ois.writeObject(UseritemLi);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			try {
				FileOutputStream fos = new FileOutputStream(Bfile);
				ObjectOutputStream ois=new ObjectOutputStream(fos);
				ois.writeObject(BinLi);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			JOptionPane.showConfirmDialog(this, "Successfully Restore..", "Restore", JOptionPane.CLOSED_OPTION);
			//model.fireTableRowsUpdated(0, table.getRowCount());
			model.removeRow(val);
		
	      }
		else {
			int opt=JOptionPane.showConfirmDialog(this, "Do You Want to Permanent Delete", "Delete", JOptionPane.YES_NO_OPTION);
			if (opt==JOptionPane.YES_OPTION)
		      {
				int val=-1;
				for(int i=0;i<Row.length;i++) {
					 val=Row[i];
				}
				BinLi.remove(val);
				try {
					FileOutputStream fos = new FileOutputStream(Bfile);
					ObjectOutputStream ois=new ObjectOutputStream(fos);
					ois.writeObject(BinLi);
					JOptionPane.showConfirmDialog(this, "Successfully Deleted", "Deleted", JOptionPane.CLOSED_OPTION);
					model.removeRow(val);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				
		      }
			else {
				
			}
		}
		
	}
	public void Update(int[] Row) {
		try {
			//if(fis.read()!=-1)
			FileInputStream fis=new FileInputStream(ufile);
			ObjectInputStream ois=new ObjectInputStream(fis);
			UseritemLi=(ArrayList)ois.readObject();
				ois.close();
				fis.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			UseritemLi=new ArrayList();
		} 
		
		int op=JOptionPane.showConfirmDialog(this, "Do You Want to Update from the Cart", "Update", JOptionPane.YES_NO_OPTION);
		if (op==JOptionPane.YES_OPTION)
	      {
			int val=-1;
			for(int i=0;i<Row.length;i++) {
				 val=Row[i];
			}
			Update frame = new Update(UseritemLi,""+val,ufile,Bfile,Name,lp);//File UFile,File bfile,String name,final LoginProcess lp
			frame.setVisible(true);
			View.this.dispose();
			//UseritemLi.add(BinLi.get(val));
			
			//model.fireTableRowsUpdated(0, table.getRowCount());
			//model.removeRow(val);
		
	      }
		else {
		}
		
	}
	
	

}
