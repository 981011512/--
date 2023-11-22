package com.cf.forward.dh.common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * 智能交通列表双击展示图片框架
 */
public class ListPictureShowDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	public ListPictureShowDialog() {
	    setLayout(new BorderLayout());
	    setModal(true);   
	    pack();
	    setSize(800, 600);
	    setResizable(false);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // 释放窗体

	    
	    listPanel = new PaintPanel();
	    add(listPanel, BorderLayout.CENTER);
	    
	    addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent e) {
	    		dispose();		
	    	}
	    });
	}
	
	public PaintPanel listPanel;
}