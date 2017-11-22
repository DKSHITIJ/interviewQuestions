package app2;

public class Example1 {
	private final String name;

	Example1(String name) {
		this.name = name;
	}

	private String name() {
		return name;
	}

	private void reproduce() {
		new Example1("reproduce") {
			void printName() {
				System.out.println(name());
			}
		}.printName();
	}

	public static void main(String[] args) {
		new Example1("main").reproduce();
	}
}

