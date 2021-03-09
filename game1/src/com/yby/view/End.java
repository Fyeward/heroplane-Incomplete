package com.yby.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class End {

	private JFrame frmGameOver;

	
	/**
	 * Create the application.
	 */
	public End() {
		
		initialize();
		frmGameOver.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGameOver = new JFrame();
		frmGameOver.setTitle("Game over!");
		
		frmGameOver.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		frmGameOver.setBackground(new Color(240, 240, 240));
		frmGameOver.setBounds(400, 0, 693, 460);
		
		frmGameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon background = new ImageIcon("image/heroplane.png");
		frmGameOver.getContentPane().setLayout(null);
		
		JButton btnSp = new JButton("REPLAY");
		btnSp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChoseHero();
				System.out.println(GamePanel.arrayListEp1.size()+"  "+
				GamePanel.arrayListEp2.size()+"   "+
				GamePanel.arrayListEp3.size());
				frmGameOver.dispose();
			}
		});
		btnSp.setBackground(Color.LIGHT_GRAY);
		btnSp.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnSp.setBounds(116, 320, 194, 60);
		frmGameOver.getContentPane().add(btnSp);
		
		JButton btnDp = new JButton("QUIT");
		btnDp.setBackground(Color.LIGHT_GRAY);
		btnDp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnDp.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnDp.setBounds(371, 320, 194, 60);
		frmGameOver.getContentPane().add(btnDp);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setText("Score:"+GamePanel.score);
		lblScore.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblScore.setBounds(230, 250, 220, 60);
		frmGameOver.getContentPane().add(lblScore);

		JLabel lblNewLabel = new JLabel(background);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblNewLabel.setBounds(0, 0,679, 571);
		frmGameOver.getContentPane().add(lblNewLabel);
	}
	
	

	
}
