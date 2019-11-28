package self.java.tools;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Tools {

	public static JFrame getFrame() {
		//�õ���Ļ���
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension = tk.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;
		
		//�������Ͻ�λ��
		int x = (width - 720)/2;
		int y = (height - 500)/2;
		
		//������Frame�͹رշ�ʽ
		JFrame newFrame = new JFrame();
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.setBounds(x, y, 720, 500);
		
		//���ɸı䴰�ڴ�С
		newFrame.setResizable(false);
		
		return newFrame;
	}
	
	public static JFrame getWrongPassFrame() {
		//�õ���Ļ���
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension = tk.getScreenSize();
		int width = dimension.width;
		int height = dimension.height;
		
		//�������Ͻ�λ��
		int x = (width - 450 + 300)/2;
		int y = (height - 300 + 150)/2;
		
		//������Frame�͹رշ�ʽ
		JFrame newFrame = new JFrame();
		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newFrame.setBounds(x, y, 160, 100);
		
		//���ɸı䴰�ڴ�С
		newFrame.setResizable(false);
		
		return newFrame;
	}
}
