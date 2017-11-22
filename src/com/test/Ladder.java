package com.test;

 public class Ladder { 
     public static void main(String[] args) { 
         try { 
             System.out.println(doStuff(args)); 
         } 
         catch (Exception e) { System.out.println("exc"); } 
         doStuff(args); 
         
         Mystery my = new Mystery();
         
     }
     static int doStuff(String[] args) { 
         return Integer.parseInt("dfdf"); 
     }
 }