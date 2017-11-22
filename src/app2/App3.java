package app2;

class App3
{
	public static void main(String[] args) {
		int[] arrayA = { 23, 47, 81, 95 };
		int[] arrayB = { 7, 14, 39, 55, 62, 74 };
		int[] arrayC = new int[10];
		func(arrayA, 4, arrayB, 6, arrayC);
		show(arrayC, 10);
	}

	public static void func(int[] arrayA, int x, int[] arrayB, int y,
			int[] arrayC) {
		int a = 0, b = 0, c = 0;
		while (a < x && b < y)
			if (arrayA[a] < arrayB[b]) {
				arrayC[c++] = arrayA[a++];
			}	
			else {
				arrayC[c++] = arrayB[b++];
			}	
		while (a < x) {
			arrayC[c++] = arrayA[a++];
		}	
		while (b < y) {
			arrayC[c++] = arrayB[b++];
		}	
	}

	public static void show(int[] theArray, int x) {
		for (int j = 0; j < x; j++)
			System.out.print(theArray[j] + " ");
		System.out.println("");
	}
}

