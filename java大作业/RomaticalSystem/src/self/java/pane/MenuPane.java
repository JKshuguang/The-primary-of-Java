package self.java.pane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import self.java.tools.JFrameDemo;
import self.java.tools.Tools;

public class MenuPane extends JPanel {
	
    Dimension d;
    Image image;
	
	//记录上一个Jframe
	JFrame jFrame;

	//秘密按钮
	JButton secretButton;
	
	//承诺按钮
	JButton promiseButton;
	
	//旅游按钮
	JButton touristButton;
	
	//美食按钮
	JButton foodsButton;
	
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, d.width, d.height, this);
    }
	
	/**
	 * Create the panel.
	 */
	public MenuPane(JFrame jFrame,Dimension d, Image image) {
        super();
        //得到当前Frame
        this.jFrame = jFrame;
        this.d = d;
        this.image = image;
        
		//得到上一个Jframe
		this.jFrame = jFrame;
		
		//设置布局为Border布局
		setLayout(new BorderLayout(0, 0));
		
		//右半部分布局
		JSplitPane splitPane_right = new JSplitPane();
		add(splitPane_right, BorderLayout.EAST);
		
		//安防 秘密 模块在右半部分布局的左侧
		String  add = "C:\\Users\\即客\\Desktop\\img\\secret.png";
		secretButton = getAButton(add);
		splitPane_right.setLeftComponent(secretButton);
		
		//安置 承诺 模块在右半部分布局的右侧
		add = "C:\\Users\\即客\\Desktop\\img\\promise.png";
		promiseButton = getAButton(add);
		splitPane_right.setRightComponent(promiseButton);
	
		//左半部分布局
		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.WEST);
		
		//安置 旅游 模块在左半部分布局的左侧
		add = "C:\\Users\\即客\\Desktop\\img\\Tourist.png";
		touristButton =  getAButton(add);
		splitPane.setLeftComponent(touristButton);
		
		//安置 美食 模块在左半部分布局的右侧
		add = "C:\\Users\\即客\\Desktop\\img\\Food.png";
		foodsButton = getAButton(add);
		splitPane.setRightComponent(foodsButton);
		

		
		//处理响应事件
		handleActionEvent();

	}
	
	
	
	//得到一个按钮
	public static JButton getAButton(String addString) {
		ImageIcon icon = new ImageIcon(addString);
		JButton newButton = new JButton(icon);
	
		newButton.setHorizontalAlignment(SwingConstants.CENTER);
		

		newButton.setOpaque(true);//设置控件是否透明，true为不透明，false为透明

		newButton.setContentAreaFilled(true);//设置图片填满按钮所在的区域

		newButton.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		newButton.setFocusPainted(false);//设置这个按钮是不是获得焦点

		newButton.setBorderPainted(false);//设置是否绘制边框

		newButton.setBorder(null);//设置边框
		
		return newButton;
	}
	
	private void handleActionEvent() {
		
		//处理秘密按钮的单击响应事件
		secretButton.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				//关闭房前Frame
				jFrame.setVisible(false);
				
				//得到一个新的Jframe
				JFrameDemo newFrame = new JFrameDemo("C:\\Users\\即客\\Desktop\\img\\secretPane2.png");
				
				//进入主界面
				newFrame.getContentPane().add(new SecretPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//展示主界面
				newFrame.setVisible(true);
			}
		});
				
		//处理承诺按钮的单击响应事件
		promiseButton.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				//关闭房前Frame
				jFrame.setVisible(false);
				
				//得到一个新的Jframe
				JFrameDemo newFrame = new JFrameDemo("C:\\Users\\即客\\Desktop\\img\\promisePane.jpg");
				
				//进入主界面
				newFrame.getContentPane().add(new PromisePane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//展示主界面
				newFrame.setVisible(true);
			}
		});
		
		//处理旅游按钮的单击响应事件
		touristButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//关闭房前Frame
				jFrame.setVisible(false);
				
				//得到一个新的Jframe
				JFrameDemo newFrame = new JFrameDemo("C:\\Users\\即客\\Desktop\\img\\touristPane.jpg");
				
				//进入主界面
				newFrame.getContentPane().add(new TouristPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//展示主界面
				newFrame.setVisible(true);
				
			}
		});
//		
		//处理美食按钮的单击响应事件
		foodsButton.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				//关闭房前Frame
				jFrame.setVisible(false);
				
				//得到一个新的Jframe
				JFrameDemo newFrame = new JFrameDemo("C:\\Users\\即客\\Desktop\\img\\foodPane2.jpg");
				
				//进入主界面
				newFrame.getContentPane().add(new FoodsPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//展示主界面
				newFrame.setVisible(true);
			}
		});
	}

}
