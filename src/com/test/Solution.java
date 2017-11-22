package com.test;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

class Solution {

	public static void main(String[] argh) {
		try {
			FileInputStream fstream = new FileInputStream("c:\\textfile.txt");
			// BufferedReader br = new BufferedReader(new
			// InputStreamReader(fstream));

			String strLine;
			// while ((strLine = br.readLine()) != null) {
			Scanner sc = new Scanner(fstream);
			//Scanner sc = new Scanner(System.in);

			Stack stack = new Stack();
			while (sc.hasNext()) {
				boolean bal = false;
				String input = sc.next();
				// Complete the code
				//if (input.length() % 2 == 0) {
				stack.clear();
					for (int i = 0; i < input.length(); i++) {
						char c = input.charAt(i);
						if (c == '(' || c == '[' || c == '{')
							stack.push(input.charAt(i));
						else if (c == ')' || c == ']' || c == '}') {
							char d = ((Character) stack.pop()).charValue();
							if ((c == ')' && d != '(') || (c == ']' && d != '[') || (c == '}' && d != '{')) {
								bal = false;
							    break;
							}
							
						} else {
							bal = false;
							break;
						}
					}
				//}
				 if(input.length() == 0)
					bal = true;
				
				if(!stack.empty())
					bal = false;
				System.out.println(bal);
			}
			// }
		} catch (Exception e) {
			System.out.println("some problem");
		}
	}
	
	/*import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Scanner;


	public class TestScanner {

	    public static void main(String[] args) throws FileNotFoundException {
	        Scanner scanner = new Scanner(new File("/Users/pankaj/abc.csv"));
	        scanner.useDelimiter(",");
	        while(scanner.hasNext()){
	            System.out.print(scanner.next()+"|");
	        }
	        scanner.close();
	    }

	}*/
}