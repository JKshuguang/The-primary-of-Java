package self.java.log;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import self.java.tools.JFrameDemo;

public class LogIn extends JFrame {

	static JFrameDemo jFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//得到主界面
		jFrame = new JFrameDemo("C:\\Users\\即客\\Desktop\\img\\login_background4.jpg");
		
		//初始化登录界面面板
		LogInPane imagePanel = new LogInPane(jFrame,jFrame.getFrameSize(), jFrame.getImageIcon().getImage());
		
		//添加登录界面到主界面中
		jFrame.setContentPane(imagePanel);
		
		//显示
		jFrame.setVisible(true);
		
	}

	/**
	 * Create the frame.
	 */
	public LogIn() {
		//设置面板大小
        setLocationRelativeTo(null);
        
        //设置默认关闭模式
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
    }
	
//	//重写放置背景图片方法
//    public void addImageByRepaint() {
//        LogInPane imagePanel = new LogInPane(jFrame,frameSize, imageIcon.getImage());
//        setContentPane(imagePanel);
//        
//        //展示
//        setVisible(true);
//    }
    

}
