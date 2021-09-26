package WindowsGui.Frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Button;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	JLabel lblNewLabel;
	JTextField userText;
	JTextField passText;
	JButton btnSubmit;
	JButton btnRegister;
	JButton btnSave;
	JButton btnClose;
	JButton btnHide;
	JButton btnShow;
	public Login() {
		setResizable(false);
		setTitle("Welcome Login");
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\background.jpg"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homes.class.getResource("/background.jpg")));

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		//contentPane.setToolTipText("Welcome Login ");
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("Welocome Login ");
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(109, 22, 202, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 94, 108, 30);
		contentPane.add(lblNewLabel_1);
		
		userText = new JTextField();
		userText.setBackground(Color.WHITE);
		userText.setForeground(SystemColor.desktop);
		userText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		userText.setColumns(10);
		userText.setBounds(109, 97, 219, 23);
		contentPane.add(userText);
		
	
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 169, 108, 30);
		contentPane.add(lblNewLabel_2);
		
		passText = new JTextField();
		passText.setForeground(SystemColor.desktop);
		passText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passText.setVisible(false);
		passText.setColumns(10);
		passText.setBounds(109, 172, 219, 23);
		contentPane.add(passText);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passwordField.setForeground(SystemColor.desktop);
		passwordField.setBounds(114, 172, 219, 23);
		contentPane.add(passwordField);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSubmit.setBackground(SystemColor.desktop);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName=userText.getText();
				String pass="";
				if(passwordField.isVisible()) {
					pass=passwordField.getText();
				}else {
					pass=passText.getText();
				}
				if(UserName.equals("")) {
					JOptionPane.showMessageDialog(Login.this, "User Name Filed is Empty");
					return;
				}
				if(pass.equals("")) {
					JOptionPane.showMessageDialog(Login.this, "Password Filed is Empty");
					return;
				}
				LoginAccess(UserName,pass);
			}
		});
		btnSubmit.setBounds(52, 237, 108, 23);
		contentPane.add(btnSubmit);
		
		btnRegister= new JButton("New Register");
		btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRegister.setBackground(SystemColor.desktop);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setBounds(183, 237, 147, 23);
		contentPane.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userText.setText("");
				passText.setText("");
				passwordField.setText("");
				btnRegister.setVisible(false);
				btnSubmit.setVisible(false);
				btnSave.setVisible(true);
				btnHide.setVisible(false);
				lblNewLabel.setText("New Registration");
				contentPane.setBackground(new Color(34, 139, 34));
				btnShow.setBackground(new Color(34, 139, 34));	
				btnHide.setBackground(new Color(34, 139, 34));	
				btnSave.setBackground(new Color(34, 139, 34));	
				passText.setForeground(new Color(34, 139, 34));
				passwordField.setForeground(new Color(34, 139, 34));
				userText.setForeground(new Color(34, 139, 34));
				setTitle("New Registration");

			}
		});

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.setBackground(SystemColor.desktop);
		btnSave.setForeground(Color.WHITE);
		btnSave.setVisible(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName=userText.getText();
				String pass="";
				if(passwordField.isVisible()) {
					pass=passwordField.getText();
				}else {
					pass=passText.getText();
				}
				if(UserName.equals("")) {
					JOptionPane.showMessageDialog(Login.this, "User Name Filed is Empty");
					return;
				}
				if(pass.equals("")) {
					JOptionPane.showMessageDialog(Login.this, "Password Filed is Empty");
					return;
				}
				LoginProcess lp=new LoginProcess();
		    	lp.setUName(UserName);
				lp.setUPass(pass);
				NewRegister(UserName,pass);
				
				
			}
		});
		btnSave.setBounds(160, 237, 108, 23);
		contentPane.add(btnSave);
		
		
		btnShow= new JButton("Show");
		btnShow.setBackground(SystemColor.desktop);	
		btnShow.setForeground(Color.WHITE);

		btnShow.setBounds(339, 173, 67, 22);
		contentPane.add(btnShow);
		btnHide = new JButton("Hide");
		btnHide.setBackground(SystemColor.desktop);
		btnHide.setForeground(Color.WHITE);

		btnHide.setBounds(339, 173, 67, 22);
		btnHide.setVisible(false);
		contentPane.add(btnHide);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passText.setVisible(true);
				passwordField.setVisible(false);
				passText.setText(passwordField.getText());
				btnHide.setVisible(true);
				btnShow.setVisible(false);
			}
		});
		
		
		
		btnHide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passText.setVisible(false);
				passwordField.setVisible(true);
				passwordField.setText(passText.getText());

				btnHide.setVisible(false);
				btnShow.setVisible(true);
			}
		});
	}
	List<LoginProcess> LogiLi=new ArrayList();
	File LogiFile=new File("C:\\Users\\Public\\deepa\\Shopping2\\Login.doc");
	public void NewRegister(String Name,String Pass) {
		LoginProcess lp=new LoginProcess();
    	lp.setUName(Name);
		lp.setUPass(Pass);
		LogiLi=new ArrayList();
		try {
			FileInputStream fis = new FileInputStream(LogiFile);
			ObjectInputStream ois=new ObjectInputStream(fis);
			LogiLi=(ArrayList)ois.readObject();
			ois.close();fis.close();
			LogiLi.add(lp);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogiLi.add(lp);
		}
		
		try {
			FileOutputStream fos2 = new FileOutputStream(LogiFile);
			ObjectOutputStream oos2=new ObjectOutputStream(fos2);
			oos2.writeObject(LogiLi);
			System.out.println("Sucess Register ");
			oos2.close();fos2.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JOptionPane.showConfirmDialog(this, "Successfully Register..", "Login", JOptionPane.CLOSED_OPTION);
		int op=JOptionPane.showConfirmDialog(this, "Do You Want to Login?", "Login", JOptionPane.YES_NO_CANCEL_OPTION);
		
		if (op==JOptionPane.YES_OPTION)
	      {
			

				if(lp.getUName().equalsIgnoreCase("Admin")&& lp.getUPass().equalsIgnoreCase("Admin")) {
					System.out.println("AdminProcess");
					AdminProcess(lp);
				}else {
					System.out.println("UserProcess");
					UserProcess(lp);
				}
			
	      }
		else if(op==JOptionPane.NO_OPTION){
			lblNewLabel.setText("New Registration");
			userText.setText("");
			passText.setText("");
			passwordField.setText("");
			passwordField.setVisible(true);
			passText.setVisible(false);
			btnRegister.setVisible(true);
			btnSubmit.setVisible(true);
			btnSave.setVisible(false);
			btnHide.setVisible(false);
			btnShow.setVisible(true);
			btnShow.setBackground(SystemColor.desktop);
			btnHide.setBackground(SystemColor.desktop);
			contentPane.setBackground(SystemColor.desktop);
		}else {
	    	 Signout();     
	    	  
	      }
		
		
	}
	public void LoginAccess(String Name,String Pass) {
    	
    	LoginProcess lp=new LoginProcess();
    	lp.setUName(Name);
		lp.setUPass(Pass);
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
				JOptionPane.showMessageDialog(this, "Invalid Login User Name and Password \n Press New Register button after Login");
				System.out.println("New Register ");
			
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("New Register");
			LogiLi=new ArrayList();			
    		LogiLi.add(lp);
			try {
				FileOutputStream fos = new FileOutputStream(LogiFile);
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(LogiLi);
				oos.close();fos.close();
				loginbool=true;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(loginbool) {
			if(lp.getUName().equalsIgnoreCase("Admin")&& lp.getUPass().equalsIgnoreCase("Admin")) {
				System.out.println("AdminProcess");
				AdminProcess(lp);
			}else {
				System.out.println("UserProcess");
				UserProcess(lp);
			}
		}
	}
	public void UserProcess(LoginProcess lp) {
		User frame = new User(lp);
		frame.setVisible(true);
		//if(frame.bool) {
			Signout();
		//}
		/*if(frame.Resetbool) {
			userText.setText("");
			passText.setText("");
			passwordField.setText("");
			passText.setVisible(false);
			btnRegister.setVisible(true);
			btnSubmit.setVisible(true);
			btnSave.setVisible(false);
			btnHide.setVisible(false);
			btnShow.setVisible(true);
		}*/
		
	
		
	}
	
	public void AdminProcess(LoginProcess lp) {
		Amin frame = new Amin(lp);
		frame.setVisible(true);
		Signout();
	}
	public void Signout() {
		 Login.this.dispose();
	}
}
