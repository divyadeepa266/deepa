package WindowsGui.Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;

public class Amin extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;
	private JTable table;
	File ItemFile;
	File ItemBinFile;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Amin(final LoginProcess lp) {
		ItemFile=new File("C:\\Users\\Public\\deepa\\Shopping2\\Item.doc");
		ItemBinFile=new File("C:\\Users\\Public\\deepa\\Shopping\\"+lp.toString().trim()+"_Bin.doc");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setTitle("Welcome Admin");
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\background.jpg"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homes.class.getResource("/background.jpg")));
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(380, 0, 55, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Settings");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Logout");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
					Signout();
			     
				
			}
		});
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 75, 22);
		contentPane.add(menuBar_1);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar_1.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Cart");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 Add frame = new Add(lp);
				 frame.setVisible(true); 
				Amin.this.dispose();
				// UpdateShow();
				
			}
		});
	
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Update Item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				View frame = new View(ItemFile,ItemBinFile,"AdminUpdate",lp);
				frame.setVisible(true);
				Amin.this.dispose();
				
			}
		});
		
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Trash");
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				View frame = new View(ItemFile,ItemBinFile,"AdminTrash",lp);
				frame.setVisible(true);
				Amin.this.dispose();
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Delete Cart");
		mnNewMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				View frame = new View(ItemFile,ItemBinFile,"AdminView",lp);
				frame.setVisible(true);	
				Amin.this.dispose();
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(31, 33);
		scrollPane.setSize(372, 185);
		//scrollPane.setBounds(422, 53, -386, 190);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		
		
		TableViewAction();
		
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Item Lists");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel.setBounds(165, 5, 99, 21);
		contentPane.add(lblNewLabel);
		
	}

	public void TableViewAction() {
		
		model=new DefaultTableModel();		
		model.addColumn("Item Name");
		model.addColumn("Offer");
		model.addColumn("Price");

		List<ItemListDeepa> itemLi=new ArrayList();
		try {
			//if(fis.read()!=-1)
			FileInputStream fis=new FileInputStream(ItemFile);
			ObjectInputStream ois=new ObjectInputStream(fis);
			itemLi=(ArrayList)ois.readObject();
				ois.close();
				fis.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
	}
	public void Signout() {
		int op=JOptionPane.showConfirmDialog(this, "Do You Want Logout?", "Logout", JOptionPane.YES_NO_OPTION);
		if (op==JOptionPane.YES_OPTION)
	      {
			this.dispose();
	      }
	}
}
