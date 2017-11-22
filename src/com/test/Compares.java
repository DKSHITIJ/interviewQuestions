package com.test;

import java.util.*;
public class Compares
{
    public static void main( String args[])
    {
        String[] cities = {"Bangalore","Pune","San Francisco","New York City"};
        MySort ms = new MySort();
        Arrays.sort(cities, ms);
        System.out.println(Arrays.binarySearch(cities, "New York City"));
    }
    static class MySort implements Comparator
    {
		@Override
		public int compare(Object arg0, Object arg1) {
			// TODO Auto-generated method stub
			String a = (String) arg0;
			String b = (String) arg1;
			return b.compareTo(a);
		}

		
    }
}