package com.yby.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.yby.entity.FightPlane1;
import com.yby.entity.FightPlane2;
import com.yby.entity.FightPlane1.CreateBullet;
import com.yby.entity.FightPlane3;

public class PlaneController3 extends KeyAdapter{
	FightPlane3 fightPlane;
	
	
	
	public PlaneController3(FightPlane3 fightPlane) {
		this.fightPlane = fightPlane;
		
		
		
	}
	
	public void keyPressed(KeyEvent e) {
		
		direction1(e.getKeyCode());
	}
	
	public void direction1(int code) {
		switch(code) {
			case KeyEvent.VK_LEFT:
				fightPlane.left = true;
				fightPlane.right = false;
			
				break;
			case KeyEvent.VK_RIGHT:
				fightPlane.left = false;
				fightPlane.right = true;
				
			
				break;
			case KeyEvent.VK_DOWN:
				fightPlane.down = true;
				fightPlane.up = false;

				
				
				break;
			case KeyEvent.VK_UP:
				fightPlane.down = false;
				fightPlane.up = true;
		
				break;
			case KeyEvent.VK_Z:
				fightPlane.shot = true;
				fightPlane.speed = 3;
			break;
			case KeyEvent.VK_X:
				if(FightPlane3.can)
				fightPlane.skill = true;
				break;
		}
	}
	
	
	public void keyReleased(KeyEvent e) {
		direction2(e.getKeyCode());
	}
	
	public void direction2(int code) {
		switch(code) {
		case KeyEvent.VK_LEFT:
			fightPlane.left = false;

			break;
		case KeyEvent.VK_RIGHT:
			
			fightPlane.right = false;
			
		
			break;
		case KeyEvent.VK_DOWN:
			fightPlane.down = false;
		
			break;
		case KeyEvent.VK_UP:
			
			fightPlane.up = false;
			
			break;
		case KeyEvent.VK_Z:
			fightPlane.shot = false;
			fightPlane.speed = 5;
		break;
		case KeyEvent.VK_X:
			
	}
	}

}
