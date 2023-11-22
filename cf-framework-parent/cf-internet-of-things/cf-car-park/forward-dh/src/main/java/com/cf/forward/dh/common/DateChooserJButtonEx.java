package com.cf.forward.dh.common;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间选择器, 年月日
 */
public class DateChooserJButtonEx extends JButton {
	private static final long serialVersionUID = 1L;
	
    int startYear = 1980; // 默认【最小】显示年份
    int lastYear = 2050; // 默认【最大】显示年份
    
    private DateChooser dateChooser = null;
    private String preLabel = "";
    private String originalText = null;
    private SimpleDateFormat sdf = null;
    
    private JSpinner yearSpin;
    private JSpinner monthSpin;
    private JSpinner daySpin;
    private JSpinner hourSpin;
    private JSpinner minuteSpin;
    private JSpinner secondSpin;
    
    public DateChooserJButtonEx() {
        this(getNowDate());   
        
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } 
    }

    public DateChooserJButtonEx(String dateString) {
        this();     
    	
        setText(getDefaultDateFormat(), dateString);
        //保存原始是日期时间
        initOriginalText(dateString);
    }

    public DateChooserJButtonEx(SimpleDateFormat df, String dateString) {
        this();
        setText(df, dateString);

        //记忆当前的日期格式化器
        this.sdf = df;

        //记忆原始日期时间
        Date originalDate = null;
        try {
            originalDate = df.parse(dateString);
        } catch (ParseException ex) {
            originalDate = getNowDate();
        }
        initOriginalText(originalDate);
    }

    public DateChooserJButtonEx(Date date) {
        this("", date);
        //记忆原始日期时间
        initOriginalText(date);
    }

    public DateChooserJButtonEx(String preLabel, Date date) {
        if (preLabel != null) {
            this.preLabel = preLabel;
        }
        setDate(date);
        //记忆原始是日期时间
        initOriginalText(date);

        setBorder(null);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        super.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (dateChooser == null) {
                    dateChooser = new DateChooser();
                }

                dateChooser.showDateChooser();          
            }
        });
    }
    
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }
    
    public void setLastYear(int lastYear) {
        this.lastYear = lastYear;
    }

    private static Date getNowDate() {
        return Calendar.getInstance().getTime();
    }

    private static SimpleDateFormat getDefaultDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    /**
     * 得到当前使用的日期格式化器
     * @return 日期格式化器
     */
    public SimpleDateFormat getCurrentSimpleDateFormat(){
        if(this.sdf != null){
            return sdf;
        }else{
            return getDefaultDateFormat();
        }
    }


    //保存原始是日期时间
    private void initOriginalText(String dateString) {
        this.originalText = dateString;
    }

    //保存原始是日期时间
    private void initOriginalText(Date date) {
        this.originalText = preLabel + getDefaultDateFormat().format(date);
    }

    /** 
     * 得到当前记忆的原始日期时间
     * @return 当前记忆的原始日期时间（未修改前的日期时间）
     */
    public String getOriginalText() {
        return originalText;
    }

    // 覆盖父类的方法
    @Override
    public void setText(String s) {
        Date date;
        try {
            date = getDefaultDateFormat().parse(s);
        } catch (ParseException e) {
            date = getNowDate();
        }
        setDate(date);
        initOriginalText(date);
    }

    public void setText(SimpleDateFormat df, String s) {
        Date date;
        try {
            date = df.parse(s);
        } catch (ParseException e) {
            date = getNowDate();
        }
        setDate(date);
        initOriginalText(date);
    }

    public void setDate(Date date) {
        super.setText(preLabel + getDefaultDateFormat().format(date));
    }

    public Date getDate() {
        String dateString = getText().substring(preLabel.length());
        try {
            SimpleDateFormat currentSdf = getCurrentSimpleDateFormat();
            return currentSdf.parse(dateString);
        } catch (ParseException e) {
            return getNowDate();
        }
    }

    /**  
     * 覆盖父类的方法使之无效
     * @param listener 响应监听器
     */
    @Override
    public void addActionListener(ActionListener listener) {
    }

    /**
     * 内部类，主要是定义一个JPanel，然后把日历相关的所有内容填入本JPanel，
     * 然后再创建一个JDialog，把本内部类定义的JPanel放入JDialog的内容区
     */
    private class DateChooser extends JPanel implements MouseListener, ChangeListener {
    	private static final long serialVersionUID = 1L;
    	
        JLabel yearLabel;
        JLabel monthLabel;
        JLabel dayLabel;
        
        int width = 485; // 界面宽度
        int height = 230; // 界面高度
        Color backGroundColor = Color.gray; // 底色
        // 月历表格配色----------------//
        Color palletTableColor = Color.white; // 日历表底色
        Color todayBackColor = Color.orange; // 今天背景色
        Color weekFontColor = Color.blue; // 星期文字色
        Color dateFontColor = Color.black; // 日期文字色
        Color weekendFontColor = Color.red; // 周末文字色
        // 控制条配色------------------//
        Color controlLineColor = Color.pink; // 控制条底色
        Color controlTextColor = Color.white; // 控制条标签文字色
        
        /** 点击DateChooserButton时弹出的对话框，日历内容在这个对话框内 */
        JDialog dialog;
        JLabel[][] daysLabels = new JLabel[6][7];

        DateChooser() {
            setLayout(new BorderLayout());
            setBorder(new LineBorder(backGroundColor, 2));
            setBackground(backGroundColor);

            JPanel topYearAndMonth = createYearAndMonthPanal();
            add(topYearAndMonth, BorderLayout.NORTH);
            JPanel centerWeekAndDay = createWeekAndDayPanal();
            add(centerWeekAndDay, BorderLayout.CENTER);
            JPanel buttonBarPanel = createButtonBarPanel();
            this.add(buttonBarPanel, BorderLayout.SOUTH);
        }

        private JPanel createYearAndMonthPanal() {
            Calendar c = getCalendar();
            int currentYear = c.get(Calendar.YEAR);
            int currentMonth = c.get(Calendar.MONTH) + 1;
            int currentDay = c.get(Calendar.DAY_OF_MONTH);

            JPanel result = new JPanel();
            result.setLayout(new FlowLayout());
            result.setBackground(controlLineColor);

            yearSpin = new JSpinner(new SpinnerNumberModel(currentYear, startYear, lastYear, 1));
            yearSpin.setPreferredSize(new Dimension(48, 20));
            yearSpin.setName("Year");
            yearSpin.setEditor(new JSpinner.NumberEditor(yearSpin, "####"));
            yearSpin.addChangeListener(this);
            result.add(yearSpin);

            yearLabel = new JLabel(Res.string().getYear());
            yearLabel.setForeground(controlTextColor);
            result.add(yearLabel);

            monthSpin = new JSpinner(new SpinnerNumberModel(currentMonth, 1, 12, 1));
            monthSpin.setPreferredSize(new Dimension(35, 20));
            monthSpin.setName("Month");
            monthSpin.addChangeListener(this);
            result.add(monthSpin);

            monthLabel = new JLabel(Res.string().getMonth());
            monthLabel.setForeground(controlTextColor);
            result.add(monthLabel);

            //如果这里要能够选择,会要判断很多东西,比如每个月分别由多少日,以及闰年问题.所以,就干脆把Enable设为false
            daySpin = new JSpinner(new SpinnerNumberModel(currentDay, 1, 31, 1));
            daySpin.setPreferredSize(new Dimension(35, 20));
            daySpin.setName("Day");
            daySpin.addChangeListener(this);
            daySpin.setEnabled(false);
            result.add(daySpin);

            dayLabel = new JLabel(Res.string().getDay());
            dayLabel.setForeground(controlTextColor);
            result.add(dayLabel);      

            return result;
        }

        private JPanel createWeekAndDayPanal() {
        	Res.string().getWeek();
            JPanel result = new JPanel();
            // 设置固定字体，以免调用环境改变影响界面美观
            result.setFont(new Font("宋体", Font.PLAIN, 12));
            result.setLayout(new GridLayout(7, 7));
            result.setBackground(Color.white);
            JLabel cell;

            for (int i = 0; i < 7; i++) {
                cell = new JLabel(Res.string().getWeek()[i]);
                cell.setHorizontalAlignment(JLabel.RIGHT);
                if (i == 0 || i == 6) {
                    cell.setForeground(weekendFontColor);
                } else {
                    cell.setForeground(weekFontColor);
                }
                result.add(cell);
            }

//            int actionCommandId = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    JLabel numberLabel = new JLabel();
                    numberLabel.setBorder(null);
                    numberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//                    numberLabel.setActionCommand(String.valueOf(actionCommandId));
                    numberLabel.addMouseListener(this);
                    numberLabel.setBackground(palletTableColor);
                    numberLabel.setForeground(dateFontColor);
                    if (j == 0 || j == 6) {
                    	numberLabel.setForeground(weekendFontColor);
                    } else {
                    	numberLabel.setForeground(dateFontColor);
                    }
                    daysLabels[i][j] = numberLabel;
                    result.add(numberLabel);
//                    actionCommandId++;
                }
            }

            return result;
        }

        /** 得到DateChooserButton的当前text，本方法是为按钮事件匿名类准备的。 */
        public String getTextOfDateChooserButton() {
            return getText();
        }

        /** 恢复DateChooserButton的原始日期时间text，本方法是为按钮事件匿名类准备的。 */
        public void restoreTheOriginalDate() {
            String originalText = getOriginalText();
            setText(originalText);
        }

        private JPanel createButtonBarPanel() {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1, 2));

            JButton ok = new JButton(Res.string().getConfirm());
            ok.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //记忆原始日期时间
                    initOriginalText(getTextOfDateChooserButton());
                    //隐藏日历对话框
                    dialog.setVisible(false);
                }
            });
            panel.add(ok);

            JButton cancel = new JButton(Res.string().getCancel());
            cancel.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //恢复原始的日期时间
                    restoreTheOriginalDate();     
                    //隐藏日历对话框
                    dialog.setVisible(false);
                }
            });

            panel.add(cancel);
            return panel;
        }

        private JDialog createDialog() {
            JDialog result = new JDialog();
            result.setTitle(Res.string().getDateChooser());
            result.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            result.getContentPane().add(this, BorderLayout.CENTER);
            result.pack();
            result.setSize(width, height);
            result.setModal(true);  
            
            result.addWindowListener(new WindowAdapter() {
    	    	public void windowClosing(WindowEvent e) {
    	    	     //恢复原始的日期时间
                    restoreTheOriginalDate();     
                    //隐藏日历对话框
                    dialog.setVisible(false);
    	    	}
            });
            
            return result;
        }

        void showDateChooser() {
            if (dialog == null) {
                dialog = createDialog();
            }
            dialog.setLocationRelativeTo(null);
            flushWeekAndDay();
            dialog.setVisible(true);
        }

        private Calendar getCalendar() {
            Calendar result = Calendar.getInstance();
            result.setTime(getDate());
            return result;
        }

        private int getSelectedYear() {
            return ((Integer) yearSpin.getValue()).intValue();
        }

        private int getSelectedMonth() {
            return ((Integer) monthSpin.getValue()).intValue();
        }

        private int getSelectedHour() {
            return ((Integer) hourSpin.getValue()).intValue();
        }

        private int getSelectedMinite() {
            return ((Integer) minuteSpin.getValue()).intValue();
        }

        private int getSelectedSecond() {
            return ((Integer) secondSpin.getValue()).intValue();
        }

        private void dayColorUpdate(boolean isOldDay) {
            Calendar c = getCalendar();
            int day = c.get(Calendar.DAY_OF_MONTH);
            c.set(Calendar.DAY_OF_MONTH, 1);
            int actionCommandId = day - 2 + c.get(Calendar.DAY_OF_WEEK);
            int i = actionCommandId / 7;
            int j = actionCommandId % 7;
            if (isOldDay) {
            	daysLabels[i][j].setForeground(dateFontColor);
            } else {
            	daysLabels[i][j].setForeground(todayBackColor);
            }
        }

        private void flushWeekAndDay() {     
            Calendar c = getCalendar();
            c.set(Calendar.DAY_OF_MONTH, 1);
            int maxDayNo = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            int dayNo = 2 - c.get(Calendar.DAY_OF_WEEK);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    String s = "";
                    if (dayNo >= 1 && dayNo <= maxDayNo) {
                        s = String.valueOf(dayNo);
                    }
                    daysLabels[i][j].setText(s);
                    dayNo++;
                }
            }

            // 打开日历时，根据按钮的时间，设置日历的时间
            String[] date1 = getText().split(" ")[0].split("-");

            yearSpin.setValue(new Integer(date1[0]));
            monthSpin.setValue(new Integer(date1[1]));
            daySpin.setValue(new Integer(date1[2]));

            // 重置日历天的数字颜色
            for(int i = 0; i < 6; i++) {
            	for(int j = 0; j < 7; j++) {
            		if(!daysLabels[i][j].getText().equals("")) {
            			daysLabels[i][j].setForeground(Color.BLACK);
            		}
            	}
            }
            
            // 重置日历星期六、星期日的数字颜色
            for(int i = 0; i < 6; i++) {
            	if(!daysLabels[i][0].getText().equals("")) {
            		daysLabels[i][0].setForeground(weekendFontColor);
            	}
            	if(!daysLabels[i][6].getText().equals("")) {
            		daysLabels[i][6].setForeground(weekendFontColor);
            	}
            }
            
            // 设置当天的数字颜色
            for(int i = 0; i < 6; i++) {
            	for(int j = 0; j < 7; j++) {
            		if(daysLabels[i][j].getText().equals(date1[2])) {
            			daysLabels[i][j].setForeground(todayBackColor);
            		}
            	}
            }

            dayColorUpdate(false);
        }

        /**
         * 选择日期时的响应事件
         */
        @Override
        public void stateChanged(ChangeEvent e) {
            JSpinner source = (JSpinner) e.getSource();
            Calendar c = getCalendar();
            if (source.getName().equals("Hour")) {
                c.set(Calendar.HOUR_OF_DAY, getSelectedHour());
                setDate(c.getTime());
                return;
            }
            if (source.getName().equals("Minute")) {
                c.set(Calendar.MINUTE, getSelectedMinite());
                setDate(c.getTime());
                return;
            }
            if (source.getName().equals("Second")) {
                c.set(Calendar.SECOND, getSelectedSecond());
                setDate(c.getTime());
                return;
            }

            dayColorUpdate(true);

            if (source.getName().equals("Year")) {
                c.set(Calendar.YEAR, getSelectedYear());
            } else if (source.getName().equals("Month")) {
                c.set(Calendar.MONTH, getSelectedMonth() - 1);
            }
            setDate(c.getTime());
            flushWeekAndDay();
        }

        /**
         * 选择日期时的响应事件
         */
		@Override
		public void mouseClicked(MouseEvent e) {
            JLabel source = (JLabel) e.getSource();
            if (source.getText().length() == 0) {
                return;
            }
            dayColorUpdate(true);
            source.setForeground(todayBackColor);
            int newDay = Integer.parseInt(source.getText());
            Calendar c = getCalendar();
            c.set(Calendar.DAY_OF_MONTH, newDay);
            setDate(c.getTime());
            //把daySpin中的值也变了
            daySpin.setValue(Integer.valueOf(newDay));
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
    }
}