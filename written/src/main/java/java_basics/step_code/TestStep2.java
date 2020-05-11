package java_basics.step_code;


public class TestStep2 {
	public void test(){
		long start = System.currentTimeMillis();
		System.out.println(loop(100));//165580141
		long end = System.currentTimeMillis();
		System.out.println(end-start);//<1ms
	}
	
	public int loop(int n){
		if(n<1){
			throw new IllegalArgumentException(n + "����С��1");
		}
		if(n==1 || n==2){
			return n;
		}
		
		int one = 2;//��ʼ��Ϊ�ߵ��ڶ���̨�׵��߷�
		int two = 1;//��ʼ��Ϊ�ߵ���һ��̨�׵��߷�
		int sum = 0;
		
		for(int i=3; i<=n; i++){
			//����2�� + ����1�����߷�
			sum = two + one;
			two = one;
			one = sum;
		}
		return sum;
	}
}
