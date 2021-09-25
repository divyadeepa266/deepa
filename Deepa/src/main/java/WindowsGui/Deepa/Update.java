package WindowsGui.Deepa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class Update extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JComboBox comboBox;
	List<ItemListDeepa> UseritemLi=new ArrayList();
	int index;
	LoginProcess lp;

	/**
	 * Launch the application.
	 */
	File ufile;
	File bfile;
	String name="";
	public Update(List<ItemListDeepa> useritemLi,String ind,final File Ufile,File Bfile,String Name,LoginProcess Lp) {
		UseritemLi=useritemLi;
		ufile=Ufile;
		bfile=Bfile;
		name=Name;
		lp=Lp;
		index=Integer.parseInt(ind);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homes.class.getResource("/background.jpg")));
		setTitle("Add Item");
		
		JLabel lblNewLabel = new JLabel("Update Item");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(145, 11, 170, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(29, 67, 69, 26);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField.setBackground(new Color(255, 51, 51));
		textField.setBounds(141, 67, 257, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Desc");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(29, 104, 69, 26);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 51, 51));
		textField_1.setBounds(141, 104, 257, 26);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Price");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_2_1.setBounds(29, 178, 69, 26);
		contentPane.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 51, 51));
		textField_2.setBounds(141, 178, 257, 26);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//save
				
				UpdateAction();
				
			}
		});
		btnNewButton.setBackground(new Color(255, 51, 51));
		btnNewButton.setBounds(121, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//cancel
				CloseAction();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 51, 51));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(239, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Offer");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_2_2.setBounds(29, 141, 69, 26);
		contentPane.add(lblNewLabel_2_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(255, 51, 51));
		textField_3.setBounds(141, 141, 257, 26);
		contentPane.add(textField_3);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 51, 51));
		comboBox.setBounds(139, 34, 259, 22);
		
		comboBox.addItem("Select Option");
		comboBox.addItem("All");
		comboBox.addItem("Name");
		comboBox.addItem("Desc");
		comboBox.addItem("Offer");
		comboBox.addItem("Price");
		comboBox.setSelectedItem("Select Option");
		
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Combo==="+(String) comboBox.getSelectedItem());
				String ComboName=(String) comboBox.getSelectedItem();
				if(ComboName.equals("All")) {//all
					textField.setText(UseritemLi.get(index).getListName());
					textField_1.setText(UseritemLi.get(index).getListDesc());
					textField_2.setText(""+UseritemLi.get(index).getPrice());
					textField_3.setText(UseritemLi.get(index).getOffer());
					textField.setEditable(true);
					textField_1.setEditable(true);
					textField_2.setEditable(true);
					textField_3.setEditable(true);
					textField.setEnabled(true);
					textField_1.setEnabled(true);
					textField_2.setEnabled(true);
					textField_3.setEnabled(true);
					
				}
				else if(ComboName.equals("Name")) {//item
					textField.setText(UseritemLi.get(index).getListName());
					textField_1.setText(UseritemLi.get(index).getListDesc());
					textField_2.setText(""+UseritemLi.get(index).getPrice());
					textField_3.setText(UseritemLi.get(index).getOffer());
					textField.setEditable(true);
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					textField_3.setEditable(false);
					textField.setEnabled(true);
					textField_1.setEnabled(false);
					textField_2.setEnabled(false);
					textField_3.setEnabled(false);
				}
				else if(ComboName.equals("Offer")) {//Desc
					textField.setText(UseritemLi.get(index).getListName());
					textField_1.setText(UseritemLi.get(index).getListDesc());
					textField_2.setText(""+UseritemLi.get(index).getPrice());
					textField_3.setText(UseritemLi.get(index).getOffer());
					textField.setEditable(false);
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					textField_3.setEditable(true);
					textField.setEnabled(false);
					textField_1.setEnabled(false);
					textField_2.setEnabled(false);
					textField_3.setEnabled(true);
				}
				else if(ComboName.equals("Desc")) {//offer
					textField.setText(UseritemLi.get(index).getListName());
					textField_1.setText(UseritemLi.get(index).getListDesc());
					textField_2.setText(""+UseritemLi.get(index).getPrice());
					textField_3.setText(UseritemLi.get(index).getOffer());
					textField.setEditable(false);
					textField_1.setEditable(true);
					textField_2.setEditable(false);
					textField_3.setEditable(false);
					textField.setEnabled(false);
					textField_1.setEnabled(true);
					textField_2.setEnabled(false);
					textField_3.setEnabled(false);
				}
				else if(ComboName.equals("Price")) {//price  Price
					textField.setText(UseritemLi.get(index).getListName());
					textField_1.setText(UseritemLi.get(index).getListDesc());
					textField_2.setText(""+UseritemLi.get(index).getPrice());
					textField_3.setText(UseritemLi.get(index).getOffer());
					textField.setEditable(false);
					textField_1.setEditable(false);
					textField_2.setEditable(true);
					textField_3.setEditable(false);
					textField.setEnabled(false);
					textField_1.setEnabled(false);
					textField_2.setEnabled(true);
					textField_3.setEnabled(false);
				}
				else {
					textField.setEditable(false);
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					textField_3.setEditable(false);
					textField.setEnabled(false);
					textField_1.setEnabled(false);
					textField_2.setEnabled(false);
					textField_3.setEnabled(false);
				}
			}
			
		});
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Select ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(29, 30, 69, 26);
		contentPane.add(lblNewLabel_1_1);
	}
	public void UpdateAction() {
		UseritemLi.get(index).setListName(textField.getText());
		UseritemLi.get(index).setListDesc(textField_1.getText());
		UseritemLi.get(index).setPrice(Integer.parseInt(textField_2.getText().trim()));
		UseritemLi.get(index).setOffer(textField_3.getText());
	
		try {
			FileOutputStream fos = new FileOutputStream(ufile);
			ObjectOutputStream ois=new ObjectOutputStream(fos);
			ois.writeObject(UseritemLi);
			JOptionPane.showMessageDialog(this, "Successfully Updated");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		comboBox.setSelectedItem("Select Option");
	}
	public void CloseAction() {
		this.dispose();
		View frame = new View(ufile,bfile,name,lp);
		frame.setVisible(true);
		
	}
}
