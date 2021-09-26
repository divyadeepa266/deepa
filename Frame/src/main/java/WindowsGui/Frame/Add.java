package WindowsGui.Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Add(final LoginProcess lp) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("Add Item");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homes.class.getResource("/background.jpg")));

		JLabel lblNewLabel = new JLabel("Add Item");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(144, 24, 107, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(32, 55, 69, 26);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField.setBackground(new Color(255, 51, 51));
		textField.setBounds(144, 55, 257, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Desc");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(32, 92, 69, 26);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 51, 51));
		textField_1.setBounds(144, 92, 257, 26);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Price");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_2_1.setBounds(32, 166, 69, 26);
		contentPane.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 51, 51));
		textField_2.setBounds(144, 166, 257, 26);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {//save ac
			public void actionPerformed(ActionEvent e) {//save
				
				SaveAction();
				
			}
		});
		btnNewButton.setBackground(new Color(255, 51, 51));
		btnNewButton.setBounds(121, 227, 89, 23);
		contentPane.add(btnNewButton);
		System.out.println("");
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//cancel
				CloseAction();
				Amin frame = new Amin(lp);
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 51, 51));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(239, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Offer");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_2_2.setBounds(32, 129, 69, 26);
		contentPane.add(lblNewLabel_2_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(255, 51, 51));
		textField_3.setBounds(144, 129, 257, 26);
		contentPane.add(textField_3);
	}
	public void SaveAction() {
		String Name=textField.getText();
		String Desc=textField_1.getText();
		String Offer=textField_3.getText();
		String Price=textField_2.getText();
		if(Name.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter Item Name");
			return;
		}
		if(Desc.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter Item Desc");
			return;
		}
		if(Offer.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter Item Offer");
			return;
		}
		if(Price.equals("")) {
			JOptionPane.showMessageDialog(this, "Enter Item Price");
			return;
		}
		int price=-1;
		try {
			price=Integer.parseInt(textField_2.getText());
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(this, "Price value must be integer value");
			return;
		}
		File ItemFile=new File("C:\\Users\\Public\\deepa\\Shopping2\\Item.doc");
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
		
		il=new ItemListDeepa();
		
		il.setListName(Name);
		il.setListDesc(Desc);					
		il.setOffer(Offer);
		il.setPrice(price);				
			
		List.add(il);
			
		
		try {
			FileOutputStream fos = new FileOutputStream(ItemFile);
			ObjectOutputStream ois=new ObjectOutputStream(fos);
			ois.writeObject(List);


		} catch (IOException ex) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		JOptionPane.showConfirmDialog(this, "Successfully Added", "Added", JOptionPane.CLOSED_OPTION);
		textField.setText("");
		textField_1.setText("");
		textField_3.setText("");
		textField_2.setText(null);

	}
	public void CloseAction() {
		this.dispose();
	}
}
