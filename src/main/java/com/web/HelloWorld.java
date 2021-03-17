package com.web;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HelloWorld {

	static String text = "asddsasdsghjhgrtyytrdfghjkkjhgfdqwertyuiopoiuytrewqsdffdsxcvvcxbnmmnbfghhgfzxcvbnmmnbvcxzqwertyuioppoiuytrewq";
	public static void main(String[] args) throws Exception {
//		findPolindrom(text);
//
//		ReadExcelRows.main(new String[]{});

		System.out.println(solution("the quick brown dog jumps over the lazy dog",39)+"xxx");

	}


	public static String solution(String message, int k){
		if (k > message.length()){
			return message;
		}

		String nextChar = ""+message.charAt(k);
		String result = message.substring(0,k);

		if (" ".equals(nextChar)){
			return result;
		}

		int lastSpace = result.lastIndexOf(' ');
		result = result.substring(0, lastSpace);
		result = result.trim();
		return result;
	}


	private static String findPolindrom(String str) {

		char[] arr =  str.toCharArray();
		int length =  arr.length;

		int[] polindromCoordinats = new int[]{0,0};
		for(int i = 1; i < arr.length-1; i++){
			int[] results = isPolindrom(arr, i, i);
			polindromCoordinats = setLargestPolindrom(polindromCoordinats, results);

			results = isPolindrom(arr, i+1, i);
			polindromCoordinats = setLargestPolindrom(polindromCoordinats, results);
		}
		return str.substring(polindromCoordinats[0],polindromCoordinats[1]+1);
	}

	private static int[] setLargestPolindrom(int[] polindromCoordinats, int[] resulrs) {
		if (resulrs[0]==-1) return polindromCoordinats;

		if (resulrs[1] - resulrs[0] > polindromCoordinats[1] - polindromCoordinats[0]) {
			polindromCoordinats = resulrs;
			System.out.println(text.substring(polindromCoordinats[0],polindromCoordinats[1]+1));
		}
		return polindromCoordinats;
	}

	private static int[] isPolindrom(char[] arr, int toTail, int toHead) {
		if ((toTail==arr.length||toHead<0)||arr[toTail]!=arr[toHead]){
			return new int[]{-1};
		}
		int[] returnValues = isPolindrom(arr, toTail+1,toHead-1);
		if (returnValues[0]==-1){
			return new int[]{toHead,toTail};
		}else{
			return returnValues;
		}
	}

	private static String isPolindrom(String str, int toTail, int toHead) {
		if ((toTail==str.length()||toHead<0)||str.charAt(toTail)!=str.charAt(toHead)){
			return null;
		}

		String returnValues = isPolindrom(str, toTail+1,toHead-1);
		if (returnValues==null){
			return str.substring(toHead,toTail);
		}else{
			return returnValues;
		}
	}




}
