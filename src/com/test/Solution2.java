package com.test;

public class Solution2 {
	public static void main(String[] args) {
		// input 351 output 1
		// input 451 output 2
		// input 366 output 3
		minNum(3, 6, 6);
	}

	static int minNum(int A, int K, int P) {
		int ashaStart = 0;
		int kellyStart = 0;
		int noOfDays = 0;
		while (ashaStart + P >= kellyStart) {
			kellyStart = kellyStart + K;
			ashaStart = ashaStart + A;
			noOfDays = noOfDays + 1;
		}
		System.out.println(noOfDays);
		return noOfDays;
	}
}
