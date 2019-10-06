package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Bj16198 {
	
	int max = 0;
	int first_n, last_n ;
	
	public static void main(String[] args) {
		try {
			new Bj16198().go();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void go() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		LinkedList<Integer> q = new LinkedList<Integer>();
		first_n = map[0];
		last_n = map[n-1];
		for(int i=1; i<n-1; i++) q.add(map[i]);
		dfs(q, 0);
		
		System.out.println(max);
	}
	
	public void dfs(LinkedList<Integer> q , int sum) {
		int size = q.size();
		if(size <1) {
			max = max < sum ? sum : max;
			return;
		}
		
		for(int i=0; i<size; i++) {
			int num = q.remove(i);
			
			int mul = 0;
			if( size == 1) mul = first_n * last_n;
			else if( i == 0) mul = first_n * q.get(i);
			else if ( i == size -1) mul = last_n * q.get(i-1);
			else mul = q.get(i-1) * q.get(i);
			dfs(q, sum+mul);
			
			
			q.add(i, num);
		}
	}
}
