package com.yby.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.yby.entity.EnemyPlane1.Bullet;
import com.yby.view.GamePanel;

public class CreateEnemy1 extends Thread {
	
	public void run() {
		while(GamePanel.flag) {
			for(int i = 0;i<10;i++) {
				if(!GamePanel.flag) break;
				GamePanel.arrayListEp1.add(new EnemyPlane1());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}	
	}
}
