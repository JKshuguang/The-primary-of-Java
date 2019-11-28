package self.java.pane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import self.java.tools.DaoTools;
import self.java.tools.JFrameDemo;
import self.java.tools.Tools;

public class SecretPane extends JPanel {
	private JFrame jFrame;
	private JButton addButton;
	private JButton lastStepButton;
	private JButton deleteButton;
	
    Dimension d;
    Image image;
    
	public  static List<ItemPane> itemPaneList = new ArrayList<ItemPane>();
	
	//存储已经创建了的Itempane
	public  List<ItemCLass> list = new ArrayList<ItemCLass>();
	
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, d.width, d.height, this);
    }
	
	//记录Item模块数
	public static int no = 0;
	
	//中间面板
	public static JPanel center_pane;
	
	/**
	 * Create the panel.
	 */
	public SecretPane(JFrame jFrame,Dimension d, Image image) {
		
        super();
        //得到当前Frame
        this.jFrame = jFrame;
        this.d = d;
        this.image = image;
       
		//设置布局为BorderPane
		setLayout(new BorderLayout(0, 0));
		
		//新建面板 放在Border的下部
		JPanel bottom = new JPanel();
		add(bottom, BorderLayout.SOUTH);
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//新建按钮，返回上一界面作用
		lastStepButton = new JButton("上一步");
		bottom.add(lastStepButton);
		
		//新增一个条目
		addButton = new JButton("添加");
		bottom.add(addButton);
		
		//删除按钮
		deleteButton = new JButton("删除");
		bottom.add(deleteButton);
		
		//新建一个面板放在border中央
		/**
		 * 用于显示条目的FlowLayout面板
		 */
		center_pane = new JPanel();
		center_pane.setOpaque(false);
		add(center_pane, BorderLayout.CENTER);
		center_pane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//处理响应事件
		handleActionEvent();
		
		//得到数据库中已有的Item
		list = getItem();
		
		//展示条款
		showList(list);


	}
	
	//列出数据库中已有的条目
	private void showList(List<ItemCLass> list2) {
		//创建一个新的ItemPane模板
		ItemPane itemPane = null;
		itemPaneList = new ArrayList<ItemPane>();
		
		//遍历集合中的ItemClass 得到数据库中已有的条目
		for (ItemCLass itemCLass : list2) {
			//实例化Itempane
			itemPane = new ItemPane(itemCLass.getNo(), itemCLass.getDes());
			
			//添加到集合中
			itemPaneList.add(itemPane);
			
			//添加到中心模板中
			center_pane.add(itemPane);
		}
		
	}

	//得到ItemClass集合
	private List<ItemCLass> getItem() {
		
		List<ItemCLass> list = null;
		DaoTools dao = new DaoTools();
		
		//设置SQL语句
		String sql = "Select no,des from SecretTable";
		
		//得到List集合
		list = dao.getList(ItemCLass.class, sql);		
		
		return list;
	}
	
	private void handleActionEvent() {
		//处理 lastButton 的响应事件
		lastStepButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//关闭房前Frame
				jFrame.setVisible(false);
				
				//得到新面板并显示
				//得到一个新的Jframe
				JFrameDemo newFrame = new JFrameDemo("");
				
				//进入主界面
				newFrame.getContentPane().add(new MenuPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//展示主界面
				newFrame.setVisible(true);
				
			}
		});
		
		//处理添加按钮的响应事件
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				//得到一个新的Jframe
				JFrameDemo newFrame = new JFrameDemo("C:\\Users\\即客\\Desktop\\img\\secretPane.jpg");
				
				//进入主界面
				newFrame.getContentPane().add(new AddSecretPane(jFrame,newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//展示主界面
				newFrame.setVisible(true);
				
				//刷新面板
				//jFrame.setVisible(true);
				
			}
		});
		
		//处理删除按钮的响应事件
		deleteButton.addActionListener(new ActionListener() {
			
			DaoTools dao = new DaoTools();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//得到要删除的元素集合
				
				for (ItemPane itemPane : itemPaneList) {
					
					//得到被选中的no
					int no = 0;
					//假如复选框被选中，则从集合中删除元素
					if (itemPane.isTrue) {
						System.out.println(1);
						 no = itemPane.getNo();
						 //从数据库中删除元素
						 String sql = "delete from SecretTable where no = ?";
						 dao.update(sql, no);
					}

				}
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
	}

}
