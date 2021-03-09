package com.yby.run;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.yby.utils.Music;
import com.yby.view.FrameWindow1;
import com.yby.view.GameHome;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class EnterID {
	private Socket socket;

	// IO streams
	private DataOutputStream dout;
	private DataInputStream din;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	protected void sendMessage(String message) {
		if(din == null) {
    		try {
		        // Create a socket to connect to the server
		        socket = new Socket("127.0.0.1", 8000);
		        // Create an input stream to receive data from the server
		        din = new DataInputStream(socket.getInputStream());
		        // Create an output stream to send data to the server
		        dout = new DataOutputStream(socket.getOutputStream());
		       
		    }
		    catch (IOException ex) {
		        //ex.printStackTrace();
		    }
    	}
    	try {
    		// Send the text to the server
    	    dout.writeUTF(message);
    	    
    	}
    	catch (IOException ex) {
    	    System.err.println(ex);
    	}
    	catch (NullPointerException e2) {
    		System.out.println("No connection");
    	}
	}
	public static void main(String[] args) {
		
					EnterID window = new EnterID();
					window.frame.setVisible(true);
				
	}

	/**
	 * Create the application.
	 */
	public EnterID() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblId.setBounds(35, 60, 70, 30);
		frame.getContentPane().add(lblId);
		
		JLabel lblCode = new JLabel("Code:");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblCode.setBounds(35, 113, 70, 30);
		frame.getContentPane().add(lblCode);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		textField.setBounds(115, 60, 261, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblYbygamebox = new JLabel("YBYGAMEBOX");
		lblYbygamebox.setHorizontalAlignment(SwingConstants.CENTER);
		lblYbygamebox.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblYbygamebox.setBounds(10, 10, 416, 40);
		frame.getContentPane().add(lblYbygamebox);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String b = String.valueOf(passwordField.getPassword());
				sendMessage(textField.getText()+"    "+b);
				
				boolean enter = false;
				try {
					enter = din.readBoolean();
					System.out.println(enter);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(enter) {
					
					GameHome window = new GameHome();
					
					frame.dispose();
				}
			}
		});
		btnEnter.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		btnEnter.setBounds(140, 181, 160, 40);
		frame.getContentPane().add(btnEnter);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 115, 261, 30);
		frame.getContentPane().add(passwordField);
	}
	
}
