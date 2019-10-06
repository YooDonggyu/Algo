package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Bj2210 {
	String[][] map = new String[5][5];
	public static void main(String[] args) {
		try {
			new Bj2210().go();			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void go() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<5; i++) 
			map[i] = br.readLine().split(" ");
		
		PriorityQueue<String> q = new PriorityQueue<String>();
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++)
				dfs(q, "", i, j, 0);
		
		
		int cnt =1;
		String str1="", str2="" ;
		while(q.size() > 1) {
			str1 = q.poll();
			str2 = q.peek();
			
			if(!str2.equals(str1)) cnt++;
		}
		if(!str2.equals(q.poll())) cnt++; 
		
		System.out.println(cnt);
	}
	
	public void dfs(PriorityQueue<String> q, String str, int i, int j, int cnt) {
		if(i > 4 || i < 0 || j > 4 || j < 0) return ;
		
		if(cnt == 6) {
			q.add(str);
			return;
		}
		
		dfs(q, str+map[i][j], i, j+1, cnt+1);
		dfs(q, str+map[i][j], i-1, j, cnt+1);
		dfs(q, str+map[i][j], i, j-1, cnt+1);
		dfs(q, str+map[i][j], i+1, j, cnt+1);		
		
	}
}
