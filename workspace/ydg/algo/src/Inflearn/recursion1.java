package Inflearn;

public class recursion1 {
	public static void main(String[] args) {
		int result = 0;
		result = func(4);
		
		result = factorial(4);
		
		result = fibonacci(5);
		System.out.println(result);
	}
	
	public static int func(int k) {
		if(k<=0) return 0;
		
		return k + func(k-1);
	}
	
	public static int factorial(int k) {
		if(k<=1) return 1;
		return k * factorial(k-1);
	}
	
	public static int fibonacci(int k) {
		if(k<2) return k;
		return fibonacci(k-1) + fibonacci(k-2);
	}
	
	public static double gcd(int m, int n) {
		/*
		 *  유클리디안 - 최대공약수
		 *  - m>=n인 두 양의 정수에 대해서 m이 n의 배수이면 gcd(m,n) = n이고,
		 *  - 아니면 gcd(m,n) = gcd(n, m%n)이다.
		 *
		 */
		/*
		if(m<n) {
			int tmp = m;
			m = n;
			n = tmp;
		}
		if(m%n == 0) return n;
		return gcd(n, m%n);
		*/
		//위를 더 간단히 하면,
		if(n==0) return m;
		return gcd(n, m%n);
	}
	
	
	
	
	
	
	
}


