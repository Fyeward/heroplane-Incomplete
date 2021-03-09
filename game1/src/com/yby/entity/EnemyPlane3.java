package com.yby.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.yby.utils.P;
import com.yby.utils.PUtils;
import com.yby.view.GamePanel;

public class EnemyPlane3 extends GameObject {
	public static Image dz3 = PUtils.getImage("image/enemy3.png");
	
	public static Image bomb = PUtils.getImage("image/bomb.png");
	
	public static Image bullet = PUtils.getImage("image/animybullet.png");
	public EnemyPlane3() {
		int c=new  Random().nextInt(650);
		life = 1;
		x=c;
		y=-200;
		width = 45;
		height = 45;
		
		
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
		y = y+3;
		
		if(y>P.HEIGHT) y=-150;
		}
	}

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,width,height);
	}
	
	
}
