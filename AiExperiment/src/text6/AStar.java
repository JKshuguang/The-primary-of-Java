package text6;



import java.util.ArrayList;

public class AStar {

	/** 

   * ʹ��ArrayList������Ϊ�������б��͡��ر��б� 

   */

	ArrayList<Node> open = new ArrayList<Node>();

	ArrayList<Node> close = new ArrayList<Node>();

	/** 

   * ��ȡHֵ 

   * @param currentNode����ǰ�ڵ� 

   * @param endNode���յ� 

   * @return 

   */

	public double getHValue(Node currentNode,Node endNode){

		return (Math.abs(currentNode.getX() - endNode.getX()) + Math.abs(currentNode.getY() - endNode.getY()))*10;

	}

	/** 

   * ��ȡGֵ 

   * @param currentNode����ǰ�ڵ� 

   * @return 

   */
	public double getGValue(Node currentNode){

		if(currentNode.getPNode()!=null){

			if(currentNode.getX()==currentNode.getPNode().getX()||currentNode.getY()==currentNode.getPNode().getY()){

				//�жϵ�ǰ�ڵ����丸�ڵ�֮���λ�ù�ϵ��ˮƽ���Խ��ߣ� 

				return currentNode.getGValue()+10;

			}

			return currentNode.getGValue()+14;

		}

		return currentNode.getGValue();

	}

	/** 

   * ��ȡFֵ �� G + H 

   * @param currentNode 

   * @return 

   */

	public double getFValue(Node currentNode){

		return currentNode.getGValue()+currentNode.getHValue();

	}

	/** 

   * ��ѡ�нڵ���Χ�Ľڵ���ӽ��������б� 

   * @param node 

   * @param map 

   */

	public void inOpen(Node node,Map map){

		int x = node.getX();

		int y = node.getY();

		for (int i = 0;i<3;i++){

			for (int j = 0;j<3;j++){

				//�ж�����Ϊ���ڵ�Ϊ�ɵ���ģ��������ϰ�����ڹر��б��У��������б��в�����������ѡ�нڵ� 

				if(map.getMap()[x-1+i][y-1+j].isReachable()&&!open.contains(map.getMap()[x-1+i][y-1+j])&&!(x==(x-1+i)&&y==(y-1+j))){

					map.getMap()[x-1+i][y-1+j].setPNode(map.getMap()[x][y]);

					//��ѡ�нڵ���Ϊ���ڵ� 

					map.getMap()[x-1+i][y-1+j].setGValue(getGValue(map.getMap()[x-1+i][y-1+j]));

					map.getMap()[x-1+i][y-1+j].setHValue(getHValue(map.getMap()[x-1+i][y-1+j],map.getEndNode()));

					map.getMap()[x-1+i][y-1+j].setFValue(getFValue(map.getMap()[x-1+i][y-1+j]));

					open.add(map.getMap()[x-1+i][y-1+j]);

				}

			}

		}

	}

	/** 

   * ʹ��ð�����򽫿����б��еĽڵ㰴Fֵ��С�������� 

   * @param arr 

   */

	public void sort(ArrayList<Node> arr){

		for (int i = 0;i<arr.size()-1;i++){

			for (int j = i+1;j<arr.size();j++){

				if(arr.get(i).getFValue() > arr.get(j).getFValue()){

					Node tmp = new Node();

					tmp = arr.get(i);

					arr.set(i, arr.get(j));

					arr.set(j, tmp);

				}

			}

		}

	}

	/** 

   * ���ڵ���ӽ����ر��б� 

   * @param node 

   * @param open 

   */

	public void inClose(Node node,ArrayList<Node> open){

		if(open.contains(node)){

			node.setReachable(false);

			//����Ϊ���ɴ� 

			open.remove(node);

			close.add(node);

		}

	}

	public void search(Map map){

		//����㼴�����Χ�Ľڵ���в��� 

		inOpen(map.getMap()[map.getStartNode().getX()][map.getStartNode().getY()],map);

		close.add(map.getMap()[map.getStartNode().getX()][map.getStartNode().getY()]);

		map.getMap()[map.getStartNode().getX()][map.getStartNode().getY()].setReachable(false);

		map.getMap()[map.getStartNode().getX()][map.getStartNode().getY()].setPNode(map.getMap()[map.getStartNode().getX()][map.getStartNode().getY()]);

		sort(open);

		//�ظ����� 

		do{

			inOpen(open.get(0), map);

			inClose(open.get(0), open);

			sort(open);

		}

		while(!open.contains(map.getMap()[map.getEndNode().getX()][map.getEndNode().getY()]));

		//֪�������б��а����յ�ʱ��ѭ���˳� 

		inClose(map.getMap()[map.getEndNode().getX()][map.getEndNode().getY()], open);

		showPath(close,map);

	}

	/** 

   * ��·����ǳ��� 

   * @param arr 

   * @param map 

   */

	public void showPath(ArrayList<Node> arr,Map map) {

		if(arr.size()>0){

			Node node = new Node();

			node = map.getMap()[map.getEndNode().getX()][map.getEndNode().getY()]; 

			while(!(node.getX() ==map.getStartNode().getX()&&node.getY() ==map.getStartNode().getY())){ 

			node.getPNode().setValue("*"); 

			node = node.getPNode(); 


			}


		}

	}
}
