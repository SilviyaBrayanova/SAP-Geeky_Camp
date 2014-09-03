package sap1homework;

import java.util.Scanner;

public class FibonacciSearcher {
	static final double PHI = 1.618033988749895;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder resultMessage = new StringBuilder();
		
		System.out.println("Please enter a positive integer.");
		int number = input.nextInt();
		if(number < 0) {
			System.out.println("THIS IS NOT A POSITIVE NUMBER!");
			input.close();
			System.exit(-1);
		}
		
		resultMessage.append(number);
		if(isFibonacci(number)) {
			resultMessage.append(" is F");
			resultMessage.append(getFibonacciIndex(number));
		} else {
			resultMessage.append(" is not a Fibonacci number");
		}
		
		System.out.println(resultMessage.toString());
		input.close();
	}

	public static boolean isPerfectSquare(int number) {
		return Math.sqrt(number)%1 == 0;
	}
	
	public static boolean isFibonacci(int x) {
		return isPerfectSquare(5*x*x + 4) || isPerfectSquare(5*x*x - 4);
	}
	
	public static double logCustomBase(double number, double base) {
		return Math.log(number) / Math.log(base);
	}
	
	public static int getFibonacciIndex(int x) {
		return (int)logCustomBase(x * Math.sqrt(5) + 0.5, PHI);
	}
}
