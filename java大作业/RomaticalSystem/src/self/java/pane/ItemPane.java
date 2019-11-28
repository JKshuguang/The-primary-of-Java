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
	//���
	private int no = 0;
	
	public boolean isTrue = false;
	
	//��ѡ��
	private JCheckBox chckBox;
	

	//�����ı�
	JLabel desLabel = null;
	
	//�˽���ఴť
	JButton LearnMoreButton;
	/**
	 * Create the panel.
	 */
	public ItemPane(int no,String des) {
		this.no = no;
		
		setBorder(new CompoundBorder());
		//���ò���ΪFlowLayout������
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		
		//��ѡ��
		chckBox = new JCheckBox("");
		add(chckBox);
		
		//�����ı�
		desLabel = new JLabel(des);
		add(desLabel);
		
		//�˽����İ�ť
		LearnMoreButton = new JButton("click to know more");
		add(LearnMoreButton);
		
		setOpaque(false);
		
		//������Ӧ�¼�
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

				//�õ�һ���µ�Jframe
				JFrameDemo newFrame = new JFrameDemo("C:\\Users\\����\\Desktop\\img\\end.jpg");
				
				//����������
				newFrame.getContentPane().add(new EndPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//չʾ������
				newFrame.setVisible(true);
				
			}
		});

	}
	//�õ���ѡ��
	
	public JCheckBox getChckBox() {
		return chckBox;
	}
	
	//���ø�ѡ��
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
