package sap1homework;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder resultMessage = new StringBuilder();
		
		System.out.println("Please enter 3 positive numbers.");
		int a = input.nextInt(), 
			b = input.nextInt(), 
			c = input.nextInt();
		if(a <= 0 || b <= 0 || c <= 0) {
			System.out.println("THOSE ARE NOT POSITIVE NUMBERS!");
			input.close();
			System.exit(-1);
		}
		
		resultMessage.append("Three lines with lengths of ");
		resultMessage.append(a);
		resultMessage.append(", ");
		resultMessage.append(b);
		resultMessage.append(" and ");
		resultMessage.append(c);
		
		if(isTriangle(a, b, c)) {
			resultMessage.append(" CAN make a triangle.\nThis triangle is");
			if(!isRightTriangle(a, b, c)) {
				resultMessage.append("n't");
			}
			resultMessage.append(" a right triangle\nThe area of this triangle is ");
			resultMessage.append(getArea(a, b, c));
			resultMessage.append(".");
		} else {
			resultMessage.append(" CAN'T make a triangle.");
		}
		
		System.out.println(resultMessage.toString());
		input.close();
	}

	public static boolean isTriangle(int a, int b, int c) {
		return a + b > c && a + c > b && b + c > a;
	}
	
	public static boolean isRightTriangle(int a, int b, int c) {
		// How can I easily find the biggest side and adjust the equation?
		return a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a;
	}
	
	public static double getArea(int a, int b, int c) {
		double p = (double)(a + b + c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}
}
