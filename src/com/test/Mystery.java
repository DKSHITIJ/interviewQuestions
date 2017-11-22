package com.test;

public class Mystery {
 private static Mystery ins = null;
 
 protected Mystery() {}
 
 public static Mystery getins() {
	 return ins;
 }
}
