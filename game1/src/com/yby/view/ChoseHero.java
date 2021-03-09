package com.yby.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.yby.entity.FightPlane1;

public class ChoseHero extends JPanel{

	ImageIcon background;
	ImageIcon hero1 = new ImageIcon("image/chhero1.png");
	ImageIcon hero2 = new ImageIcon("image/chhero2.png");
	ImageIcon hero3 = new ImageIcon("image/chhero3.png");
	private JFrame frame;
	public static FrameWindow1 f1;
	public static FrameWindow2 f2;
	public static FrameWindow3 f3;

	public static void main(String[] args) {
		new ChoseHero();
	}
	
	/**
	 * Create the application.
	 */
	public ChoseHero() {
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
		
		
		
		frame.getContentPane().setLayout(null);
		
		JLabel lblChoseYourHero = new JLabel("Chose  your  hero  plane!");
		lblChoseYourHero.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		lblChoseYourHero.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoseYourHero.setBounds(10, 13, 766, 51);
		frame.getContentPane().add(lblChoseYourHero);
		
		JLabel lblNewLabel_2 = new JLabel("---------------------------------------------------"
				+ "---------------------------------------------------------------------------"
				+ "-----------------------------------------------------------------");
		lblNewLabel_2.setBounds(10, 74, 766, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("<html><body>"+"Damage: 1"+"<br>"+"Defense: 15"+"<br>"+"Speed: 5"+"<br>"+"Skill:Ripple Scoot"+"<body></html>");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(262, 137, 206, 125);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("<html><body>Damage: 2<br>Defense: 20<br>Speed: 2<br>Skill:Battle Frenzy<body></html>");
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label.setBounds(262, 338, 206, 125);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("<html><body>Damage: 2<br>Defense: 10<br>Speed: 3<br>Skill:Invincible Time<body></html>");
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label_1.setBounds(262, 538, 206, 125);
		frame.getContentPane().add(label_1);
		
		JButton btn1 = new JButton("B o a r d");
		btn1.setBackground(Color.GRAY);
		btn1.setForeground(Color.BLACK);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				f1 = new FrameWindow1();
				frame.dispose();
			}
		});
		btn1.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		btn1.setBounds(528, 172, 206, 36);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("B o a r d");
		btn2.setBackground(Color.GRAY);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				f2 = new FrameWindow2();
				frame.dispose();
			}
		});
		btn2.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		btn2.setBounds(528, 427, 206, 36);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("B o a r d");
		btn3.setBackground(Color.GRAY);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				f3 = new FrameWindow3();
				frame.dispose();
			}
		});
		btn3.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		btn3.setBounds(528, 614, 206, 36);
		frame.getContentPane().add(btn3);

		//frame.getContentPane().add(new mPanel());
		
		JLabel lblhero1 = new JLabel(hero1);
		lblhero1.setBounds(100, 150, 100, 100);
		frame.getContentPane().add(lblhero1);
		
		JLabel lblhero2 = new JLabel(hero2);
		lblhero2.setBounds(100, 350, 100, 100);
		frame.getContentPane().add(lblhero2);
		
		JLabel lblhero3 = new JLabel(hero3);
		lblhero3.setBounds(100, 550, 100, 100);
		frame.getContentPane().add(lblhero3);
		
		background = new ImageIcon("image/heroplane1.png");
		JLabel lblNewLabel = new JLabel(background);
		lblNewLabel.setBounds(0, 0, 796, 773);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
