package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj14501 {
	public static void main(String[] args) {
		try {
			new Bj14501().go();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	TimeAndPay map[];
	int n, max = 0;
	public void go() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new TimeAndPay[n+1];
		StringTokenizer st ;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[i] = new TimeAndPay(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		
		for(int i=1; i<=n; i++) 
			dfs(i, 0);
		
		
		System.out.println(max);
	}
	
	
	public void dfs(int index, int sum) {

		for(int i=index; i<=n; i++) {
			if(i + map[i].t <= n+1) {
				dfs(map[i].t+i, sum+map[i].p);				
			}
		}//for
		
		max = max < sum ? sum : max ;
		
	}
}

class TimeAndPay{
	int t ;
	int p ;
	public TimeAndPay(int t, int p) {
		this.t = t;
		this.p = p;
	}
}
