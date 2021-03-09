package com.yby.view;

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

public class FrameWindow2 {
	JFrame jFrame;
	
	
	public FrameWindow2() {
		
		launch();
	}
	
	public void launch() {
		FightPlane2 fightPlane = new FightPlane2();
		jFrame = new JFrame();
		
		PlaneController2 controller = new PlaneController2(fightPlane);
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
