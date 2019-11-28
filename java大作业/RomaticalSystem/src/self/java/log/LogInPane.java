package self.java.log;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import self.java.pane.MenuPane;
import self.java.pane.WrongPane;
import self.java.tools.JDBCTools;
import self.java.tools.JFrameDemo;
import self.java.tools.Tools;

public class LogInPane extends JPanel {
	
    Dimension d;
    Image image;
	
	private static JFrame jframe;
	private JTextField acountField;
	private JPasswordField passwordField;
	private JButton registerButton;
	private JButton resetButton;
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, d.width, d.height, this);
    }
	
	public LogInPane(JFrame frame,Dimension d, Image image) {
		
		
        super();
        //得到当前Frame
        this.jframe = frame;
        this.d = d;
        this.image = image;
		
        //设置前景色和背景色
		setForeground(Color.PINK);
		setBackground(Color.GRAY);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//得到一个Grid布局
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{200, 30, 30, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[] {80, 100, 30, 10, 0, 30, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		//设置contendPane的布局为GridBagLayout模式
		setLayout(gbl_contentPane);
		
		//创建账号文本
		JLabel userLabel = new JLabel("账 号:");
		GridBagConstraints gbc_user = new GridBagConstraints();
		gbc_user.insets = new Insets(0, 0, 5, 5);
		gbc_user.gridx = 3;
		gbc_user.gridy = 2;
		add(userLabel, gbc_user);
		
		//账号文本框
		acountField = new JTextField();
		acountField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 2;
		add(acountField, gbc_textField);
		
		//创建密码文本
		JLabel password = new JLabel("密 码:");
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.insets = new Insets(0, 0, 5, 5);
		gbc_password.gridx = 3;
		gbc_password.gridy = 4;
		add(password, gbc_password);
				
		//密码输入框
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);
				
		//重置按钮
		resetButton = new JButton("重 置");
		GridBagConstraints reset_button = new GridBagConstraints();
		reset_button.anchor = GridBagConstraints.EAST;
		reset_button.insets = new Insets(0, 0, 0, 5);
		reset_button.gridx = 3;
		reset_button.gridy = 6;
		add(resetButton, reset_button);
				
		//登录按钮
		registerButton = new JButton("\u767B \u5F55");
		GridBagConstraints register_button = new GridBagConstraints();
		register_button.anchor = GridBagConstraints.EAST;
		register_button.gridx = 4;
		register_button.gridy = 6;
		add(registerButton, register_button);
		
		//处理单击响事件
		handleActionEvent();
	}
	

	//处理单击响应事件
	private void handleActionEvent() {
		
		//处理重置按钮的单击响应事件
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//处理重置方法
				resetButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//账号清空
						acountField.setText("");
						
						//密码清空
						passwordField.setText("");
						
					}
				});
				
			}
		});
		
		//处理登录按钮的单击响应事件
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//检测账号密码是否正确 UPRight 
				boolean UPRight = false;
				
				//假如正确登录
				//得到输入的账号密码
				String acountString = acountField.getText().trim();
				String passString = passwordField.getText().trim();
				UPRight = checkAcount(acountString,passString);
				
				//不正确则提示登录错误 则进行错误处理
				
				if (UPRight) {
					//关闭当前面板
					jframe.setVisible(false);
					
					//得到一个新的Jframe
					JFrameDemo newFrame = new JFrameDemo("");
					
					//进入主界面
					newFrame.getContentPane().add(new MenuPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
					
					//展示主界面
					newFrame.setVisible(true);
				}else {
					//得到输入错误的新JFrame
					JFrame newFrame = Tools.getWrongPassFrame();
					
					//添加组件
					newFrame.getContentPane().add(new WrongPane());
					
					//显示界面
					newFrame.setVisible(true);
					
				}
				
			}
			
			//检查账号密码是否对应
			public boolean checkAcount(String count,String password) {
				//声明需要用到的变量
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet res = null;
				try {
					//得到数据库连接
					conn = JDBCTools.getConnection();
					
					//写SQL
					String sql = "Select * from Acount Where userAcount = ? And userPassword = ?";
					
					//填充占位符
					ps = conn.prepareStatement(sql);
					ps.setObject(1, count);
					ps.setObject(2, password);
					res = ps.executeQuery();
					
					//判断是否有查询结果
					if (res.next()) {
						//账号密码对应
						return true;
					}else {
						//账号密码不对应
						return false;
					}
					
				} catch (Exception e) {
					//打印堆栈信息
					e.printStackTrace();
				} finally {
					//关闭资源
					JDBCTools.closeResource(conn, ps, res);
				}
				
				return false;
			}
		});
		
	}

}
