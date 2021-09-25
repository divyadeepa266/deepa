package WindowsGui.Deepa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class User extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	public boolean bool=false;
	public boolean Resetbool=false;

	/**
	 * Launch the application.
	/**
	 * Create the frame.
	 */
	File ItemFile=new File("C:\\Users\\Public\\deepa\\Shopping2\\Item.doc");
	File UserF;
	File ItemBinFile;


	List<ItemListDeepa> itemLi=new ArrayList();
	List<ItemListDeepa> UseritemLi=new ArrayList();
	public User(final LoginProcess lp) {
		UserF=new File("C:\\Users\\Public\\deepa\\Shopping2\\"+lp.toString().trim()+".doc");
		ItemBinFile=new File("C:\\Users\\Public\\deepa\\Shopping2\\"+lp.toString().trim()+"_Bin.doc");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Welcome "+lp.getUName());
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\background.jpg"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homes.class.getResource("/background.jpg")));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);		
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 75, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu(lp.getUName());
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCart = new JMenuItem("View Cart");	
		mnNewMenu.add(mntmCart);

		mntmCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				View frame = new View(UserF,ItemBinFile,"View",lp);
				frame.setVisible(true);
			}
		});
		
	
		JMenuItem mntmTrash = new JMenuItem("Trash");
		mnNewMenu.add(mntmTrash);
		
		mntmTrash.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("clicked");
				View frame = new View(UserF,ItemBinFile,"Trash",lp);
				frame.setVisible(true);
			}
		});
		
		/*JMenuItem mntmRestore = new JMenuItem("Re-Store");
		mnNewMenu.add(mntmRestore);
		
		mntmRestore.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("clicked");
				View frame = new View(UserF,ItemBinFile,"Re-Store");
				frame.setVisible(true);
			}
		});*/
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(370, 0, 55, 22);
		contentPane.add(menuBar_1);
		
		JMenu mnNewMenu_1 = new JMenu("Settings");
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Log Out");
		mnNewMenu_1.add(mntmNewMenuItem);
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
					Signout();
			     
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(31, 33);
		scrollPane.setSize(372, 185);
		//scrollPane.setBounds(422, 53, -386, 190);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		model=new DefaultTableModel();		
		model.addColumn("Item Name");
		model.addColumn("Offer");
		model.addColumn("Price");
		
		
		try {
			//if(fis.read()!=-1)
			FileInputStream fis=new FileInputStream(ItemFile);
			ObjectInputStream ois=new ObjectInputStream(fis);
			itemLi=(ArrayList)ois.readObject();
				ois.close();
				fis.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		for(int index=0;index<itemLi.size();index++)
		{
			Vector obj=new Vector();
			obj.add(itemLi.get(index).getListName());
			obj.add(itemLi.get(index).getListDesc());
			obj.add(itemLi.get(index).getPrice());
			model.addRow(obj);
		}
		
		try {
			FileInputStream fis=new FileInputStream(UserF);
			ObjectInputStream ois=new ObjectInputStream(fis);
			UseritemLi=(ArrayList)ois.readObject();
			ois.close();fis.close();

		} catch (IOException | ClassNotFoundException e) {
			UseritemLi=new ArrayList();
		}
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int[] Row=table.getSelectedRows();//.replaceAll("[", "").replaceAll("]", "").trim();
				System.out.println("Row="+Row);	
				AddAction(Row);
				
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
		
		JLabel lblNewLabel = new JLabel("Item Lists");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel.setBounds(170, 5, 102, 21);
		contentPane.add(lblNewLabel);
		
	/*	JButton btnNewButton = new JButton("Close");
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resetbool=true;
				Signout();
				}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(170, 229, 89, 23);
		contentPane.add(btnNewButton);*/
		
	}
	public void AddAction(int[] Row) {
		int op=JOptionPane.showConfirmDialog(this, "Do You Want Add To Cart?", "Add", JOptionPane.YES_NO_OPTION);
		if (op==JOptionPane.YES_OPTION)
	      {
			int val=-1;
			for(int i=0;i<Row.length;i++) {
				 val=Row[i];
			}
			UseritemLi.add(itemLi.get(val));
			try {
				FileOutputStream fos = new FileOutputStream(UserF);
				ObjectOutputStream ois=new ObjectOutputStream(fos);
				ois.writeObject(UseritemLi);
				JOptionPane.showConfirmDialog(this, "Successfully Added..", "Added", JOptionPane.CLOSED_OPTION);


			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
	      }
		else {
			
		}
		
	}
	public void Signout() {
		int op=JOptionPane.showConfirmDialog(this, "Do You Want Logout?", "Logout", JOptionPane.YES_NO_OPTION);
		if (op==JOptionPane.YES_OPTION)
	      {
			User.this.dispose();
	      }
	}
}
