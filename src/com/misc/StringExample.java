package com.misc;

public class StringExample {
	public static void main(String args[]) {
		String str = "1,2,3,4,5";
		String str1 = "10,50,20,-10,20,30,40, - 20, -20, -20";
		String[] spl = str.split("//s*,//s*");
		for(int i = 0; i< spl.length; i++)
		{
			System.out.println(spl[i]);
		}
	}
}
