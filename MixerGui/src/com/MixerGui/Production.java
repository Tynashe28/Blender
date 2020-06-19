package com.MixerGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Production extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Production() {
		setTitle("Production");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_logout = new JButton("Logout");
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Home().home.setVisible(true);
				dispose();
			}
		});
		btn_logout.setBounds(335, 11, 89, 23);
		contentPane.add(btn_logout);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Dashboard().setVisible(true);
				dispose();
			}
		});
		btn_back.setBounds(10, 11, 89, 23);
		contentPane.add(btn_back);
		
		JLabel lblNewLabel = new JLabel("Production");
		lblNewLabel.setBounds(154, 41, 102, 23);
		contentPane.add(lblNewLabel);
		
		JComboBox combo_JuiceType = new JComboBox();
		combo_JuiceType.setModel(new DefaultComboBoxModel(new String[] {"Orange", "CreamSoda", "Peach", "Raspberry"}));
		combo_JuiceType.setBounds(144, 109, 149, 35);
		contentPane.add(combo_JuiceType);
		
		JLabel lblNewLabel_1 = new JLabel("Choose Juice Type");
		lblNewLabel_1.setBounds(10, 109, 124, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton btn_next = new JButton("Next");
		btn_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String juiceType =  (String) combo_JuiceType.getSelectedItem();
				if(juiceType.equals("Orange")) {
					new blendingProcess(juiceType).setVisible(true);
					dispose();
				}else if (juiceType.equals("CreamSoda")) {
					new blendingProcess(juiceType).setVisible(true);
					dispose();
				}else if (juiceType.equals("Peach")) {
					new blendingProcess(juiceType).setVisible(true);
					dispose();
				}else if (juiceType.equals("Raspberry")) {
					new blendingProcess(juiceType).setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Error!!");
				}
				
			}
		});
		btn_next.setBounds(303, 109, 121, 35);
		contentPane.add(btn_next);
		
		JButton btn_currentProcess = new JButton("Show Current Process");
		btn_currentProcess.setBounds(144, 176, 213, 35);
		contentPane.add(btn_currentProcess);
	}
}
