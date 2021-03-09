package com.yby.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * 
 * @author 17528
 * plane
 */
public abstract class GameObject {
	public int x,y,width,height,life,speed;
	
	public abstract void drawMe(Image a,Graphics g,boolean die);
	public abstract Rectangle getRect();
    
	
}
