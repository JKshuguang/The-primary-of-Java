package self.java.log;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import self.java.pane.MenuPane;
import self.java.pane.WrongPane;
import self.java.tools.JDBCTools;
import self.java.tools.JFrameDemo;
import self.java.tools.Tools;

public class LogInPane extends JPanel {
	
    Dimension d;
    Image image;
	
	private static JFrame jframe;
	private JTextField acountField;
	private JPasswordField passwordField;
	private JButton registerButton;
	private JButton resetButton;
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, d.width, d.height, this);
    }
	
	public LogInPane(JFrame frame,Dimension d, Image image) {
		
		
        super();
        //�õ���ǰFrame
        this.jframe = frame;
        this.d = d;
        this.image = image;
		
        //����ǰ��ɫ�ͱ���ɫ
		setForeground(Color.PINK);
		setBackground(Color.GRAY);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//�õ�һ��Grid����
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{200, 30, 30, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[] {80, 100, 30, 10, 0, 30, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		//����contendPane�Ĳ���ΪGridBagLayoutģʽ
		setLayout(gbl_contentPane);
		
		//�����˺��ı�
		JLabel userLabel = new JLabel("�� ��:");
		GridBagConstraints gbc_user = new GridBagConstraints();
		gbc_user.insets = new Insets(0, 0, 5, 5);
		gbc_user.gridx = 3;
		gbc_user.gridy = 2;
		add(userLabel, gbc_user);
		
		//�˺��ı���
		acountField = new JTextField();
		acountField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 2;
		add(acountField, gbc_textField);
		
		//���������ı�
		JLabel password = new JLabel("�� ��:");
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.insets = new Insets(0, 0, 5, 5);
		gbc_password.gridx = 3;
		gbc_password.gridy = 4;
		add(password, gbc_password);
				
		//���������
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);
				
		//���ð�ť
		resetButton = new JButton("�� ��");
		GridBagConstraints reset_button = new GridBagConstraints();
		reset_button.anchor = GridBagConstraints.EAST;
		reset_button.insets = new Insets(0, 0, 0, 5);
		reset_button.gridx = 3;
		reset_button.gridy = 6;
		add(resetButton, reset_button);
				
		//��¼��ť
		registerButton = new JButton("\u767B \u5F55");
		GridBagConstraints register_button = new GridBagConstraints();
		register_button.anchor = GridBagConstraints.EAST;
		register_button.gridx = 4;
		register_button.gridy = 6;
		add(registerButton, register_button);
		
		//���������¼�
		handleActionEvent();
	}
	

	//��������Ӧ�¼�
	private void handleActionEvent() {
		
		//�������ð�ť�ĵ�����Ӧ�¼�
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//�������÷���
				resetButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//�˺����
						acountField.setText("");
						
						//�������
						passwordField.setText("");
						
					}
				});
				
			}
		});
		
		//�����¼��ť�ĵ�����Ӧ�¼�
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//����˺������Ƿ���ȷ UPRight 
				boolean UPRight = false;
				
				//������ȷ��¼
				//�õ�������˺�����
				String acountString = acountField.getText().trim();
				String passString = passwordField.getText().trim();
				UPRight = checkAcount(acountString,passString);
				
				//����ȷ����ʾ��¼���� ����д�����
				
				if (UPRight) {
					//�رյ�ǰ���
					jframe.setVisible(false);
					
					//�õ�һ���µ�Jframe
					JFrameDemo newFrame = new JFrameDemo("");
					
					//����������
					newFrame.getContentPane().add(new MenuPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
					
					//չʾ������
					newFrame.setVisible(true);
				}else {
					//�õ�����������JFrame
					JFrame newFrame = Tools.getWrongPassFrame();
					
					//������
					newFrame.getContentPane().add(new WrongPane());
					
					//��ʾ����
					newFrame.setVisible(true);
					
				}
				
			}
			
			//����˺������Ƿ��Ӧ
			public boolean checkAcount(String count,String password) {
				//������Ҫ�õ��ı���
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet res = null;
				try {
					//�õ����ݿ�����
					conn = JDBCTools.getConnection();
					
					//дSQL
					String sql = "Select * from Acount Where userAcount = ? And userPassword = ?";
					
					//���ռλ��
					ps = conn.prepareStatement(sql);
					ps.setObject(1, count);
					ps.setObject(2, password);
					res = ps.executeQuery();
					
					//�ж��Ƿ��в�ѯ���
					if (res.next()) {
						//�˺������Ӧ
						return true;
					}else {
						//�˺����벻��Ӧ
						return false;
					}
					
				} catch (Exception e) {
					//��ӡ��ջ��Ϣ
					e.printStackTrace();
				} finally {
					//�ر���Դ
					JDBCTools.closeResource(conn, ps, res);
				}
				
				return false;
			}
		});
		
	}

}
