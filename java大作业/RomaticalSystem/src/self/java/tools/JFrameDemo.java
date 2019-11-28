package self.java.tools;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import self.java.log.LogInPane;

public class JFrameDemo extends JFrame {

	//������Ļ��С
    Dimension frameSize = new Dimension(715, 500);
    
    //���ñ���ͼƬ
    ImageIcon imageIcon;
    
    public Dimension getFrameSize() {
		return frameSize;
	}

	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	public JFrameDemo(String address) {
    	//�õ�һ������
		imageIcon = new ImageIcon(address);
    	
		//��������С
        setSize(frameSize);
        setLocationRelativeTo(null);
        
        //����Ĭ�Ϲر�ģʽ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(imageIcon.getImage());
        setUndecorated(true);
    }
	
	//��д���ñ���ͼƬ����
//    public void addImageByRepaint() {
//        LogInPane imagePanel = new LogInPane(jFrame,frameSize, imageIcon.getImage());
//        setContentPane(imagePanel);
//        
//        //չʾ
//        setVisible(true);
//    }	
}
