package com.yby.view;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


import com.yby.controller.PlaneController1;
import com.yby.controller.PlaneController2;
import com.yby.entity.EnemyPlane1;
import com.yby.entity.FightPlane1;
import com.yby.entity.FightPlane2;
import com.yby.entity.GameObject;
import com.yby.utils.P;

public class FrameWindow1 {

	private JFrame jFrame;
	
	public FrameWindow1() {
		
		launch();
	}
	
	public void launch() {
		jFrame = new JFrame();
		FightPlane1 fightPlane = new FightPlane1();
		
		
		PlaneController1 controller = new PlaneController1(fightPlane);
		GamePanel gamePanel = new GamePanel(fightPlane,jFrame);
		
		
		jFrame.add(gamePanel);
		jFrame.addKeyListener(controller);
		jFrame.setTitle("·É»ú´óÕ½");
		jFrame.setSize(P.WIDTH,P.HEIGHT);
		
		jFrame.setVisible(true);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
