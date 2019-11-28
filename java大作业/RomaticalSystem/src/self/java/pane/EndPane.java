package self.java.pane;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import self.java.tools.JFrameDemo;

import java.awt.BorderLayout;
import javax.swing.JButton;

public class EndPane extends JPanel {

	private static JFrame jframe;
    Dimension d;
    Image image;
    
    //��ť
    JButton button;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, d.width, d.height, this);
    }
    

    
	/**
	 * Create the panel.
	 */
	public EndPane(JFrame frame,Dimension d, Image image) {

        super();
        //�õ���ǰFrame
        this.jframe = frame;
        this.d = d;
        this.image = image;
        setLayout(new BorderLayout(0, 0));
        
        button = new JButton("�������˵�");
        add(button, BorderLayout.SOUTH);
        
        //��������Ӧ�¼�
        handleActionEvent();		
		
	}


//������Ӧ�¼�
	private void handleActionEvent() {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�رշ�ǰFrame
				jframe.setVisible(false);
				
				//�õ�һ���µ�Jframe
				JFrameDemo newFrame = new JFrameDemo("");
				
				//����������
				newFrame.getContentPane().add(new MenuPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//չʾ������
				newFrame.setVisible(true);				
			}
		});
	}

}
