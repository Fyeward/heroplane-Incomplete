package com.yby.utils;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PUtils {
	
	public static Image getImage(String url){
		ImageIcon icon = new ImageIcon(url);
		return icon.getImage();
	}
}
