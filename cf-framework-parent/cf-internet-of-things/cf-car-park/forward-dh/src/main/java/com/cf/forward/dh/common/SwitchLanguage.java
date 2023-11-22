package com.cf.forward.dh.common;

import com.cf.forward.dh.common.Res.LanguageType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * 选择语言界面Demo
 */
public class SwitchLanguage extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public SwitchLanguage() {
	    setTitle("请选择语言/Please Select Language");
	    setLayout(new BorderLayout());
	    pack();
	    setSize(350, 200);
	    setResizable(false);
	    setLocationRelativeTo(null);
	    
    	try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        	e.printStackTrace();
        } 

	    add(new SwitchLanguagePanel(this), BorderLayout.CENTER);
	    
	    this.addWindowListener(new WindowAdapter() {
	    	@Override
	    	public void windowClosing(WindowEvent e) {
	    		dispose(); 		
	    		System.exit(0);    		
	    	}
	    });
	}
	
	/*
	 * 切换语言面板
	 */
	public class SwitchLanguagePanel extends JPanel {
		private static final long serialVersionUID = 1L;
		
		public SwitchLanguagePanel(final Frame frame) {
			setLayout(new FlowLayout());
			setBorder(new EmptyBorder(50, 0, 0, 0));
			
			String[] CnEn = {"简体中文", "English"};
			jComboBox = new JComboBox(CnEn);	
			
			nextButton = new JButton("下一步");

			add(jComboBox);
			add(nextButton); 
		    
			jComboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					LanguageType type = jComboBox.getSelectedIndex() == 0 ? LanguageType.Chinese : LanguageType.English;
					Res.string().switchLanguage(type);
					
					if(jComboBox.getSelectedIndex() == 0) {
						nextButton.setText("下一步");
					} else {
						nextButton.setText("next");
					}
				}
			});
			
		    nextButton.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent arg0) {			
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {	
							frame.dispose();
//							FunctionList functiondemo = new FunctionList();
//							functiondemo.setVisible(true);
						}
					});		
				}
			});
		}
		
		private JComboBox jComboBox;	
		private JButton nextButton;
	}
}


