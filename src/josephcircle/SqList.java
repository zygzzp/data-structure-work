package josephcircle;

import java.util.Arrays;
import java.util.Scanner;

interface List{
	//清空表
	public void clear();
	//判断是否为空
	public boolean isEmpty();
	//取表的长度
	public int getLength();
	//取表元素
	public Object get(int i) throws Exception;
	//插入元素
	public void insert(int i,Object x) throws Exception;
	//删除元素
	public void delete(int i) throws Exception;
	//查找
	public int find(Object x);
	//遍历显示
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
//		return "年龄："+age+" 姓名："+name+" 身高："+height;
//	}
//	
//}
public class SqList implements List{
	//初始化顺序表
	private int curlength;//当前长度
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
		//最佳写法：return curlength==0
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		
		return curlength;
	}

	@Override
	public Object get(int i) throws Exception {
		// TODO Auto-generated method stub
		//先判断i是否合法、
		if(i<0||i>curlength-1) {
			throw new Exception("下标为"+i+"的元素的位置错误！");//抛出后不会执行此方法内这行下面的语句
		}	
		return list[i];
	}

	@Override
	public void insert(int i, Object x) throws Exception {
		// TODO Auto-generated method stub
		if(curlength==list.length) {
			throw new Exception("表已满！");	
		}
		if(i<0||i>curlength) {
			throw new Exception("插入位置非法");
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
			throw new Exception("删除位置非法");//抛出后不会执行此方法内这行下面的语句
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
		System.out.println("请输入人数：");
		int num=sc.nextInt();
		System.out.println("请指定轮回数7：");
		int point=sc.nextInt();
		SqList mylist=new SqList(num);
		for(int i=1;i<=num;i++) {
			mylist.insert(i-1, i);
		}
		mylist.josephFunction(point);
	}
}











