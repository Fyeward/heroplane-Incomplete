package com.yby.view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.yby.utils.Music;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameHome extends Thread{
	ImageIcon background;
	private JFrame frame;

	/**
	 * Create the application.
	 */
	public GameHome() {
		
	    this.start();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setFont(null);
		frame.setBackground(new Color(240, 240, 240));
		frame.setBounds(400, 0, 800, 800);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		background = new ImageIcon("image/heroplane.png");
		frame.getContentPane().setLayout(null);
		
		JButton btnSp = new JButton("single player");
		btnSp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChoseHero();
				frame.dispose();
				
			}
		});
		btnSp.setBackground(Color.LIGHT_GRAY);
		btnSp.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnSp.setBounds(280, 507, 240, 60);
		frame.getContentPane().add(btnSp);
		
		JButton btnDp = new JButton("Double players");
		btnDp.setBackground(Color.LIGHT_GRAY);
		btnDp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDp.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnDp.setBounds(280, 580, 240, 60);
		frame.getContentPane().add(btnDp);

		JLabel lblNewLabel = new JLabel(background);
		lblNewLabel.setBounds(0, 0,786, 763);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public void run() {
		while(true) {
			new Music("music/Wings of Piano.wav");
			try {
				Thread.sleep(300000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
