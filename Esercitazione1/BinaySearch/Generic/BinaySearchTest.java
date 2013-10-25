package BinaySearch.Generic;

import java.util.ArrayList;

import BinaySearch.Generic.*;;

public class BinaySearchTest {
	public static <T> void main(String[]args){
		
		ArrayList <Integer>a = new ArrayList<Integer>();
		for(int i=0;i<10;i++)a.add(i);
		System.out.println(BinarySearch.find(5, a));
		System.out.println(BinarySearch.isPresent(232, a));
		System.out.println(BinarySearch.findRecursively(6, a));
	}
}
