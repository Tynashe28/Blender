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

public class CIP extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CIP() {
		setTitle("C.I.P");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C.I.P ");
		lblNewLabel.setBounds(169, 24, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btn_back = new JButton("<Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Dashboard().setVisible(true);
				dispose();
			}
		});
		btn_back.setBounds(20, 20, 89, 23);
		contentPane.add(btn_back);
		
		JButton btn_logout = new JButton("Logout");
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Home().home.setVisible(true);
				dispose();
			}
		});
		btn_logout.setBounds(323, 20, 89, 23);
		contentPane.add(btn_logout);
	}

}
