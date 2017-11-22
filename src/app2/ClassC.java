package app2;

class ClassA {
	public static void show() {
		System.out.print("ClassA ");
	}
}

class ClassB extends ClassA {
	public static void show() {
		System.out.print("ClassB ");
	}
}

public class ClassC {
	public static void main(String args[]) {
		ClassA classA = new ClassA();
		ClassA classB = new ClassB();
		classA.show();
		classB.show();
	}
}

