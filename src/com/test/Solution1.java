package com.test;

import java.util.Arrays;

public class Solution1 {
	public static void main(String[] args) {
		int[] a = { 1, 5, 3, 4, 2 };
		pairs(a, 2);
	}

	static int pairs(int[] numbers, int k) {
		/* Complete this function 
		int temp;
		int lengthOfArray = numbers.length;
		int count = 0;
		int start;
		int mid;
		int end;
		int midValue;
		Arrays.sort(numbers);
		for (int i = 0; i < lengthOfArray - 1; i++) {
			temp = numbers[i] + k;
			start = i + 1;
			end = lengthOfArray - 1;
			for (int l = start; l < lengthOfArray; l++) {
				mid = (start + end) / 2;
				midValue = numbers[mid];
				if (midValue == temp) {
					count++;
					break;
				} else if (midValue > temp) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}

		}
		//System.out.println(count);
		return count;*/
		
		int temp;
	    int length=numbers.length;
	    int count=0;
	    Arrays.sort(numbers);
	    for(int i=0;i<length;i++){
	    temp=numbers[i];
	        for(int j=i+1;j<length;j++){
	            if(temp-numbers[j]==-k){
	                count++;
	                break;
	            }
	        }
	    }
	    System.out.println(count);
	    return count;
	}
}
