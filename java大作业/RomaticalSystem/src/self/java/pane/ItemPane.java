package self.java.pane;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import javafx.event.ActionEvent;
import self.java.tools.JFrameDemo;

public class ItemPane extends JPanel {
	//编号
	private int no = 0;
	
	public boolean isTrue = false;
	
	//复选框
	private JCheckBox chckBox;
	

	//描述文本
	JLabel desLabel = null;
	
	//了解更多按钮
	JButton LearnMoreButton;
	/**
	 * Create the panel.
	 */
	public ItemPane(int no,String des) {
		this.no = no;
		
		setBorder(new CompoundBorder());
		//设置布局为FlowLayout，居中
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		
		//复选框
		chckBox = new JCheckBox("");
		add(chckBox);
		
		//描述文本
		desLabel = new JLabel(des);
		add(desLabel);
		
		//了解更多的按钮
		LearnMoreButton = new JButton("click to know more");
		add(LearnMoreButton);
		
		setOpaque(false);
		
		//处理响应事件
		handleActionEvent();

	}
	//
	private void handleActionEvent() {
		chckBox.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if (chckBox.isSelected() ) {
					isTrue = true;
				}else {
					isTrue = false;
				}
				
			}
		});
		
		LearnMoreButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {

				//得到一个新的Jframe
				JFrameDemo newFrame = new JFrameDemo("C:\\Users\\即客\\Desktop\\img\\end.jpg");
				
				//进入主界面
				newFrame.getContentPane().add(new EndPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//展示主界面
				newFrame.setVisible(true);
				
			}
		});

	}
	//得到复选框
	
	public JCheckBox getChckBox() {
		return chckBox;
	}
	
	//设置复选框
	public void setChckBox(JCheckBox chckBox) {
		this.chckBox = chckBox;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}

}
