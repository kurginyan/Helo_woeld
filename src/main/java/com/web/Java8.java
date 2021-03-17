package com.web;

import java.util.Arrays;
import java.util.List;


interface Parser {
	String pars(String s);
}

class MyPrinter {
	public void print(String s, Parser p) {
		System.out.println(p.pars(s));
	}
}

class StringParser {
	public static String convert(String s) {
		return s+" is the best";
	}

	public static String someOtherFunction(int i) {
		return i+" is the best";
	}
}

class someClass {
	public String convert(String s) {
		return s+" is the best";
	}
}

// https://www.youtube.com/watch?v=svQKKg3aFzo&list=PLsyeobzWxl7qbvNnJKjYbkTLn2w3eRy1Q&index=10
public class Java8 {

	public static void main(String[] args){
		List<String> names = Arrays.asList("Lyova", "Zara", "Hamlet", "Alex");

		MyPrinter mp = new MyPrinter();

		// anonymous class with direct logic implementation
		mp.print(names.get(0), new Parser() {
			public String pars(String s) {
				return s+" is the best"; // logic implementation
				//return StringParser.convert(s); indirect logic implementation
			}
		});

		//lambda expression with direct in line logic
		for (String name : names) {
			mp.print(name, s -> s+" is the best");
		}

		//lambda expression with direct logic in a cde block
		for (String name : names) {
			mp.print(name, s -> {
				String b =  "is the bets";
				return s+b;
			});
		}

		//lambda expression with indirect logic
		for (String name : names) {
			mp.print(name, s -> StringParser.convert(s) ); //logic is coming from static method of StringParser class
			//mp.print(name, s -> someMethod(s) ); // can also came from private method)
		}

		//method reference (with external public method )
		for (String name : names) {
			mp.print(name, StringParser::convert);
		}

		//method reference (with internal private method )
		for (String name : names) {
			mp.print(name, Java8::someMethod);
		}

	}


	private static String someMethod(String s){
		return s+" is the best";
	}
}
