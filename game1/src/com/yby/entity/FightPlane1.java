package com.yby.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import com.yby.utils.Music;
import com.yby.utils.PUtils;
import com.yby.view.End;
import com.yby.view.GamePanel;

public class FightPlane1 extends GameObject {
	
	List<Bullet> arrayList = new LinkedList<>();
	public static Image image = PUtils.getImage("image/hero1.png");
	public static Image bullet = PUtils.getImage("image/bullet.png");
	
	public static boolean up = false;
	public static boolean down = false;
	public static boolean left = false;
	public static boolean right = false;
	public static boolean shot = false;
	public static boolean skill = false;
	
	public FightPlane1() {
		speed = 5;
		life = 15 ;
		x=300;
		y=600;
		width = 80;
		height = 80;
		
		new CreateBullet().start();//创建子弹
	}
	@Override
	public void drawMe(Image a,Graphics g,boolean die) {
		if(skill) speed = 10;
		else speed = 5;
		
		
		if(left == true && x>=5)
			x-=speed;
		if(right == true && x<=700)
			x+=speed;
		if(down == true && y<=630)
			y+=speed;
		if(up == true && y>=5)
			y-=speed;
	
		g.drawImage(a,x,y,width,height, null);
		

		
		//于敌机1碰撞
		
		for(int k = GamePanel.arrayListEp1.size()-1;k>=0;k--) {
			
			if(GamePanel.arrayListEp1.get(k).getRect().intersects(GamePanel.fightPlane1.getRect())) {
				System.out.println("真中boki");
				GamePanel.fightPlane1.life -= 2;
				GamePanel.arrayListEp1.get(k).drawMe(EnemyPlane1.dz1,g,false);
				GamePanel.arrayListEp1.remove(k);
			}
		}
		
		//于敌机2碰撞
		for(int k = GamePanel.arrayListEp2.size()-1;k>=0;k--) {
					
			if(GamePanel.arrayListEp2.get(k).getRect().intersects(GamePanel.fightPlane1.getRect())) {
				System.out.println("真中boki");
				GamePanel.fightPlane1.life -= 5;
				GamePanel.arrayListEp2.get(k).drawMe(EnemyPlane2.dz2,g,false);
				GamePanel.arrayListEp2.remove(k);
			}
		}
		
		//于敌机3碰撞
				for(int k = GamePanel.arrayListEp3.size()-1;k>=0;k--) {
							
					if(GamePanel.arrayListEp3.get(k).getRect().intersects(GamePanel.fightPlane1.getRect())) {
						System.out.println("真中boki");
						GamePanel.fightPlane1.life -= 1;
						GamePanel.arrayListEp3.get(k).drawMe(EnemyPlane3.dz3,g,false);
						GamePanel.arrayListEp3.remove(k);
					}
				}		
		
		for(int i = arrayList.size()-1;i>=0;i--) {//画出子弹
			
			arrayList.get(i).drawMe(bullet,g,true);
			
			for(int j = GamePanel.arrayListEp1.size()-1;j>=0;j--) {
				if(GamePanel.arrayListEp1.get(j).getRect().intersects(arrayList.get(i).getRect()) ) {
					GamePanel.arrayListEp1.get(j).life--;
					arrayList.remove(i);
					if(GamePanel.arrayListEp1.get(j).life == 0) {
					GamePanel.arrayListEp1.get(j).drawMe(EnemyPlane1.dz1,g,false);
					
					GamePanel.arrayListEp1.remove(j);
					GamePanel.score += 50;
					}
					System.out.println(GamePanel.score);
				}
				
				
				//if(GamePanel.arrayListEp1.get(j).y>800) GamePanel.arrayListEp1.remove(j);
				}
			
	
			for(int j = GamePanel.arrayListEp2.size()-1;j>=0;j--) {
				if(GamePanel.arrayListEp2.get(j).getRect().intersects(arrayList.get(i).getRect())) {
					arrayList.remove(i);
					GamePanel.arrayListEp2.get(j).life--;
					if(GamePanel.arrayListEp2.get(j).life == 0) {
					GamePanel.arrayListEp2.get(j).drawMe(EnemyPlane2.dz2,g,false);
					
					GamePanel.arrayListEp2.remove(j);
					GamePanel.score += 100;
					}
					System.out.println(GamePanel.score);
				}
				//if(GamePanel.arrayListEp2.get(j).y>800) GamePanel.arrayListEp2.remove(j);
			}
			
			for(int j = GamePanel.arrayListEp3.size()-1;j>=0;j--) {
				if(GamePanel.arrayListEp3.get(j).getRect().intersects(arrayList.get(i).getRect())) {
					arrayList.remove(i);
					GamePanel.arrayListEp3.get(j).life--;
					if(GamePanel.arrayListEp3.get(j).life == 0) {
					GamePanel.arrayListEp3.get(j).drawMe(EnemyPlane3.dz3,g,false);
					
					GamePanel.arrayListEp3.remove(j);
					GamePanel.score += 25;
					}
					System.out.println(GamePanel.score);
				}
				//if(GamePanel.arrayListEp3.get(j).y>800) GamePanel.arrayListEp3.remove(j);
			}
			
			if(arrayList.get(i).y<30) {
				arrayList.remove(i);
			}
			
			
		}
	}

	@Override
	public  Rectangle getRect() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,width,height);
	}
	class Bullet extends GameObject{
		public Bullet() {
			//this.x = x;
			//this.y = y;
			width = 20;
			height = 30;
			
		}

		@Override
		public void drawMe(Image a,Graphics g,boolean die) {
			
			g.drawImage(a, x,y,width,height,null);
			
			y=y-2;
			
			
		}

		@Override
		public Rectangle getRect() {
			// TODO Auto-generated method stub
			return new Rectangle((int)x,(int)y,width,height);
		}
		
		
		
	}
	public class CreateBullet extends Thread{
		public void run() {
			while(true) {
				try {
					if(shot) {
						//new Music("music/shot.wav");
					Bullet bullet = new Bullet();
					bullet.x = x+30;
					bullet.y = y-30;
					arrayList.add(bullet);
					}
					
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
