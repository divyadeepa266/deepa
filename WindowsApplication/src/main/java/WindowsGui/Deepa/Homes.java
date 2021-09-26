package WindowsGui.Deepa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Homes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	File ItemFile=new File("C:\\Users\\Public\\deepa\\Shopping2\\Item.doc");
	//"D:\\Course backups\\Java\\Deepa\\jar\\bench.doc
	
	List<ItemListDeepa> itemLi=new ArrayList();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homes frame = new Homes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void ShowList() {
    	boolean Itembool=false;
    	System.out.println("Welcome E Shopping ");
    	try {

			FileInputStream fis=new FileInputStream(ItemFile);
			ObjectInputStream ois=new ObjectInputStream(fis);
			itemLi=(ArrayList)ois.readObject();
			ois.close();fis.close();
			System.out.println("deepa 111 ===="+itemLi);

		} catch (IOException | ClassNotFoundException e) {		
			/*itemLi=new ArrayList();
			ItemListDeepa id=new ItemListDeepa("Bluetooth","Easy Access","50% Off",500);
			ItemListDeepa id1=new ItemListDeepa("Mobile","Android","50% Off",15000);
			ItemListDeepa id2=new ItemListDeepa("Laptop","Touch High Speed","50% Off",25000);
			ItemListDeepa id3=new ItemListDeepa("IronBox","Low Power","50% Off",2500);
			ItemListDeepa id4=new ItemListDeepa("Charger","Easy Charge","70% Off",650);

			
			itemLi.add(id);
			itemLi.add(id1);
			itemLi.add(id2);
			itemLi.add(id3);
			itemLi.add(id4);*/



			try {			
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
			//System.out.println("deepa 333 ===="+itemLi);

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
	//	System.out.println("deepa ===="+itemLi);
	
    }
	public Homes() {
		ShowList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setTitle("Eshopping");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homes.class.getResource("/background.jpg")));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\background.jpg"));
		lblNewLabel.setBounds(92, 11, 235, 88);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login frame = new Login();
				frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(179, 225, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 110, 400, 100);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setBackground(Color.WHITE);
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			//String[] values = new String[] {"deepa", "divya"};
		
			public int getSize() {
				return itemLi.size();
			}
			public Object getElementAt(int index) {
				return itemLi.get(index);
			}
		});
		list.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			 	JOptionPane.showMessageDialog(Homes.this, " Login First");


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
		
	
		
	}
}
