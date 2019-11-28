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
	
	//��¼��һ��Jframe
	JFrame jFrame;

	//���ܰ�ť
	JButton secretButton;
	
	//��ŵ��ť
	JButton promiseButton;
	
	//���ΰ�ť
	JButton touristButton;
	
	//��ʳ��ť
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
        //�õ���ǰFrame
        this.jFrame = jFrame;
        this.d = d;
        this.image = image;
        
		//�õ���һ��Jframe
		this.jFrame = jFrame;
		
		//���ò���ΪBorder����
		setLayout(new BorderLayout(0, 0));
		
		//�Ұ벿�ֲ���
		JSplitPane splitPane_right = new JSplitPane();
		add(splitPane_right, BorderLayout.EAST);
		
		//���� ���� ģ�����Ұ벿�ֲ��ֵ����
		String  add = "C:\\Users\\����\\Desktop\\img\\secret.png";
		secretButton = getAButton(add);
		splitPane_right.setLeftComponent(secretButton);
		
		//���� ��ŵ ģ�����Ұ벿�ֲ��ֵ��Ҳ�
		add = "C:\\Users\\����\\Desktop\\img\\promise.png";
		promiseButton = getAButton(add);
		splitPane_right.setRightComponent(promiseButton);
	
		//��벿�ֲ���
		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.WEST);
		
		//���� ���� ģ������벿�ֲ��ֵ����
		add = "C:\\Users\\����\\Desktop\\img\\Tourist.png";
		touristButton =  getAButton(add);
		splitPane.setLeftComponent(touristButton);
		
		//���� ��ʳ ģ������벿�ֲ��ֵ��Ҳ�
		add = "C:\\Users\\����\\Desktop\\img\\Food.png";
		foodsButton = getAButton(add);
		splitPane.setRightComponent(foodsButton);
		

		
		//������Ӧ�¼�
		handleActionEvent();

	}
	
	
	
	//�õ�һ����ť
	public static JButton getAButton(String addString) {
		ImageIcon icon = new ImageIcon(addString);
		JButton newButton = new JButton(icon);
	
		newButton.setHorizontalAlignment(SwingConstants.CENTER);
		

		newButton.setOpaque(true);//���ÿؼ��Ƿ�͸����trueΪ��͸����falseΪ͸��

		newButton.setContentAreaFilled(true);//����ͼƬ������ť���ڵ�����

		newButton.setMargin(new Insets(0, 0, 0, 0));//���ð�ť�߿�ͱ�ǩ����֮��ľ���

		newButton.setFocusPainted(false);//���������ť�ǲ��ǻ�ý���

		newButton.setBorderPainted(false);//�����Ƿ���Ʊ߿�

		newButton.setBorder(null);//���ñ߿�
		
		return newButton;
	}
	
	private void handleActionEvent() {
		
		//�������ܰ�ť�ĵ�����Ӧ�¼�
		secretButton.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				//�رշ�ǰFrame
				jFrame.setVisible(false);
				
				//�õ�һ���µ�Jframe
				JFrameDemo newFrame = new JFrameDemo("C:\\Users\\����\\Desktop\\img\\secretPane2.png");
				
				//����������
				newFrame.getContentPane().add(new SecretPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//չʾ������
				newFrame.setVisible(true);
			}
		});
				
		//�����ŵ��ť�ĵ�����Ӧ�¼�
		promiseButton.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				//�رշ�ǰFrame
				jFrame.setVisible(false);
				
				//�õ�һ���µ�Jframe
				JFrameDemo newFrame = new JFrameDemo("C:\\Users\\����\\Desktop\\img\\promisePane.jpg");
				
				//����������
				newFrame.getContentPane().add(new PromisePane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//չʾ������
				newFrame.setVisible(true);
			}
		});
		
		//�������ΰ�ť�ĵ�����Ӧ�¼�
		touristButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�رշ�ǰFrame
				jFrame.setVisible(false);
				
				//�õ�һ���µ�Jframe
				JFrameDemo newFrame = new JFrameDemo("C:\\Users\\����\\Desktop\\img\\touristPane.jpg");
				
				//����������
				newFrame.getContentPane().add(new TouristPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//չʾ������
				newFrame.setVisible(true);
				
			}
		});
//		
		//������ʳ��ť�ĵ�����Ӧ�¼�
		foodsButton.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				//�رշ�ǰFrame
				jFrame.setVisible(false);
				
				//�õ�һ���µ�Jframe
				JFrameDemo newFrame = new JFrameDemo("C:\\Users\\����\\Desktop\\img\\foodPane2.jpg");
				
				//����������
				newFrame.getContentPane().add(new FoodsPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//չʾ������
				newFrame.setVisible(true);
			}
		});
	}

}
