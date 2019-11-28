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
    
    //按钮
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
        //得到当前Frame
        this.jframe = frame;
        this.d = d;
        this.image = image;
        setLayout(new BorderLayout(0, 0));
        
        button = new JButton("返回主菜单");
        add(button, BorderLayout.SOUTH);
        
        //处理单击响应事件
        handleActionEvent();		
		
	}


//处理响应事件
	private void handleActionEvent() {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//关闭房前Frame
				jframe.setVisible(false);
				
				//得到一个新的Jframe
				JFrameDemo newFrame = new JFrameDemo("");
				
				//进入主界面
				newFrame.getContentPane().add(new MenuPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//展示主界面
				newFrame.setVisible(true);				
			}
		});
	}

}
