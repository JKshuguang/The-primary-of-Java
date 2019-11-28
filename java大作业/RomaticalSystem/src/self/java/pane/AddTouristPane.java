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
        //得到当前Frame
        this.jFrame = jFrame;
        this.d = d;
        this.image = image;
		
		//得到上一个frame
		this.lastFrame = lastFrame;
		
		//设置布局
		setLayout(new BorderLayout(0, 0));
		
		//创建面板 并添加到BorderLayout 下面
		JPanel bottomPane = new JPanel();
		bottomPane.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		add(bottomPane, BorderLayout.SOUTH);
		//设置pane1为flowPane
		bottomPane.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 5));
		
		//创建重置按钮
		resetButton = new JButton("重 置");
		bottomPane.add(resetButton);
		
		//创建提交按钮
		commitButton = new JButton("提 交");
		bottomPane.add(commitButton);
		
		//创建中心Pane 设置为Border形式
		JPanel centerPane = new JPanel();
		centerPane.setOpaque(false);
		add(centerPane, BorderLayout.NORTH);
		GridBagLayout gbl_centerPane = new GridBagLayout();
		gbl_centerPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_centerPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_centerPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_centerPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		centerPane.setLayout(gbl_centerPane);
		
		//创建秒速文本 初始化
		JLabel desLabel = new JLabel("描 述");
		GridBagConstraints gbc_desLabel = new GridBagConstraints();
		gbc_desLabel.insets = new Insets(0, 0, 5, 5);
		gbc_desLabel.anchor = GridBagConstraints.EAST;
		gbc_desLabel.gridx = 3;
		gbc_desLabel.gridy = 1;
		centerPane.add(desLabel, gbc_desLabel);
		
		//创建描述文本域 初始化
		desField = new JTextField();
		GridBagConstraints gbc_desField = new GridBagConstraints();
		gbc_desField.insets = new Insets(0, 0, 5, 0);
		gbc_desField.anchor = GridBagConstraints.WEST;
		gbc_desField.gridx = 4;
		gbc_desField.gridy = 1;
		centerPane.add(desField, gbc_desField);
		desField.setColumns(10);
		
		//创建地点按钮 初始化
		JLabel placeLabel = new JLabel("地 点");
		GridBagConstraints gbc_placeLabel = new GridBagConstraints();
		gbc_placeLabel.anchor = GridBagConstraints.EAST;
		gbc_placeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_placeLabel.gridx = 3;
		gbc_placeLabel.gridy = 2;
		centerPane.add(placeLabel, gbc_placeLabel);
		
		//创建地点文本 初始化
		placeField = new JTextField();
		GridBagConstraints gbc_placeField = new GridBagConstraints();
		gbc_placeField.insets = new Insets(0, 0, 5, 0);
		gbc_placeField.anchor = GridBagConstraints.WEST;
		gbc_placeField.gridx = 4;
		gbc_placeField.gridy = 2;
		centerPane.add(placeField, gbc_placeField);
		placeField.setColumns(10);
		
		//创建美图文本 初始化
		JLabel beautifulImage = new JLabel("美 图");
		GridBagConstraints gbc_beautifulImage = new GridBagConstraints();
		gbc_beautifulImage.anchor = GridBagConstraints.EAST;
		gbc_beautifulImage.insets = new Insets(0, 0, 0, 5);
		gbc_beautifulImage.gridx = 3;
		gbc_beautifulImage.gridy = 3;
		centerPane.add(beautifulImage, gbc_beautifulImage);
		
		//图片地址
		picAddress = new JTextField();
		GridBagConstraints gbc_picAddress = new GridBagConstraints();
		gbc_picAddress.anchor = GridBagConstraints.WEST;
		gbc_picAddress.gridx = 4;
		gbc_picAddress.gridy = 3;
		centerPane.add(picAddress, gbc_picAddress);
		picAddress.setColumns(10);
		
		//图片按钮
		picButton = new JButton("");
		add(picButton, BorderLayout.CENTER);

		//处理响应事件
		handleActionEvent();
	}
	private void handleActionEvent() {
		//处理重置响应事件
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//描述文本清空
				desField.setText("");
				
				//地址文本清空
				placeField.setText("");
				
				//图片文件清空
				placeField.setText("");
			}
		});
		
		
		//处理提交响应事件
		commitButton.addActionListener(new ActionListener() {
			//创建dao工具类
			DaoTools dao = new DaoTools();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//得到相关信息
				//得到编号
				int no = ++TouristPane.no;
				//得到des
				String des = desField.getText().trim();
				//得到palce
				String place = placeField.getText().trim();
				//得到Image地址
				String add = picAddress.getText().trim();
				
				//写SQL
				String sql = "Insert into TouristTable values(?,?,?,?)";
				
				//执行更新
				dao.update(sql, no,des,place,add);
				
				//给简单描述生成ItemPane
				ItemPane itemPane = new ItemPane(no,des);
				TouristPane.itemPaneList.add(itemPane);
				TouristPane.center_pane.add(itemPane);
				
				//关闭当前Frame
				jFrame.setVisible(false);
				
				//刷新上一个TouristPane
				lastFrame.setVisible(true);
				
			}
		});
		
		//处理添加图片
		picButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//得到地址
				String addString = picAddress.getText().trim();
				
				ImageIcon icon = new ImageIcon(addString);
				
				picButton.setIcon(icon);
				
				picButton.setHorizontalAlignment(SwingConstants.CENTER);
				

				picButton.setOpaque(true);//设置控件是否透明，true为不透明，false为透明

				picButton.setContentAreaFilled(true);//设置图片填满按钮所在的区域

				picButton.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

				picButton.setFocusPainted(false);//设置这个按钮是不是获得焦点

				picButton.setBorderPainted(false);//设置是否绘制边框

				picButton.setBorder(null);//设置边框
				
			}
		});		
		
	}

}
