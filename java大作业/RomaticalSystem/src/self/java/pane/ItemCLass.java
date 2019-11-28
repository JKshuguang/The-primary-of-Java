package self.java.pane;

public class ItemCLass {
	
	private int no;
	
	private String des;

	public ItemCLass() {
		super();
	}

	public ItemCLass(int no, String des) {
		super();
		this.no = no;
		this.des = des;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Override
	public String toString() {
		return "ItemCLass [no=" + no + ", des=" + des + "]";
	}
	
	
	
}
