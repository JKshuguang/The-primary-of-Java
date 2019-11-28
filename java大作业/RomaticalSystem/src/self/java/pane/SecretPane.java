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
	
	//�洢�Ѿ������˵�Itempane
	public  List<ItemCLass> list = new ArrayList<ItemCLass>();
	
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, d.width, d.height, this);
    }
	
	//��¼Itemģ����
	public static int no = 0;
	
	//�м����
	public static JPanel center_pane;
	
	/**
	 * Create the panel.
	 */
	public SecretPane(JFrame jFrame,Dimension d, Image image) {
		
        super();
        //�õ���ǰFrame
        this.jFrame = jFrame;
        this.d = d;
        this.image = image;
       
		//���ò���ΪBorderPane
		setLayout(new BorderLayout(0, 0));
		
		//�½���� ����Border���²�
		JPanel bottom = new JPanel();
		add(bottom, BorderLayout.SOUTH);
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//�½���ť��������һ��������
		lastStepButton = new JButton("��һ��");
		bottom.add(lastStepButton);
		
		//����һ����Ŀ
		addButton = new JButton("���");
		bottom.add(addButton);
		
		//ɾ����ť
		deleteButton = new JButton("ɾ��");
		bottom.add(deleteButton);
		
		//�½�һ��������border����
		/**
		 * ������ʾ��Ŀ��FlowLayout���
		 */
		center_pane = new JPanel();
		center_pane.setOpaque(false);
		add(center_pane, BorderLayout.CENTER);
		center_pane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//������Ӧ�¼�
		handleActionEvent();
		
		//�õ����ݿ������е�Item
		list = getItem();
		
		//չʾ����
		showList(list);


	}
	
	//�г����ݿ������е���Ŀ
	private void showList(List<ItemCLass> list2) {
		//����һ���µ�ItemPaneģ��
		ItemPane itemPane = null;
		itemPaneList = new ArrayList<ItemPane>();
		
		//���������е�ItemClass �õ����ݿ������е���Ŀ
		for (ItemCLass itemCLass : list2) {
			//ʵ����Itempane
			itemPane = new ItemPane(itemCLass.getNo(), itemCLass.getDes());
			
			//��ӵ�������
			itemPaneList.add(itemPane);
			
			//��ӵ�����ģ����
			center_pane.add(itemPane);
		}
		
	}

	//�õ�ItemClass����
	private List<ItemCLass> getItem() {
		
		List<ItemCLass> list = null;
		DaoTools dao = new DaoTools();
		
		//����SQL���
		String sql = "Select no,des from SecretTable";
		
		//�õ�List����
		list = dao.getList(ItemCLass.class, sql);		
		
		return list;
	}
	
	private void handleActionEvent() {
		//���� lastButton ����Ӧ�¼�
		lastStepButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�رշ�ǰFrame
				jFrame.setVisible(false);
				
				//�õ�����岢��ʾ
				//�õ�һ���µ�Jframe
				JFrameDemo newFrame = new JFrameDemo("");
				
				//����������
				newFrame.getContentPane().add(new MenuPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//չʾ������
				newFrame.setVisible(true);
				
			}
		});
		
		//������Ӱ�ť����Ӧ�¼�
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				//�õ�һ���µ�Jframe
				JFrameDemo newFrame = new JFrameDemo("C:\\Users\\����\\Desktop\\img\\secretPane.jpg");
				
				//����������
				newFrame.getContentPane().add(new AddSecretPane(jFrame,newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//չʾ������
				newFrame.setVisible(true);
				
				//ˢ�����
				//jFrame.setVisible(true);
				
			}
		});
		
		//����ɾ����ť����Ӧ�¼�
		deleteButton.addActionListener(new ActionListener() {
			
			DaoTools dao = new DaoTools();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//�õ�Ҫɾ����Ԫ�ؼ���
				
				for (ItemPane itemPane : itemPaneList) {
					
					//�õ���ѡ�е�no
					int no = 0;
					//���縴ѡ��ѡ�У���Ӽ�����ɾ��Ԫ��
					if (itemPane.isTrue) {
						System.out.println(1);
						 no = itemPane.getNo();
						 //�����ݿ���ɾ��Ԫ��
						 String sql = "delete from SecretTable where no = ?";
						 dao.update(sql, no);
					}

				}
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
	}

}
