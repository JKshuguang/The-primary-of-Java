package self.java.pane;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

import self.java.tools.DaoTools;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTouristPane extends JPanel {
	
	private JFrame jFrame;
	private JFrame lastFrame;
	
	private JTextField desField;
	private JTextField placeField;
	private JTextField picAddress;
	
	private JButton resetButton;
	private JButton commitButton;
	JButton picButton;
	
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
	public AddTouristPane(JFrame lastFrame,JFrame jFrame,Dimension d, Image image) {
		
        super();
        //�õ���ǰFrame
        this.jFrame = jFrame;
        this.d = d;
        this.image = image;
		
		//�õ���һ��frame
		this.lastFrame = lastFrame;
		
		//���ò���
		setLayout(new BorderLayout(0, 0));
		
		//������� ����ӵ�BorderLayout ����
		JPanel bottomPane = new JPanel();
		bottomPane.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		add(bottomPane, BorderLayout.SOUTH);
		//����pane1ΪflowPane
		bottomPane.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 5));
		
		//�������ð�ť
		resetButton = new JButton("�� ��");
		bottomPane.add(resetButton);
		
		//�����ύ��ť
		commitButton = new JButton("�� ��");
		bottomPane.add(commitButton);
		
		//��������Pane ����ΪBorder��ʽ
		JPanel centerPane = new JPanel();
		centerPane.setOpaque(false);
		add(centerPane, BorderLayout.NORTH);
		GridBagLayout gbl_centerPane = new GridBagLayout();
		gbl_centerPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_centerPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_centerPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_centerPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		centerPane.setLayout(gbl_centerPane);
		
		//���������ı� ��ʼ��
		JLabel desLabel = new JLabel("�� ��");
		GridBagConstraints gbc_desLabel = new GridBagConstraints();
		gbc_desLabel.insets = new Insets(0, 0, 5, 5);
		gbc_desLabel.anchor = GridBagConstraints.EAST;
		gbc_desLabel.gridx = 3;
		gbc_desLabel.gridy = 1;
		centerPane.add(desLabel, gbc_desLabel);
		
		//���������ı��� ��ʼ��
		desField = new JTextField();
		GridBagConstraints gbc_desField = new GridBagConstraints();
		gbc_desField.insets = new Insets(0, 0, 5, 0);
		gbc_desField.anchor = GridBagConstraints.WEST;
		gbc_desField.gridx = 4;
		gbc_desField.gridy = 1;
		centerPane.add(desField, gbc_desField);
		desField.setColumns(10);
		
		//�����ص㰴ť ��ʼ��
		JLabel placeLabel = new JLabel("�� ��");
		GridBagConstraints gbc_placeLabel = new GridBagConstraints();
		gbc_placeLabel.anchor = GridBagConstraints.EAST;
		gbc_placeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_placeLabel.gridx = 3;
		gbc_placeLabel.gridy = 2;
		centerPane.add(placeLabel, gbc_placeLabel);
		
		//�����ص��ı� ��ʼ��
		placeField = new JTextField();
		GridBagConstraints gbc_placeField = new GridBagConstraints();
		gbc_placeField.insets = new Insets(0, 0, 5, 0);
		gbc_placeField.anchor = GridBagConstraints.WEST;
		gbc_placeField.gridx = 4;
		gbc_placeField.gridy = 2;
		centerPane.add(placeField, gbc_placeField);
		placeField.setColumns(10);
		
		//������ͼ�ı� ��ʼ��
		JLabel beautifulImage = new JLabel("�� ͼ");
		GridBagConstraints gbc_beautifulImage = new GridBagConstraints();
		gbc_beautifulImage.anchor = GridBagConstraints.EAST;
		gbc_beautifulImage.insets = new Insets(0, 0, 0, 5);
		gbc_beautifulImage.gridx = 3;
		gbc_beautifulImage.gridy = 3;
		centerPane.add(beautifulImage, gbc_beautifulImage);
		
		//ͼƬ��ַ
		picAddress = new JTextField();
		GridBagConstraints gbc_picAddress = new GridBagConstraints();
		gbc_picAddress.anchor = GridBagConstraints.WEST;
		gbc_picAddress.gridx = 4;
		gbc_picAddress.gridy = 3;
		centerPane.add(picAddress, gbc_picAddress);
		picAddress.setColumns(10);
		
		//ͼƬ��ť
		picButton = new JButton("");
		add(picButton, BorderLayout.CENTER);

		//������Ӧ�¼�
		handleActionEvent();
	}
	private void handleActionEvent() {
		//����������Ӧ�¼�
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�����ı����
				desField.setText("");
				
				//��ַ�ı����
				placeField.setText("");
				
				//ͼƬ�ļ����
				placeField.setText("");
			}
		});
		
		
		//�����ύ��Ӧ�¼�
		commitButton.addActionListener(new ActionListener() {
			//����dao������
			DaoTools dao = new DaoTools();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//�õ������Ϣ
				//�õ����
				int no = ++TouristPane.no;
				//�õ�des
				String des = desField.getText().trim();
				//�õ�palce
				String place = placeField.getText().trim();
				//�õ�Image��ַ
				String add = picAddress.getText().trim();
				
				//дSQL
				String sql = "Insert into TouristTable values(?,?,?,?)";
				
				//ִ�и���
				dao.update(sql, no,des,place,add);
				
				//������������ItemPane
				ItemPane itemPane = new ItemPane(no,des);
				TouristPane.itemPaneList.add(itemPane);
				TouristPane.center_pane.add(itemPane);
				
				//�رյ�ǰFrame
				jFrame.setVisible(false);
				
				//ˢ����һ��TouristPane
				lastFrame.setVisible(true);
				
			}
		});
		
		//�������ͼƬ
		picButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//�õ���ַ
				String addString = picAddress.getText().trim();
				
				ImageIcon icon = new ImageIcon(addString);
				
				picButton.setIcon(icon);
				
				picButton.setHorizontalAlignment(SwingConstants.CENTER);
				

				picButton.setOpaque(true);//���ÿؼ��Ƿ�͸����trueΪ��͸����falseΪ͸��

				picButton.setContentAreaFilled(true);//����ͼƬ������ť���ڵ�����

				picButton.setMargin(new Insets(0, 0, 0, 0));//���ð�ť�߿�ͱ�ǩ����֮��ľ���

				picButton.setFocusPainted(false);//���������ť�ǲ��ǻ�ý���

				picButton.setBorderPainted(false);//�����Ƿ���Ʊ߿�

				picButton.setBorder(null);//���ñ߿�
				
			}
		});		
		
	}

}
