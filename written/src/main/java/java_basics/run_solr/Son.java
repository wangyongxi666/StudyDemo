package java_basics.run_solr;

/*
 * ����ĳ�ʼ��<clinit>��
 * ��1��j = method();
 * ��2������ľ�̬�����
 * 
 * �ȳ�ʼ�����ࣺ(5)(1)
 * ��ʼ�����ࣺ��10��(6)
 * 
 * �����ʵ��������<init>��
 * ��1��super()����ǰ��      ��9����3����2��
 * ��2��i = test();    ��9��
 * ��3������ķǾ�̬�����    ��8��
 * ��4��������޲ι��죨��� ��7��
 * 
 * ��Ϊ����������Son�������ʵ��������<init>ִ������
 * 
 * ��9����3����2����9����8����7��
 */
public class Son extends Father{
	private int i = test();
	private static int j = method();
	static{
		System.out.print("(6)");
	}
	Son(){
//		super();//д��д���ڣ������๹������һ������ø���Ĺ�����
		System.out.print("(7)");
	}
	{
		System.out.print("(8)");
	}
	public int test(){
		System.out.print("(9)");
		return 1;
	}
	public static int method(){
		System.out.print("(10)");
		return 1;
	}
	public static void main(String[] args) {
		Son s1 = new Son();
		System.out.println();
		Son s2 = new Son();
	}
}
