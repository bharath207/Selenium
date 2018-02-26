package Practise;

public class B  extends A{
	void testB()
	{

		testA();
	System.out.println("B2");
	}
	void testC()
	{
	System.out.println("C2");
	}
		public static void main(String[] args) {
			B b1=new B();
			b1.testA(); 
			((A)b1).testB(); 
             ((B) b1).testC();
			B b2=new B();
			A a1=b2;
			a1.testA();
			a1.testB();
		((B) a1).testC();
		}
}
