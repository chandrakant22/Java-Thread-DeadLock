
class A
{
	public synchronized void funA(B b)
	{
		System.out.println("Start of funA of Class A");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		b.lastB();
	}
	
	public synchronized void lastA()
	{
		System.out.println("Start of LastA of Class A");
	}
}


class B
{
	public synchronized void funB(A a)
	{
		System.out.println("Start of funB of Class B");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a.lastA();
	}
	
	public synchronized void lastB()
	{
		System.out.println("Start of LastB of Class B");
	}
}




public class Test extends Thread{
	
	A a=new A();
	B b=new B();
	
	
	void demo()
	{
		this.start();
		a.funA(b);
	}
	
	@Override
	public void run() {
		b.funB(a);
	}

	

	public static void main(String[] args) {
		
		Test t=new Test();
		t.demo();
		
	
	}

}
