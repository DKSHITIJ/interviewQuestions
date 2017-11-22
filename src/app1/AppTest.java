package app1;

class ClassX
{
	public long dData;
	public ClassX next;

	public ClassX(long dd) {
		dData = dd;
	}
	public void display() {
		System.out.print(dData + " ");
	}
} 
class ClassY
{
	private ClassX first;

	public ClassY() {
		first = null;
	}
	public boolean check() {
		return (first == null);
	}
	public void functionA(long key) {
		ClassX x = new ClassX(key);
		ClassX pr = null;
		ClassX cr = first;
		while (cr != null && key > cr.dData) { 
			pr = cr;
			cr = cr.next;
		}
		if (pr == null)
			first = x;
		else
			pr.next = x;
		x.next = cr;
	} 

	public ClassX functionB() {
		ClassX temp = first;
		first = first.next;
		return temp;
	}

	public void show() {
		ClassX current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
	}
} 
class AppTest {
	public static void main(String[] args) {
		ClassY list = new ClassY();
		list.functionA(20);
		list.functionA(40);
		list.functionA(10);
		list.functionA(30);
		list.functionA(50);
		list.functionB();
		list.show();
	}
}

