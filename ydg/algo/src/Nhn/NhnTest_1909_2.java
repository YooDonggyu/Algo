package Nhn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class NhnTest_1909_2 {
	public static void main(String[] args) {
		try {
			new NhnTest_1909_2_Solution().Solution();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class NhnTest_1909_2_Solution{
	int[] map;
	LinkedList<Integer> q;
	public void Solution() throws Exception {
		
		go();
		
	}
	
	public void go() throws Exception{
		map = new int[100+1];
		q = new LinkedList<>();
		
		LinkedList<Integer> result = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = pInt(br.readLine());
		String[] strs;
		String str;
		int n ;
		int nn;
		while(cnt-->0) {
			strs = br.readLine().split(" ");
			str = strs[0];
			
			if(str.equals("enqueue")) {
				n = pInt(strs[1]);
				q.add(n);
				map[n] +=1 ;
			}else {
				n = q.get(0);
				nn = findTop(n);
				
				if( nn == n) {
					result.add(n);
					map[n]-=1;
					q.removeFirst();
				}else {
					for(int i=1; i<q.size(); i++) {
						n = q.get(i);
						
						if(nn == n) {
							result.add(n);
							map[n]-=1;
							q.remove(i);
							break;
						}
					}//for
				}
			}
		}//while cnt
		//dequeue
		while(result.size() > 0) 
			System.out.print(result.removeFirst()+" ");
	}
	
	public int findTop(int pos) {
		int n = map[pos];
		for(int i=0; i<map.length; i++) {
			if(map[i] == 0) continue;
			else if(map[i] > n) return i;
		}
			
		return pos;
	}
	
	public int pInt(String str) {
		return Integer.parseInt(str);
	}
}
