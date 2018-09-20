package josephcircle;

import java.util.Scanner;


class Node{
	private Object data;
	private Node next;
	public Node(Object data) {
		this.data=data;
	}
	public Object getData() {
		return data;
	}
	public Node getNext() {
		return next;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}
public class SingleLink{
	private Node head;
	private Node point;//记录当前节点
	private int curlength;
	//新增节点,在最后添加
	public void add(Node node) {
		if(head==null) {
			this.head=node;
			this.point=node;
		}else {
			this.point.setNext(node);
			this.point=node;
		}
		this.curlength++;
	}
	//返回长度
	public int Linklength() {
		return this.curlength;
	}
	public void deleteDataByData(Node node,Object data) {
		if(data.equals(this.head.getData())) {
			this.head=this.head.getNext();
			curlength--;
			return;
		}
		if(data.equals(node.getNext().getData())) {
			node.setNext(node.getNext().getNext());
			curlength--;
			return;
		}
		deleteDataByData(node.getNext(), data);
	}
	public void deleteData(Object data) {
		deleteDataByData(this.head, data);
		//return;
	}
	//形成循环链表
	public void madeCircleLink() {
		this.point.setNext(head);
	}
	//约瑟夫函数
	public void josephFunction(int point) {
		Node node=head;
		Node aidnode=node;
		while(curlength!=0) {
			for(int i=1;i<point;i++) {
				node=node.getNext();
				aidnode=node;
			}
			node=node.getNext();
			System.out.print(aidnode.getData()+" ");
			deleteData(aidnode.getData());
		}
	}
	public static void main(String []args) {
		SingleLink singlelink=new SingleLink();
		System.out.println("请输入人数：");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		System.out.println("请输入轮回数：");
		int point=sc.nextInt();
		for(int i=0;i<num;i++) {
			singlelink.add(new Node(i+1));
		}
		singlelink.madeCircleLink();
		singlelink.josephFunction(point);
	}
}

