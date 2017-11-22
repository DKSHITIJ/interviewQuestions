package app2;

public class StringBasics {
	public static void main(String[] args) {
		String s1 = new String("A");
		String s2 = new String("A");

		if (s1 == s2) {
			System.out.println("references/identities are equal");
		}
		if (s1.equals(s2)) {
			System.out.println("values are equal");
		}

		String s3 = "A";
		String s4 = "A";
		if (s3 == s4) {
			System.out.println("references/identities are equal");
		}
		if (s3.equals(s4)) {
			System.out.println("values are equal");
		}
	}
}