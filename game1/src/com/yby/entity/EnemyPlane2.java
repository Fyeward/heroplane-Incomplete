package com.yby.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.yby.utils.P;
import com.yby.utils.PUtils;
import com.yby.view.End;
import com.yby.view.GamePanel;

public class EnemyPlane2 extends GameObject  {
	public static Image dz2 = PUtils.getImage("image/enemy2.png");
	List<Bullet> arrayList1 = new LinkedList<>();
	List<Bullet> arrayList2 = new LinkedList<>();
	public static Image bomb = PUtils.getImage("image/bomb.png");
	
	public static Image bullet = PUtils.getImage("image/animybullet.png");
	public EnemyPlane2() {
		int c=new  Random().nextInt(650)+50;
		life = 5;
		x=c;
		y=-200;
		width = 150;
		height = 150;
		
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
		y = y+1;
		
		
		
		
		for(int i = 0;i<arrayList1.size();i++) {//画出子弹
			
			arrayList1.get(i).drawMe(bullet,g,true);
			
			if(GamePanel.fightPlane1 != null) {
				if(GamePanel.fightPlane1.getRect().intersects(arrayList1.get(i).getRect())) {
					arrayList1.remove(i);
					GamePanel.fightPlane1.life--;
					System.out.println("life:"+GamePanel.fightPlane1.life);
					if(GamePanel.fightPlane1.life == 0) {
						new End();
						System.out.println("游戏结束!");
					}
					
					System.out.println("!");
				
				}
			}
			
			if(GamePanel.fightPlane2 != null) {
				if(GamePanel.fightPlane2.getRect().intersects(arrayList1.get(i).getRect())) {
					arrayList1.remove(i);
					GamePanel.fightPlane2.life--;
					if(GamePanel.fightPlane2.life == 0) {
						new End();
						System.out.println("游戏结束!");
					}
					
					System.out.println("!");
				
				}
			}
			
			if(GamePanel.fightPlane3 != null) {
				if(GamePanel.fightPlane3.getRect().intersects(arrayList1.get(i).getRect())) {
					arrayList1.remove(i);
					GamePanel.fightPlane3.life--;
					if(GamePanel.fightPlane3.life == 0) {
						new End();
						System.out.println("游戏结束!");
					}
					
					System.out.println("!");
				
				}
			}
			
			
		
		}
		
		for(int i = 0;i<arrayList2.size();i++) {//画出子弹
			
			arrayList2.get(i).drawMe(bullet,g,true);
			
			if(GamePanel.fightPlane1 != null) {
				if(GamePanel.fightPlane1.getRect().intersects(arrayList2.get(i).getRect())) {
					arrayList2.remove(i);
					GamePanel.fightPlane1.life--;
					if(GamePanel.fightPlane1.life == 0) {
						new End();
						System.out.println("游戏结束!");
					}
					
					System.out.println("!");
				
				}
			}
			
			if(GamePanel.fightPlane2 != null) {
				if(GamePanel.fightPlane2.getRect().intersects(arrayList2.get(i).getRect())) {
					arrayList2.remove(i);
					GamePanel.fightPlane2.life--;
					if(GamePanel.fightPlane2.life == 0) {
						new End();
						System.out.println("游戏结束!");
					}
					
					System.out.println("!");
				
				}
			}
			
			if(GamePanel.fightPlane3 != null) {
				if(GamePanel.fightPlane3.getRect().intersects(arrayList2.get(i).getRect())) {
					arrayList2.remove(i);
					GamePanel.fightPlane3.life--;
					if(GamePanel.fightPlane3.life == 0) {
						new End();
						System.out.println("游戏结束!");
					}
					
					System.out.println("!");
				
				}
			}
			
			}
			
		
	
		//if(y>P.HEIGHT) y=-150;
	}	
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
			width = 15;
			height = 25;
			
		}

		@Override
		public void drawMe(Image a,Graphics g,boolean die) {
			g.drawImage(a, x,y,width,height,null);
			
			y = y+2;
			
			
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
					Bullet bullet1 = new Bullet();
					bullet1.x = x+37;
					bullet1.y = y+100;
					arrayList1.add(bullet1);
					
					Bullet bullet2 = new Bullet();
					bullet2.x = x+97;
					bullet2.y = y+100;
					arrayList2.add(bullet2);
					
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
