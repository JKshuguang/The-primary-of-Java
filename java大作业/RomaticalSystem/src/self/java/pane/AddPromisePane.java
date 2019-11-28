package self.java.pane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.xml.soap.Detail;

import self.java.tools.DaoTools;

public class AddPromisePane extends JPanel {
	private JFrame jFrame;
	private JFrame lastFrame;
	
	private JTextField desField;
	private JTextField dateField;
	private JTextPane detailText;
	
	private JButton resetButtom;
	private JButton commitButton;
	
    Dimension d;
    Image image;
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, d.width, d.height, this);
    }
	

	/**
	 * Create the panel.
	 */
	public AddPromisePane(JFrame lastFrame,JFrame jFrame,Dimension d, Image image) {
		
        super();
        //�õ���ǰFrame
        this.jFrame = jFrame;
        this.d = d;
        this.image = image;
		
		//�õ���һ��frame
		this.lastFrame = lastFrame;
		
		//���ò���
		setLayout(new BorderLayout(0, 0));
		
		//������� ������Border��
		JPanel bottomPane = new JPanel();
		add(bottomPane, BorderLayout.SOUTH);
		//�ײ�����ΪFLOWLayout
		bottomPane.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 5));
		
		//�������ð�ť
		resetButtom = new JButton("reset");
		bottomPane.add(resetButtom);
		
		//�����ύ��ť
		commitButton = new JButton("commit");
		bottomPane.add(commitButton);
		
		//�����������
		JPanel centerPane = new JPanel();
		centerPane.setOpaque(false);
		add(centerPane, BorderLayout.CENTER);
		GridBagLayout gbl_centerPane = new GridBagLayout();
		gbl_centerPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_centerPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_centerPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_centerPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		centerPane.setLayout(gbl_centerPane);
		
		//�������������ı� ��ʼ��
		JLabel dataLabel = new JLabel("\u65E5 \u671F\uFF1A");
		GridBagConstraints gbc_dataLabel = new GridBagConstraints();
		gbc_dataLabel.anchor = GridBagConstraints.EAST;
		gbc_dataLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dataLabel.gridx = 2;
		gbc_dataLabel.gridy = 1;
		centerPane.add(dataLabel, gbc_dataLabel);
		
		//���������� ��ʼ��
		dateField = new JTextField();
		GridBagConstraints gbc_dateField = new GridBagConstraints();
		gbc_dateField.anchor = GridBagConstraints.WEST;
		gbc_dateField.insets = new Insets(0, 0, 5, 0);
		gbc_dateField.gridx = 3;
		gbc_dateField.gridy = 1;
		centerPane.add(dateField, gbc_dateField);
		dateField.setColumns(10);
		
		//���������ı� ��ʼ��
		JLabel desLabel = new JLabel("\u63CF \u8FF0\uFF1A");
		GridBagConstraints gbc_desLabel = new GridBagConstraints();
		gbc_desLabel.insets = new Insets(0, 0, 5, 5);
		gbc_desLabel.anchor = GridBagConstraints.EAST;
		gbc_desLabel.gridx = 2;
		gbc_desLabel.gridy = 2;
		centerPane.add(desLabel, gbc_desLabel);
		
		//��������Field ��ʼ��
		desField = new JTextField();
		GridBagConstraints gbc_desField = new GridBagConstraints();
		gbc_desField.insets = new Insets(0, 0, 5, 0);
		gbc_desField.anchor = GridBagConstraints.WEST;
		gbc_desField.gridx = 3;
		gbc_desField.gridy = 2;
		centerPane.add(desField, gbc_desField);
		desField.setColumns(10);
		
		//�������������ı� ��ʼ��
		JLabel detailLabel = new JLabel("\u7EC6 \u8282\uFF1A");
		GridBagConstraints gbc_detailLabel = new GridBagConstraints();
		gbc_detailLabel.anchor = GridBagConstraints.EAST;
		gbc_detailLabel.insets = new Insets(0, 0, 0, 5);
		gbc_detailLabel.gridx = 2;
		gbc_detailLabel.gridy = 3;
		centerPane.add(detailLabel, gbc_detailLabel);
		
		//������������Text ��ʼ��
		detailText = new JTextPane();
		GridBagConstraints gbc_detailText = new GridBagConstraints();
		gbc_detailText.fill = GridBagConstraints.BOTH;
		gbc_detailText.gridx = 3;
		gbc_detailText.gridy = 3;
		centerPane.add(detailText, gbc_detailText);
		
		//��������Ӧ�¼�
		handleActionEvent();

	}

	private void handleActionEvent() {

		//�����ύ������Ӧ�¼�
		commitButton.addActionListener(new ActionListener() {
			
			DaoTools dao = new DaoTools();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//�õ���ر���
				int no = ++PromisePane.no;
				String desString = desField.getText().trim();
				String detailString = detailText.getText().trim();
				String dateString = dateField.getText().trim();
				
				//дSQL
				String sql = "Insert into PromiseTable values(?,?,?,?)";
				
				//ִ��SQL
				dao.update(sql, no,desString,detailString,dateString);
				
				//������������ItemPane
				ItemPane itemPane = new ItemPane(no,desString);
				PromisePane.itemPaneList.add(itemPane);
				PromisePane.center_pane.add(itemPane);
				
				//�رյ�ǰFrame
				jFrame.setVisible(false);
				
				//ˢ����һ��TouristPane
				lastFrame.setVisible(true);
				
				
			}
		});
		
		//�������õ�����Ӧ�¼�
		resetButtom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//�����ı����
				desField.setText("");
				
				//�����ı����
				dateField.setText("");
				
				//���������ı����
				detailText.setText("");
				
				
			}
		});

	}

}
