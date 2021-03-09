package com.yby.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.yby.utils.P;
import com.yby.utils.PUtils;
import com.yby.view.ChoseHero;
import com.yby.view.End;
import com.yby.view.FrameWindow1;
import com.yby.view.GamePanel;

public class EnemyPlane1 extends GameObject {
	public static Image dz1 = PUtils.getImage("image/enemy1.png");
	List<Bullet> arrayList = new LinkedList<>();
	public static Image bomb = PUtils.getImage("image/bomb.png");
	
	public static Image bullet = PUtils.getImage("image/animybullet.png");
	public EnemyPlane1() {
		
		int c=new  Random().nextInt(650)+50;
		life = 2;
		x=c;
		y=-200;
		width = 60;
		height = 60;
		
		new CreateBullet().start();//创建子弹
	}
	@Override
	public void drawMe(Image a,Graphics g,boolean die) {
		if(die == false) {
			g.drawImage(bomb,x,y,width,height, null);
			Image bomb1 = PUtils.getImage("image/bomb1.png");
			g.drawImage(bomb1,x,y,60,60, null);
			Image bomb2 = PUtils.getImage("image/bomb2.png");
			g.drawImage(bomb2,x,y,30,30, null);
			Image bomb3 = PUtils.getImage("image/bomb3.png");
			g.drawImage(bomb3,x,y,10,10, null);
		}
		else{
			g.drawImage(a,x,y,width,height, null);
		y = y+2;
		
		
		
		for(int i = 0;i<arrayList.size();i++) {//画出子弹
			
			arrayList.get(i).drawMe(bullet,g,true);
			
			if(GamePanel.fightPlane1 != null) {
				if(GamePanel.fightPlane1.getRect().intersects(arrayList.get(i).getRect())) {
					arrayList.remove(i);
					GamePanel.fightPlane1.life--;
					System.out.println("life:"+GamePanel.fightPlane1.life);
					
					
					System.out.println("!");
				
				}
				
			
			
			}
			
			if(GamePanel.fightPlane2 != null) {
				if(GamePanel.fightPlane2.getRect().intersects(arrayList.get(i).getRect())) {
					arrayList.remove(i);
					GamePanel.fightPlane2.life--;
					System.out.println("life:"+GamePanel.fightPlane2.life);
					
					
					System.out.println("!");
				
				}
			
			
			}
			
			if(GamePanel.fightPlane3 != null) {
				if(GamePanel.fightPlane3.getRect().intersects(arrayList.get(i).getRect())) {
					arrayList.remove(i);
					GamePanel.fightPlane3.life--;
					System.out.println("life:"+GamePanel.fightPlane3.life);
					
					
					System.out.println("!");
				
				}
			
			
			}
			
			
		}
		
		
		
	}
		//if(y>P.HEIGHT) y=-150;
		
}

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,width,height);
	}
	
	
	class Bullet extends GameObject{
		public Bullet() {
			//this.x = x;
			//this.y = y;
			width = 10;
			height = 15;
			
		}

		@Override
		public void drawMe(Image a,Graphics g,boolean die) {
			g.drawImage(a, x,y,width,height,null);
			
			y = y+3;
			
			
		}

		@Override
		public Rectangle getRect() {
			// TODO Auto-generated method stub
			return new Rectangle((int)x,(int)y,width,height);
		}
		
	}
	class CreateBullet extends Thread{
		public void run() {
			while(GamePanel.flag) {
				try {
					Bullet bullet = new Bullet();
					bullet.x = x+18;
					bullet.y = y+40;
					arrayList.add(bullet);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
