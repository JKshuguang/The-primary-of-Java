package self.java.tools;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import self.java.log.LogInPane;

public class JFrameDemo extends JFrame {

	//设置屏幕大小
    Dimension frameSize = new Dimension(715, 500);
    
    //设置背景图片
    ImageIcon imageIcon;
    
    public Dimension getFrameSize() {
		return frameSize;
	}

	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	public JFrameDemo(String address) {
    	//得到一个背景
		imageIcon = new ImageIcon(address);
    	
		//设置面板大小
        setSize(frameSize);
        setLocationRelativeTo(null);
        
        //设置默认关闭模式
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(imageIcon.getImage());
        setUndecorated(true);
    }
	
	//重写放置背景图片方法
//    public void addImageByRepaint() {
//        LogInPane imagePanel = new LogInPane(jFrame,frameSize, imageIcon.getImage());
//        setContentPane(imagePanel);
//        
//        //展示
//        setVisible(true);
//    }	
}
