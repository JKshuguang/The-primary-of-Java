package self.java.log;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import self.java.pane.MenuPane;

public class Test extends JFrame {

	private MenuPane menuPane;
	static Test jFrame;
	
    Dimension frameSize = new Dimension(800, 500);
    ImageIcon imageIcon = new ImageIcon(
            "C:\\Users\\����\\Desktop\\img\\login_background2.jpg");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
//		jFrame = new Test();
//		jFrame.addImageByRepaint();
//		JButton jButton = new JButton("d");
//		JLabel jLabel = new JLabel(new ImageIcon("C:\\Users\\����\\Desktop\\img\\login_background.jpg"));
//		jLabel.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
//		System.out.println(jFrame.getWidth());
////		jFrame.add(jLabel);
//		//jButton.setIcon(new ImageIcon("C:\\Users\\����\\Desktop\\img\\heart.jpg"));
//		jFrame.add(jButton);
//		jButton.setBounds(0,0,150,100);
		//jFrame.setVisible(true);
		
		JbuttonText();
		
		
	}

	private static void JbuttonText() {
		
		JFrame aJFrame = new JFrame();

		JPanel contentPanel = new JPanel();

		contentPanel.setBackground(Color.BLACK);

		aJFrame.setContentPane(contentPanel);

		ImageIcon icon = new ImageIcon("C:\\Users\\����\\Desktop\\img\\secretImage.jpg");

	 

		JButton enter = new JButton("This is a button", icon);

	 

	        enter.setBounds(900, 380, 380, 270);

	        enter.setHorizontalTextPosition(SwingConstants.CENTER);
	        

	        enter.setOpaque(false);//���ÿؼ��Ƿ�͸����trueΪ��͸����falseΪ͸��

	        enter.setContentAreaFilled(false);//����ͼƬ������ť���ڵ�����

	        enter.setMargin(new Insets(0, 0, 0, 0));//���ð�ť�߿�ͱ�ǩ����֮��ľ���

	        enter.setFocusPainted(false);//���������ť�ǲ��ǻ�ý���

	        enter.setBorderPainted(false);//�����Ƿ���Ʊ߿�

	        enter.setBorder(null);//���ñ߿�

		

	        contentPanel.add(enter);

	        
	        aJFrame.setVisible(true);

		
	}

	/**
	 * Create the frame.
	 */
	public Test() {
        setSize(frameSize);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(imageIcon.getImage());
        setUndecorated(true);
    }
	
    public void addImageByRepaint() {
        LogInPane imagePanel = new LogInPane(jFrame,frameSize, imageIcon.getImage());
        setContentPane(imagePanel);

        setVisible(true);
    }
    
//    private void addComponents() {
//        JButton btn1 = new JButton("haha");
//        btn1.setBounds(10, 20, 60, 30);
//        this.getContentPane().add(btn1);
//
//        JTextField jtf = new JTextField("22222222222");
//        jtf.setBounds(200, 100, 80, 30);
//        this.getContentPane().add(jtf);
//
//    }

}
