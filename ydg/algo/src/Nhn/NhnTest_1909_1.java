package Nhn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class NhnTest_1909_1 {
	public static void main(String[] args) {
		try {
			new NhnTest_1909_1_Solution().Solution();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class NhnTest_1909_1_Solution{
	
	int[] map;
	int cnt, sum ;
	boolean ch;
	
	public void go() throws Exception{
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = pInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		
		map = new int[size+1];
		cnt = 1;
		map[cnt] =1;
		Arrays.sort(strs);
		
		//카운트
		String str1, str2;
		for(int i=0; i<strs.length-1; i++) {
			str1 = strs[i];
			str2 = strs[i+1];
			if(str1.equals(str2)) {
				map[cnt]+=1;
			}else {
				cnt +=1;
				map[cnt] = 1;
			}
		}
		
		
		
		int n = (size+1)/cnt;
		sum =0; ch = true;
		for(int i=0; i<map.length; i++) {
			if(map[i] == 0) continue;
			if(n == map[i]) continue;
			else {
				findBig();
				break;
			}
		}//for
		
		
		// 출력
		if(sum == 1) size++;
		if(ch) {
			System.out.println("Y");
		}else {
			System.out.println("N");
		}
		System.out.println(size);
		System.out.println(cnt);
	}
	
	public void findBig() {
		Integer[] i_map = Arrays.stream(map).boxed().toArray(Integer[]::new);
		Arrays.sort(i_map, Comparator.reverseOrder());
		
		int big = i_map[0];
		for(int j=1; j<i_map.length; j++) {
			if(i_map[j] != 0) {
				sum += Math.abs(big - i_map[j]);
				if (sum > 1) {
					ch = false;
					break;
				}
			}
		}//for 
	}
	
	public int pInt(String str) {
		return Integer.parseInt(str);
	}
	
	public void Solution() throws Exception{
		go();
	}
}