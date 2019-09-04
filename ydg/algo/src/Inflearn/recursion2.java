package Inflearn;

import java.util.Scanner;

public class recursion2 {
	//MAIN
	public static void main(String[] args) {
		//System.out.println(strLength("Hello"));
		//printChars("Hello");
		//printReversChars("Hello");
		//printBinary(16);
		
		int data[] = {1, 2, 3, 4};
		System.out.println(sum(4, data));
	}
	
	//문자열의 길이 계산
	public static int strLength(String str) {
		if(str.equals("")) return 0;
		return 1+ strLength(str.substring(1));
	}
	//문자열의 프린트
	public static void printChars(String str) {
		if(str.length()==0) return ;
		System.out.println(str.charAt(0));
		printChars(str.substring(1));
	}
	//문자열을 뒤집어 프린트
	public static void printReversChars(String str) {
		
//		if(str.length()!=0) {
//			System.out.println(str.charAt(str.length()-1));
//			printReversChars(str.substring(0, str.length()-1));
//		}
		if(str.length()==0) return;
		printReversChars(str.substring(1));
		System.out.println(str.charAt(0));
		
	}
	//2진수로 변환하여 출력
	public static void printBinary(int n) {
		if(n>2)printBinary(n/2);
		System.out.print(n<=2 ? 1 : n%2);
	}
	//정수합구하기
	public static int sum(int n, int[] data) {
		//data[0] ~ data[n-1]까지 합
		return n <= 0 ? 0 : data[n-1]+sum(n-1, data);
	}
	//데이터파일로부터 n개의 정수 읽어오기
	public void readForm(int n, int[] data, Scanner in) {
		if(n<=0) return;
		
		readForm(n-1, data, in);
		data[n-1] = in.nextInt();
		
	}
	
}









