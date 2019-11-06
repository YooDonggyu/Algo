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
    	
    }
}