package josephcircle;

import java.util.Arrays;
import java.util.Scanner;

interface List{
	//��ձ�
	public void clear();
	//�ж��Ƿ�Ϊ��
	public boolean isEmpty();
	//ȡ��ĳ���
	public int getLength();
	//ȡ��Ԫ��
	public Object get(int i) throws Exception;
	//����Ԫ��
	public void insert(int i,Object x) throws Exception;
	//ɾ��Ԫ��
	public void delete(int i) throws Exception;
	//����
	public int find(Object x);
	//������ʾ
	public void show();
	
}
//class Student{
//	private int age;
//	private String name;
//	private double height;
//	public Student(int age, String name, double height) {
//		super();
//		this.age = age;
//		this.name = name;
//		this.height = height;
//	}
//	@Override
//	public String toString() {
//		return "���䣺"+age+" ������"+name+" ��ߣ�"+height;
//	}
//	
//}
public class SqList implements List{
	//��ʼ��˳���
	private int curlength;//��ǰ����
	public Object[] list;
	public SqList(int maxlength) {
		curlength=0;
		list=new Object[maxlength];
	}
	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		curlength=0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(curlength==0) {
			return true;
		}
		else {
			return false;
		}
		//���д����return curlength==0
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		
		return curlength;
	}

	@Override
	public Object get(int i) throws Exception {
		// TODO Auto-generated method stub
		//���ж�i�Ƿ�Ϸ���
		if(i<0||i>curlength-1) {
			throw new Exception("�±�Ϊ"+i+"��Ԫ�ص�λ�ô���");//�׳��󲻻�ִ�д˷�����������������
		}	
		return list[i];
	}

	@Override
	public void insert(int i, Object x) throws Exception {
		// TODO Auto-generated method stub
		if(curlength==list.length) {
			throw new Exception("��������");	
		}
		if(i<0||i>curlength) {
			throw new Exception("����λ�÷Ƿ�");
		}
		for(int j=curlength;j>i;j--) {
			list[j]=list[j-1];
		}
		list[i]=x;
		curlength++;
		
	}

	@Override
	public void delete(int i) throws Exception {
		// TODO Auto-generated method stub
		if(i<0||i>curlength-1) {
			throw new Exception("ɾ��λ�÷Ƿ�");//�׳��󲻻�ִ�д˷�����������������
		}
		for(int j=i;j<curlength-1;j++) {
			list[j]=list[j+1];
		}
		curlength--;
	}

	@Override
	public int find(Object x) {
		int j=0;
		while(j<curlength&&!list[j].equals(x)) {
			j++;
		}
		if(j<curlength) {
			return j;
			
		}else {
			return -1;
		}
		// TODO Auto-generated method stub
		
	}
	public void josephFunction(int point) throws Exception {
		int count=0;
		while(curlength!=0) {
			for(int i=1;i<point;i++) {
				count=(count+1)%(curlength);
				if(i==point-1) {
					System.out.print(get(count)+" ");
					delete(count);
				}			
			}
		}
	}
	public void show() {
		// TODO Auto-generated method stub
		for(int j=0;j<curlength;j++) {
			System.out.println(list[j]);
		}
	}
	public static void main(String []args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("������������");
		int num=sc.nextInt();
		System.out.println("��ָ���ֻ���7��");
		int point=sc.nextInt();
		SqList mylist=new SqList(num);
		for(int i=1;i<=num;i++) {
			mylist.insert(i-1, i);
		}
		mylist.josephFunction(point);
	}
}











