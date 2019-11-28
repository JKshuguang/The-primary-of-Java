package self.java.tools;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Tools {

	public static JFrame getFrame() {
		//得到屏幕宽高
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension = tk.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;
		
		//设置左上角位置
		int x = (width - 720)/2;
		int y = (height - 500)/2;
		
		//设置新Frame和关闭方式
		JFrame newFrame = new JFrame();
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.setBounds(x, y, 720, 500);
		
		//不可改变窗口大小
		newFrame.setResizable(false);
		
		return newFrame;
	}
	
	public static JFrame getWrongPassFrame() {
		//得到屏幕宽高
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension = tk.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;
		
		//设置左上角位置
		int x = (width - 450 + 300)/2;
		int y = (height - 300 + 150)/2;
		
		//设置新Frame和关闭方式
		JFrame newFrame = new JFrame();
		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newFrame.setBounds(x, y, 160, 100);
		
		//不可改变窗口大小
		newFrame.setResizable(false);
		
		return newFrame;
	}
}
