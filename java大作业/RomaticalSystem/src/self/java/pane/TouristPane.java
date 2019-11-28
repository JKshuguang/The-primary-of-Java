package self.java.pane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
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

public class TouristPane extends JPanel {

	
	private JFrame jFrame;
	private JButton addButton;
	private JButton lastStepButton;
	private JButton deleteButton;
	
	public  static List<ItemPane> itemPaneList = new ArrayList<ItemPane>();
	
	//�洢�Ѿ������˵�Itempane
	public  List<ItemCLass> list = new ArrayList<ItemCLass>();
	
	//��Ŀ���
	public static int no = 0;
	
	//�м����
	public static JPanel center_pane;
	
	
	
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
	public TouristPane(JFrame jFrame,Dimension d, Image image) {
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
		
		
		//�õ����ݿ������е�Item
		list = getItem();
		
		//չʾ���� ���õ�һ��ItemPane�ļ���
		showList(list);
		
		//������Ӧ�¼�
		handleActionEvent();

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
		String sql = "Select no,description des from TouristTable";
		
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
				
				JFrameDemo newFrame = new JFrameDemo("C:\\Users\\����\\Desktop\\img\\touristPane2.jpg");
				
				//����������
				newFrame.getContentPane().add(new AddTouristPane(jFrame,newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//չʾ������
				newFrame.setVisible(true);
				

				
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
						//�õ�Ҫɾ���ı��
						 no = itemPane.getNo();
						 
						 //�����ݿ���ɾ��Ԫ��
						 String sql = "delete from TouristTable where no = ?";
						 dao.update(sql, no);
					}

				}
				//�رշ�ǰFrame
				jFrame.setVisible(false);
				
				//�õ�һ���µ�Jframe
				JFrameDemo newFrame = new JFrameDemo("C:\\Users\\����\\Desktop\\img\\touristPane.jpg");
				
				//����������
				newFrame.getContentPane().add(new TouristPane(newFrame,newFrame.getFrameSize(),newFrame.getImageIcon().getImage()));
				
				//չʾ������
				newFrame.setVisible(true);
	
				
			}
		});
	}

}
