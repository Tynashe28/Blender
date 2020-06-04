package com.MixerGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	public JFrame home;
	public JPasswordField txt_password;
	private JTextField txt_username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.home.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		home = new JFrame();
		home.setTitle("My App");
		home.setResizable(false);
		home.setBounds(100, 100, 526, 469);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("welcome to bla bla bla");
		lblNewLabel.setBounds(183, 62, 136, 20);
		home.getContentPane().add(lblNewLabel);
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setBounds(119, 151, 89, 14);
		home.getContentPane().add(lbl_username);
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setBounds(119, 198, 89, 14);
		home.getContentPane().add(lbl_password);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(252, 190, 147, 20);
		home.getContentPane().add(txt_password);
		
		txt_username = new JTextField();
		txt_username.setBounds(252, 148, 147, 20);
		home.getContentPane().add(txt_username);
		txt_username.setColumns(10);
		
		JButton btn_login = new JButton("Login");
		btn_login.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				String username = txt_username.getText();
				String password = txt_password.getText();
				if(username.equals("") && password.equals("")) {
					JOptionPane.showMessageDialog(null, "correct password");
					home.dispose();
					Dashboard dashboard = new Dashboard();
					dashboard.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "login failed");
				}
				
			}
		});
		btn_login.setBounds(119, 253, 280, 23);
		home.getContentPane().add(btn_login);
		
		JButton btn_forgotPassword = new JButton("Forgot Password");
		btn_forgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btn_forgotPassword.setBounds(119, 299, 136, 23);
		home.getContentPane().add(btn_forgotPassword);
	}
}
