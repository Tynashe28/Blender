package com.MixerGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

public class Dashboard extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setTitle("Dashboard");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DASHBOARD");
		lblNewLabel.setBounds(188, 29, 84, 14);
		contentPane.add(lblNewLabel);
		
		JButton btn_logout = new JButton("Log Out");
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Home().home.setVisible(true);
			}
		});
		btn_logout.setBounds(350, 11, 84, 23);
		contentPane.add(btn_logout);
		
		JButton btnProduction = new JButton("Production");
		btnProduction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Production().setVisible(true);
				dispose();
			}
		});
		btnProduction.setBounds(10, 85, 113, 44);
		contentPane.add(btnProduction);
		
		JButton btnMaintenance = new JButton("Maintenance");
		btnMaintenance.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Maintenance().setVisible(true);
				dispose();				
			}
		});
		btnMaintenance.setBounds(155, 85, 113, 44);
		contentPane.add(btnMaintenance);
		
		JButton btnCIP = new JButton("C.I.P");
		btnCIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CIP().setVisible(true);
				dispose();
			}
		});
		btnCIP.setBounds(296, 85, 113, 44);
		contentPane.add(btnCIP);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnExit.setBounds(0, 20, 89, 23);
		contentPane.add(btnExit);
	}
}
