package test;

import java.util.ArrayList;
import java.util.List;

public class PlayGround {

	public static void main(String[] args) {
	
		/*
		int a [] = {2,15,21,24,25}; int b[] = {12,5,21,24};

		boolean isEqual = true;
		if(a.length == b.length) {
			for(int i = 0; i<a.length;i++) {
				if(a[i] !=b[i]) {
					isEqual = false;
					//System.out.println("array are equal");
					//System.out.println(a[i]);
				}
			}	
			}else {
			System.out.println("array are not equal");
		}
			
			if(isEqual == true) {
				System.out.println("array are equal");

			}else {
				System.out.println("array are not equal");

			} */
		
		String str = "Welcome to java";
		String [] words = str.split(" ");
		String reverseString = "";
//		for (String word : words) {
//			String reverseWord = "";
//			for(int i= word.length()-1; i>=0; i--) {
//				reverseWord += word.charAt(i);
//			}
//			reverseString += reverseWord+" ";
//		}
//		System.out.println("original String "+str);
//		System.out.println("Reversed String "+reverseString);
	for(String w:words)
	{
		String reverseWord = "";
		StringBuilder sb = new StringBuilder(w);
		reverseWord = sb.reverse().toString()+" ";
		System.out.print(reverseWord);
	}
	
	
		
		
	}
	
	private static int sum(int a)
	{
		int nums = a;
		int sum = 0;
		
		
		while(nums >0) {
			int rem = nums%10+sum;
			
			nums /= 10;
			sum = rem;
		}
		System.out.println("sum of nums = "+sum );
		
		return nums;
	}
	
	private static int count(int a)
	{
		int nums = a;
		int evenCount = 0;
		int oddCount = 0;
		
		while(nums >0) {
			int rem = nums%10;
			if(rem%2 == 0) {
				evenCount ++;
			}else {
				oddCount ++;
			}
			nums /= 10;
		}
		System.out.println("even nums = "+evenCount );
		System.out.println("odd nums = "+oddCount );
		return nums;
	}
	
	}
