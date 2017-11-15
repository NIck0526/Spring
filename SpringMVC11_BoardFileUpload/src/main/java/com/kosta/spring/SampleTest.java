package com.kosta.spring;

import java.util.Scanner;

public class SampleTest{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		int A, B, C;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		int a = (A+B)%C;
		int b = (A%C + B%C)%C;
		int c =  (A*B)%C;
		int d =  (A%C * B%C)%C;
		System.out.println(a + "\n" +b + "\n" +c + "\n"+d + "\n");
		
		
	}
}