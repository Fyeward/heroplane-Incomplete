package com.yby.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import com.yby.entity.FightPlane1;

import com.yby.entity.FightPlane1.CreateBullet;
import com.yby.view.End;
import com.yby.view.GamePanel;

public class PlaneController1 extends KeyAdapter{
	FightPlane1 fightPlane;
	JFrame f1;
	
	
	public PlaneController1(FightPlane1 fightPlane) {
		this.fightPlane = fightPlane;
		this.f1 = f1;
		
		
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
				
				break;
			case KeyEvent.VK_X:
				fightPlane.skill = true;
				fightPlane.shot = false;
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
			
		break;
		case KeyEvent.VK_X:
			fightPlane.skill = false;
			break;
		}
	}

}
