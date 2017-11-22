package com.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Test {
		public static void main(String[] args) 
		{
			System.out.println(read());
		}
		
		public static int read() {
			FileReader fr = null;
			BufferedReader br = null;
			try {
				 fr = new FileReader("D:\\FairLok.java");
				 br = new BufferedReader(fr);
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
				return 2;
			} 
			catch (Exception e) {
				e.printStackTrace();
				return 3;
			}
			finally {
				try {
					if (fr != null) fr.close();
					if (br != null) br.close();
				}
				catch(IOException ioe) {
					System.out.println("hello");
				}
				//return 1;
			}
		}

}
