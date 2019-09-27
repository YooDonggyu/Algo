package Nhn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class NhnPreTest_190925_1 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] nums = br.readLine().split(" ");
			int n = Integer.parseInt(nums[0]);
			int k = Integer.parseInt(nums[1]);
			String[][] result = new String[n][n];
			for (int i = 0; i < n; i++) {
				result[i] = br.readLine().split(" ");
			}


			LinkedList<String> q = new LinkedList<String>();
			int begin = 1;
			int end = n-1;
			int cnt = n/2;
			while(cnt-- > 0) {
				q.add(result[begin-1][begin-1]);
				for(int i=begin; i<=end; i++)  q.add(result[begin-1][i]);
				for(int i=begin; i<=end; i++)  q.add(result[i][end]);     
				for(int i=end-1; i>=begin-1; i--)  q.add(result[end][i]);  
				for(int i=end-1; i>begin-1; i--)   q.add(result[i][begin-1]);
				
				//for(int i=0; i<q.size(); i++) System.out.println(q.get(i));
				//System.out.println();
				turn(q, k);
				//for(int i=0; i<q.size(); i++) System.out.println(q.get(i));
				//System.out.println();
				
				result[begin-1][begin-1] = q.removeFirst();
				for(int i=begin; i<=end; i++)  result[begin-1][i] = q.removeFirst();
				for(int i=begin; i<=end; i++)  result[i][end] = q.removeFirst();     
				for(int i=end-1; i>=begin-1; i--)  result[end][i] = q.removeFirst();  
				for(int i=end-1; i>begin-1; i--)   result[i][begin-1] = q.removeFirst();
				
				begin++;
				end--;	
				k*=-1;
			}
			//for(int i=0; i<q.size(); i++) System.out.println(q.get(i));
			
			
			
			for(int i=0; i<result.length; i++) {
				for(int j=0; j<result[i].length; j++) {
					System.out.print(result[i][j]);
					if(j != result[i].length-1) System.out.print(" ");
					
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main
	/*
	 * 5 -2
세정 소혜 청하 결경 소희
도연 채경 시라 나영 은우
미나 해인 희현 소미 서경
연정 소연 나영 채연 다니
유정 보연 혜리 예빈 은빈
	 */
	private static void turn(LinkedList<String>q,  int cnt) {
	    for (int i = 0; i < Math.abs(cnt); i++) {
	      if (cnt >= 0) {
	        q.addFirst(q.removeLast());
	      } else {
	        q.addLast(q.removeFirst());
	      }
	    }
	  }
	
}
