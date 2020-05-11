package java_basics.run_solr;

/*
 * ����ĳ�ʼ��<clinit>��
 * ��1��j = method();
 * ��2������ľ�̬�����
 * 
 *  �����ʵ����������
 * ��1��super()����ǰ��
 * ��2��i = test();
 * ��3������ķǾ�̬�����
 * ��4��������޲ι��죨���
 * 
 * �Ǿ�̬����ǰ����ʵ��һ��Ĭ�ϵĶ���this
 * this�ڹ���������<init>������ʾ�������ڴ����Ķ�����Ϊ�������ڴ���Son��������
 * test()ִ�е���������д�Ĵ��루��������̬��
 * 
 * ����i=test()ִ�е���������д��test()����
 */
public class Father{
	private int i = test();
	private static int j = method();
	
	static{
		System.out.print("(1)");
	}
	Father(){
		System.out.print("(2)");
	}
	{
		System.out.print("(3)");
	}
	
	
	public int test(){
		System.out.print("(4)");
		return 1;
	}
	public static int method(){
		System.out.print("(5)");
		return 1;
	}
}