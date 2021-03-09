package com.yby.view;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


import com.yby.entity.CreateEnemy1;
import com.yby.entity.CreateEnemy2;
import com.yby.entity.CreateEnemy3;

import com.yby.entity.EnemyPlane1;
import com.yby.entity.EnemyPlane2;
import com.yby.entity.EnemyPlane3;
import com.yby.entity.FightPlane1;
import com.yby.entity.FightPlane2;
import com.yby.entity.FightPlane3;
import com.yby.entity.GameObject;
import com.yby.utils.PUtils;

public class GamePanel extends JPanel{
	public static boolean flag;
	
	public static Image bg = PUtils.getImage("image/heroplane1.png");
	public static FightPlane1 fightPlane1 = null;
	public static FightPlane2 fightPlane2 = null;
	public static FightPlane3 fightPlane3 = null;

	JFrame f1;
	JFrame f2;
	JFrame f3;

	
	public static List<EnemyPlane1> arrayListEp1 = new LinkedList<>();
	public static List<EnemyPlane2> arrayListEp2 = new LinkedList<>();
	public static List<EnemyPlane3> arrayListEp3 = new LinkedList<>();
	
	public static int score = 0;
	public static Image offScreenImage;
	private Image iBuffer;

	private Graphics gBuffer;

	public GamePanel(FightPlane1 fightPlane,JFrame f1){
		score = 0;
		this.flag = true;
		this.fightPlane1 = fightPlane;
		this.f1 = f1;
		arrayListEp1.clear();
		arrayListEp2.clear();
		arrayListEp3.clear();
		//this.enemyplane = enemyPlane;
		new updateGame().start();//÷ÿª≠
		new CreateEnemy1().start();//10º‹
		new CreateEnemy2().start();
		new CreateEnemy3().start();
		
	}
	
	public GamePanel(FightPlane2 fightPlane,JFrame f2){
		score = 0;
		this.flag = true;
		this.fightPlane2 = fightPlane;
		this.f2 = f2;
		//this.enemyplane = enemyPlane;
		arrayListEp1.clear();
		arrayListEp2.clear();
		arrayListEp3.clear();
		new updateGame().start();//÷ÿª≠
		new CreateEnemy1().start();//10º‹
		new CreateEnemy2().start();
		new CreateEnemy3().start();
	}
	public GamePanel(FightPlane3 fightPlane,JFrame f3){
		score = 0;
		this.flag = true;
		this.fightPlane3 = fightPlane;
		this.f3 = f3;
		arrayListEp1.clear();
		arrayListEp2.clear();
		arrayListEp3.clear();
		//this.enemyplane = enemyPlane;
		new updateGame().start();//÷ÿª≠
		new CreateEnemy1().start();//10º‹
		new CreateEnemy2().start();
		new CreateEnemy3().start();
	}
	
	
	
	public void paint(Graphics g) {
		
		if(iBuffer==null)
		{
			iBuffer=this.createImage(800, 800);
		}
		g.clearRect(0,0,800,800);
		g.drawImage(bg,0,0,800,800,null);
		if(fightPlane1 != null) {
			//g.drawImage(offScreenImage, 0, 0, null);
			fightPlane1.drawMe(fightPlane1.image,g,true);
		}
		
		if(fightPlane2 != null) {
			//g.drawImage(offScreenImage, 0, 0, null);
			fightPlane2.drawMe(fightPlane2.image,g,true);
		}

		if(fightPlane3 != null) {
			//g.drawImage(offScreenImage, 0, 0, null);
			fightPlane3.drawMe(fightPlane3.image,g,true);
		}


		for(int i = 0;i<arrayListEp1.size();i++) {
			arrayListEp1.get(i).drawMe(EnemyPlane1.dz1,g,true);
		}
		
		for(int i = 0;i<arrayListEp2.size();i++) {
			arrayListEp2.get(i).drawMe(EnemyPlane2.dz2,g,true);
		}
		
		for(int i = 0;i<arrayListEp3.size();i++) {
			arrayListEp3.get(i).drawMe(EnemyPlane3.dz3,g,true);
		}
	}
	class updateGame extends Thread {
		
		public void run() {
			
			while(flag) {
				try {
					if(GamePanel.fightPlane1 != null) {
						if(GamePanel.fightPlane1.life <= 0) {
							
							GamePanel.fightPlane1.life = 15;
							GamePanel.fightPlane1.up = false;
							GamePanel.fightPlane1.down = false;
							GamePanel.fightPlane1.left = false;
							GamePanel.fightPlane1.right = false;
							GamePanel.fightPlane1 = null;
							arrayListEp1.clear();
							arrayListEp2.clear();
							arrayListEp3.clear();
							flag = false;
							new End();
							
							f1.dispose();
							
						}
					}
					
					if(GamePanel.fightPlane2 != null) {
						if(GamePanel.fightPlane2.life <= 0) {
							
							GamePanel.fightPlane2.life = 20;
							GamePanel.fightPlane2.up = false;
							GamePanel.fightPlane2.down = false;
							GamePanel.fightPlane2.left = false;
							GamePanel.fightPlane2.right = false;
							GamePanel.fightPlane2 = null;
							arrayListEp1.clear();
							arrayListEp2.clear();
							arrayListEp3.clear();
							flag = false;
							new End();
							f2.dispose();
							
						}
					}
					
					if(GamePanel.fightPlane3 != null) {
						if(GamePanel.fightPlane3.life <= 0) {
							
							GamePanel.fightPlane3.life = 10;
							GamePanel.fightPlane3.up = false;
							GamePanel.fightPlane3.down = false;
							GamePanel.fightPlane3.left = false;
							GamePanel.fightPlane3.right = false;
							GamePanel.fightPlane3 = null;
							arrayListEp1.clear();
							arrayListEp2.clear();
							arrayListEp3.clear();
							flag = false;
							new End();
							f3.dispose();
							
						}
					}
					Thread.sleep(10);
							} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
			}
		}
	}
}
