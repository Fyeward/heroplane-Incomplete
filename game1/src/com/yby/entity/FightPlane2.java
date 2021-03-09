package com.yby.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import com.yby.utils.PUtils;
import com.yby.view.GamePanel;

public class FightPlane2 extends GameObject {
	
	List<Bullet> arrayList1 = new LinkedList<>();
	List<Bullet> arrayList2 = new LinkedList<>();
	public static Image image = PUtils.getImage("image/hero2.png");
	public static Image bullet = PUtils.getImage("image/bullet.png");
	
	public static boolean up = false;
	public static boolean down = false;
	public static boolean left = false;
	public static boolean right = false;
	public static boolean shot = false;
	public static boolean skill = false;
	public static boolean can = true;
	
	public FightPlane2() {
		speed = 2;
		life = 20 ;
		x=300;
		y=600;
		width = 100;
		height = 100;
		
		new CreateBullet().start();//创建子弹
	}
	
//	public void shot(List<Bullet> b,FightPlane2 f,int i) {
//		for(int j = 0;j<GamePanel.arrayListEp1.size();j++) {
//			if(GamePanel.arrayListEp1.get(j).getRect().intersects(arrayList1.get(i).getRect())) {
//				GamePanel.arrayListEp1.get(j).life--;
//				arrayList1.remove(i);
//				if(GamePanel.arrayListEp1.get(j).life == 0) {
//				GamePanel.arrayListEp1.get(j).drawMe(EnemyPlane1.dz1,g,false);
//				
//				GamePanel.arrayListEp1.remove(j);
//				GamePanel.score += 50;
//				}
//				System.out.println(GamePanel.score);
//			}
//			if(GamePanel.arrayListEp1.get(j).y>800) GamePanel.arrayListEp1.remove(j);
//		}
//	}
	
	@Override
	public void drawMe(Image a,Graphics g,boolean die) {
		if(left == true && x>=5)
			x-=speed;
		if(right == true && x<=680)
			x+=speed;
		if(down == true && y<=650)
			y+=speed;
		if(up == true && y>=5)
			y-=speed;
	
		g.drawImage(a,x,y,width,height, null);
		//于敌机1碰撞
		for(int k = GamePanel.arrayListEp1.size()-1;k>=0;k--) {
			
			if(GamePanel.arrayListEp1.get(k).getRect().intersects(GamePanel.fightPlane2.getRect())) {
				System.out.println("真中boki");
				GamePanel.fightPlane2.life -= 2;
				GamePanel.arrayListEp1.get(k).drawMe(EnemyPlane1.dz1,g,false);
				GamePanel.arrayListEp1.remove(k);
			}
		}
		
		//于敌机2碰撞
		for(int k = GamePanel.arrayListEp2.size()-1;k>=0;k--) {
					
			if(GamePanel.arrayListEp2.get(k).getRect().intersects(GamePanel.fightPlane2.getRect())) {
				System.out.println("真中boki");
				GamePanel.fightPlane2.life -= 5;
				GamePanel.arrayListEp2.get(k).drawMe(EnemyPlane2.dz2,g,false);
				GamePanel.arrayListEp2.remove(k);
			}
		}
		
		//于敌机3碰撞
		for(int k = GamePanel.arrayListEp3.size()-1;k>=0;k--) {
							
			if(GamePanel.arrayListEp3.get(k).getRect().intersects(GamePanel.fightPlane2.getRect())) {
				System.out.println("真中boki");
				GamePanel.fightPlane2.life -= 1;
				GamePanel.arrayListEp3.get(k).drawMe(EnemyPlane3.dz3,g,false);
				GamePanel.arrayListEp3.remove(k);
			}
		}	
		
		
		for(int i = arrayList1.size()-1;i>=0;i--) {//画出子弹
			
			arrayList1.get(i).drawMe(bullet,g,true);
			
			for(int j = GamePanel.arrayListEp1.size()-1;j>=0;j--) {
				if(GamePanel.arrayListEp1.get(j).getRect().intersects(arrayList1.get(i).getRect())) {
					GamePanel.arrayListEp1.get(j).life--;
					arrayList1.remove(i);
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
				if(GamePanel.arrayListEp2.get(j).getRect().intersects(arrayList1.get(i).getRect())) {
					arrayList1.remove(i);
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
				if(GamePanel.arrayListEp3.get(j).getRect().intersects(arrayList1.get(i).getRect())) {
					arrayList1.remove(i);
					GamePanel.arrayListEp3.get(j).life--;
					if(GamePanel.arrayListEp3.get(j).life == 0) {
					GamePanel.arrayListEp3.get(j).drawMe(EnemyPlane3.dz3,g,false);
					
					GamePanel.arrayListEp3.remove(j);
					GamePanel.score += 25;
					}
					System.out.println(GamePanel.score);
				}
				//if(GamePanel.arrayListEp3.get(j).y>800) GamePanel.arrayListEp2.remove(j);
			}
			
			if(arrayList1.get(i).y<30) {
				arrayList1.remove(i);
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
		int time = 0;
		public void run() {
			while(true) {
				try {
					if(shot) {
					Bullet bullet1 = new Bullet();
					bullet1.x = x+15;
					bullet1.y = y+10;
					arrayList1.add(bullet1);
					
					Bullet bullet2 = new Bullet();
					bullet2.x = x+65;
					bullet2.y = y+10;
					arrayList1.add(bullet2);
					}
					
					if(skill) {
					Bullet bullet1 = new Bullet();
					bullet1.x = x-15;
					bullet1.y = y+50;
					arrayList1.add(bullet1);
						
					Bullet bullet2 = new Bullet();
					bullet2.x = x+95;
					bullet2.y = y+50;
					arrayList1.add(bullet2);
						
					Bullet bullet3 = new Bullet();
					bullet3.x = x+15;
					bullet3.y = y+10;
					arrayList1.add(bullet3);
					
					Bullet bullet4 = new Bullet();
					bullet4.x = x+65;
					bullet4.y = y+10;
					arrayList1.add(bullet4);

					Bullet bullet5 = new Bullet();
					bullet5.x = x+40;
					bullet5.y = y;
					arrayList1.add(bullet5);
					}
					
					Thread.sleep(300);
					time++;
					if(skill && time == 20) {
						skill = false;
						can = false;
					}
					if(time == 50) {
						can = true;
						time = 0;
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
