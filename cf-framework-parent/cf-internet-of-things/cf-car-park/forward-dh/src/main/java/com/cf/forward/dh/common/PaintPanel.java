package com.cf.forward.dh.common;

import javax.swing.*;
import java.awt.*;

/*
 * 带背景的绘图面板
 */
public class PaintPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image; //背景图片	
	
	public PaintPanel() {
		super();
		setOpaque(true); //非透明
		setLayout(null);
		setBackground(Color.GRAY);
		setForeground(new Color(0, 0, 0));
	}
	
	//设置图片的方法
	public void setImage(Image image) {
		this.image = image;
	}
	
	protected void paintComponent(Graphics g) {    //重写绘制组件外观
		if(image != null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);//绘制图片与组件大小相同
		}
		super.paintComponent(g); // 执行超类方法
	}	
}
