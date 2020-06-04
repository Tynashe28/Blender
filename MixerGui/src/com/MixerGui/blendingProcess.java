package com.MixerGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.fazecast.jSerialComm.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Color;

public class blendingProcess extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Quantity;
	private JTextField txt_waterFlowRate;
	private JTextField txt_SugarFlowRate;
	private JTextField txt_juiceFlowRate;
	private JTextField txt_concentrateFlowRate;
	private JTextField txt_baseFlowRate;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField txt_ProcessStatus;
	private JTextField txt_ArdStatus;
	private JTextField status;
	private JTextField txt_juiceType;
	SerialPort sPort ;
	JButton btn_start = new JButton("Start Process");
	String port ;
	Double[] flowRate = {0.0,0.0,0.0,0.0,0.0,0.0};
	Double[] volume = {0.0,0.0,0.0,0.0,0.0,0.0};

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public blendingProcess(String juiceType) {
		setTitle("Blending Process");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_Quantity = new JTextField();
		txt_Quantity.setBounds(120, 293, 107, 31);
		contentPane.add(txt_Quantity);
		txt_Quantity.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Quantity");
		lblNewLabel.setBounds(10, 300, 100, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(juiceType+" Production Process");
		lblNewLabel_1.setBounds(207, 21, 217, 46);
		contentPane.add(lblNewLabel_1);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Production().setVisible(true);
				dispose();
			}
		});
		btn_back.setBounds(10, 11, 89, 23);
		contentPane.add(btn_back);
		
		JButton btn_logout = new JButton("Logout");
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Home().home.setVisible(true);
				dispose();
			}
		});
		btn_logout.setBounds(547, 11, 89, 23);
		contentPane.add(btn_logout);
		
		
		JLabel lblNewLabel_2 = new JLabel("Water");
		lblNewLabel_2.setBounds(335, 112, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Sugar Cyrup");
		lblNewLabel_2_1.setBounds(335, 148, 79, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Orange Juice");
		lblNewLabel_2_2.setBounds(335, 188, 79, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Concentrate");
		lblNewLabel_2_3.setBounds(335, 226, 79, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Beverage Base");
		lblNewLabel_2_4.setBounds(335, 272, 89, 14);
		contentPane.add(lblNewLabel_2_4);
		
		txt_waterFlowRate = new JTextField();
		txt_waterFlowRate.setEditable(false);
		txt_waterFlowRate.setBounds(430, 109, 86, 20);
		contentPane.add(txt_waterFlowRate);
		txt_waterFlowRate.setColumns(10);
		
		txt_SugarFlowRate = new JTextField();
		txt_SugarFlowRate.setEditable(false);
		txt_SugarFlowRate.setColumns(10);
		txt_SugarFlowRate.setBounds(430, 145, 86, 20);
		contentPane.add(txt_SugarFlowRate);
		
		txt_juiceFlowRate = new JTextField();
		txt_juiceFlowRate.setEditable(false);
		txt_juiceFlowRate.setColumns(10);
		txt_juiceFlowRate.setBounds(430, 185, 86, 20);
		contentPane.add(txt_juiceFlowRate);
		
		txt_concentrateFlowRate = new JTextField();
		txt_concentrateFlowRate.setEditable(false);
		txt_concentrateFlowRate.setColumns(10);
		txt_concentrateFlowRate.setBounds(430, 223, 86, 20);
		contentPane.add(txt_concentrateFlowRate);
		
		txt_baseFlowRate = new JTextField();
		txt_baseFlowRate.setEditable(false);
		txt_baseFlowRate.setColumns(10);
		txt_baseFlowRate.setBounds(430, 269, 86, 20);
		contentPane.add(txt_baseFlowRate);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(547, 109, 86, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(547, 145, 86, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(547, 185, 86, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(547, 223, 86, 20);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(547, 269, 86, 20);
		contentPane.add(textField_10);
		
		JLabel lblNewLabel_3 = new JLabel("Flow Rate");
		lblNewLabel_3.setBounds(430, 79, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Volume");
		lblNewLabel_3_1.setBounds(550, 79, 86, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("Total Volume");
		lblNewLabel_4.setBounds(335, 323, 89, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setBounds(430, 312, 120, 37);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(335, 386, 100, 17);
		contentPane.add(lblStatus);
		
		txt_ProcessStatus = new JTextField();
		txt_ProcessStatus.setText("Not Connected");
		txt_ProcessStatus.setEditable(false);
		txt_ProcessStatus.setColumns(10);
		txt_ProcessStatus.setBounds(430, 379, 140, 31);
		contentPane.add(txt_ProcessStatus);
		
		JLabel lblArdu = new JLabel("Arduino Status");
		lblArdu.setBounds(10, 138, 100, 17);
		contentPane.add(lblArdu);
		
		txt_ArdStatus = new JTextField();
		txt_ArdStatus.setBackground(Color.RED);
		txt_ArdStatus.setForeground(Color.BLACK);
		txt_ArdStatus.setEditable(false);
		txt_ArdStatus.setColumns(10);
		txt_ArdStatus.setBounds(115, 135, 36, 23);
		contentPane.add(txt_ArdStatus);
		
		
		txt_juiceType = new JTextField();
		txt_juiceType.setText(juiceType);
		txt_juiceType.setEditable(false);
		txt_juiceType.setColumns(10);
		txt_juiceType.setBounds(120, 209, 130, 31);
		contentPane.add(txt_juiceType);
		
		JLabel lblNewLabel_5 = new JLabel("Juice Type");
		lblNewLabel_5.setBounds(10, 226, 89, 14);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboComPorts = new JComboBox();
		comboComPorts.addMouseListener(new MouseAdapter() {
			@SuppressWarnings({ "null", "rawtypes", "unchecked" })
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SerialPort[] ComPortsFullName =  SerialPort.getCommPorts();
				String[] ComPorts = {"","",""};
				for(int i=0; i< ComPortsFullName.length;i++) {
					ComPorts[i] = ComPortsFullName[i].getSystemPortName();
				}
				
				comboComPorts.setModel(new DefaultComboBoxModel(ComPorts));
			}
		});
		comboComPorts.setBounds(10, 166, 79, 23);
		contentPane.add(comboComPorts);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_ProcessStatus.setText("Connecting To Controller");
				if(comboComPorts.getSelectedItem()==null) {
					JOptionPane.showMessageDialog(null, "Select Controller Port Please");
					txt_ProcessStatus.setText("No Controller Selected");
					return;
				}
				
				port = comboComPorts.getSelectedItem().toString();
				sPort = SerialPort.getCommPort(port);
				sPort.setComPortParameters(9600, 8, 1, 0);
				sPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
				if(sPort.openPort()) {
					try {
						sPort.getOutputStream().write("connect".getBytes());
						sPort.getOutputStream().flush();
						Thread.sleep(1000);
						InputStream response = sPort.getInputStream();
						while (response.available()==0) {	
							txt_ProcessStatus.setText("Waiting For Response");
						}
						String meString ="";
						while (response.available()>0) {	
							meString = meString+(char) response.read();
						}
						if(meString.trim().equals("c")) {
							txt_ArdStatus.setBackground(Color.GREEN);
						}
					} catch (IOException | InterruptedException e) {
						JOptionPane.showMessageDialog(null, e);
					}
					
					JOptionPane.showMessageDialog(null, "Successfully Connected to Controller");
					txt_ProcessStatus.setText("Controller Connected");
					btnConnect.setEnabled(false);
			
				}else {
					JOptionPane.showMessageDialog(null, "Failed Connect To Controller");
				}
				
				if(!sPort.closePort()) {
					JOptionPane.showMessageDialog(null, "Failed to close port");
				}
				
								
			}
		});
		btnConnect.setBounds(105, 166, 95, 23);
		contentPane.add(btnConnect);
		
		JButton btn_StopProcess = new JButton("Stop Process");
		btn_StopProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					sPort.getOutputStream().write("stop".getBytes());
					sPort.getOutputStream().flush(); 
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				btn_start.setEnabled(true);
				btn_logout.setEnabled(true);
				btn_back.setEnabled(true);
				
				txt_Quantity.setEditable(true);
				if(!sPort.closePort()) {
					JOptionPane.showMessageDialog(null, "Failed to close port");
				}else {
					txt_ArdStatus.setBackground(Color.RED);
					txt_ProcessStatus.setText("Process Stopped");
					btnConnect.setEnabled(true);
				}
			}
		});
		btn_StopProcess.setBounds(144, 369, 124, 50);
		contentPane.add(btn_StopProcess);
		
		
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txt_ArdStatus.getBackground().getRGB() == -16711936) {
					if(txt_Quantity.getText().equals("")||txt_Quantity.getText().equals(null)) {
						JOptionPane.showMessageDialog(null, "Enter Valid Quantity");
						return;
					}
					txt_Quantity.setEditable(false);
					btn_logout.setEnabled(false);
					btn_back.setEnabled(false);
					btn_start.setEnabled(false);
					sPort = SerialPort.getCommPort(port);
					sPort.setComPortParameters(9600, 8, 1, 0);
					sPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
					
					if(sPort.openPort()) {
						JOptionPane.showMessageDialog(null, "Process Started Successfully");
						txt_ProcessStatus.setText("Process Started");
						showVolumes();
						try {
							
							String juiceType = txt_juiceType.getText();
							sPort.getOutputStream().write("start".getBytes());
							sPort.getOutputStream().flush(); 
							Thread.sleep(1000);
						} catch (IOException | InterruptedException e) {
							JOptionPane.showMessageDialog(null, e);
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Failed To Start Process");
					}
					
				}else if (txt_ArdStatus.getBackground().getRGB() == -65536) {
					JOptionPane.showMessageDialog(null,"Please Connect to Controller");
				}else {
					JOptionPane.showMessageDialog(null,"Error Occured while starting process");
				}
				
				
				
			}
		});
		btn_start.setBounds(10, 369, 124, 50);
		contentPane.add(btn_start);
		
		
	}
	void showVolumes() {
		txt_waterFlowRate.setText(flowRate[0].toString());
		txt_SugarFlowRate.setText(flowRate[1].toString());
		txt_juiceFlowRate.setText(flowRate[2].toString());
		txt_concentrateFlowRate.setText(flowRate[3].toString());
		txt_baseFlowRate.setText(flowRate[4].toString());
	}
	void showFlowRates() {
		
	}
}

