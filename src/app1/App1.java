package app1;

public class App1 {
	static int nDisks = 4;

	public static void main(String[] args) {
		recursive(nDisks, 'A', 'B', 'C');
	}

	public static void recursive(int topN, char from, char inter, char to) {
		if (topN == 1) {
			System.out.println("Disk 1 from " + from + " to " + to);
		} else {
			recursive(topN - 1, from, to, inter);
			System.out.println("Disk " + topN + " from " + from + " to " + to);
			recursive(topN - 1, inter, from, to);
		}
	}
}
