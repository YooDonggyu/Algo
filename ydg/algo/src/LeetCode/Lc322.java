package LeetCode;

import java.util.Arrays;

public class Lc322 {
	public static void main(String[] args) {
		int[] coins = {186,419,83,408};
		int amount = 6249;
		System.out.println(new Solution_Lc322().coinChange(coins, amount));
	}
}
class Solution_Lc322 {
	int cnt=-1;
    public int coinChange(int[] coins, int amount) {
    	
    	Arrays.sort(coins);
    	for(int i=coins.length-1; i>=0; i--) {
        	dp(i, amount, 0, coins, amount);
        }
    	
    	return cnt;
    }
    
    public void dp(int i, int m, int sum, int[] coins, int amount) {
    	if(i < 0) return;
    	
    	int n1 = m/coins[i];
    	int n2 = m%coins[i];
    	
    	System.out.println("i : "+i+", n1/n2 = "+n1+"/"+n2+", sum : "+sum);
    	
    	if(i == 0 ) {
    		if(n2 == 0){
    			sum += n1;
    			cnt = cnt > sum ? sum : cnt;
    		}
    		return;
    	}
    	for(int j = i-1; j>=0; j--) {
    		dp(j, n2, sum+n1, coins, amount);
    	}
    	
    	
    }
}