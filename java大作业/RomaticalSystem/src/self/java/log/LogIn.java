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
		
		//�õ�������
		jFrame = new JFrameDemo("C:\\Users\\����\\Desktop\\img\\login_background4.jpg");
		
		//��ʼ����¼�������
		LogInPane imagePanel = new LogInPane(jFrame,jFrame.getFrameSize(), jFrame.getImageIcon().getImage());
		
		//��ӵ�¼���浽��������
		jFrame.setContentPane(imagePanel);
		
		//��ʾ
		jFrame.setVisible(true);
		
	}

	/**
	 * Create the frame.
	 */
	public LogIn() {
		//��������С
        setLocationRelativeTo(null);
        
        //����Ĭ�Ϲر�ģʽ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
    }
	
//	//��д���ñ���ͼƬ����
//    public void addImageByRepaint() {
//        LogInPane imagePanel = new LogInPane(jFrame,frameSize, imageIcon.getImage());
//        setContentPane(imagePanel);
//        
//        //չʾ
//        setVisible(true);
//    }
    

}
