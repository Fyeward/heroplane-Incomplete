package com.yby.run;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.SwingConstants;



import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;

public class ServerGui {
	public static Account account;
	private static Box  box = Box.getBank();
	private static List<Account> accounts;
	private JFrame frame;
	private Server server;
	//private player
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		File file = new File("playerbox.txt");
		try {
			  if(!file.exists()) {
			    	System.out.println("Cannont find the file \"playerbox.txt\"");
			    }
			    else {
			    	BufferedReader in = new BufferedReader(new FileReader(file));
			    	String[] split = new String[2];
			    	int index = 0;
			    	String str;
					while(true) {
						str = in.readLine();
						if(str==null) break;
						split = str.split("\\s+");
						
						box.addAccount(split[0], split[1]);
						account = box.getAccount(index);
						accounts = box.getAccounts();
						index ++;
					}
				    in.close();
			    }
		    } catch(IOException a) {
				a.printStackTrace();
			}
					ServerGui window = new ServerGui();
					window.frame.setVisible(true);
				
	}

	/**
	 * Create the application.
	 */
	public ServerGui() {
		server = new Server(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Controller");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 10, 566, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("-----------------------------------------------------------------------------------");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 50, 566, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("Players");
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(20, 322, 135, -246);
		frame.getContentPane().add(list);
	}
	boolean doit(String s) {
		String[] in = s.split("\\s+");
		for(Account a : box.getAccounts()) {
			if(in[0].equals(a.getId()) && in[1].equals(a.getCode()))
				return true;
			else return false;
		}
		return false;
		
		
	}
}
