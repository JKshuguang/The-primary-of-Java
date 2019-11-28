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
            "C:\\Users\\即客\\Desktop\\img\\login_background2.jpg");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
//		jFrame = new Test();
//		jFrame.addImageByRepaint();
//		JButton jButton = new JButton("d");
//		JLabel jLabel = new JLabel(new ImageIcon("C:\\Users\\即客\\Desktop\\img\\login_background.jpg"));
//		jLabel.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
//		System.out.println(jFrame.getWidth());
////		jFrame.add(jLabel);
//		//jButton.setIcon(new ImageIcon("C:\\Users\\即客\\Desktop\\img\\heart.jpg"));
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

		ImageIcon icon = new ImageIcon("C:\\Users\\即客\\Desktop\\img\\secretImage.jpg");

	 

		JButton enter = new JButton("This is a button", icon);

	 

	        enter.setBounds(900, 380, 380, 270);

	        enter.setHorizontalTextPosition(SwingConstants.CENTER);
	        

	        enter.setOpaque(false);//设置控件是否透明，true为不透明，false为透明

	        enter.setContentAreaFilled(false);//设置图片填满按钮所在的区域

	        enter.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

	        enter.setFocusPainted(false);//设置这个按钮是不是获得焦点

	        enter.setBorderPainted(false);//设置是否绘制边框

	        enter.setBorder(null);//设置边框

		

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
