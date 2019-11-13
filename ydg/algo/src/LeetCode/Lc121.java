package LeetCode;

public class Lc121 {
	public static void main(String[] args) {
		//int[] prices = {7,1,5,3,6,4};
		int[] prices = {7,6,5,4,3,2};
		System.out.println(new Solution_Lc121().maxProfit(prices));
	}
}
class Solution_Lc121 {
	int max = 0;
    public int maxProfit(int[] prices) {
    	
    	for(int i=0; i<prices.length; i++) solve(i, prices);
    	
        return max;
    }
    
    public void solve(int index, int[] prices) {
    	int n = prices[index];
    	int m ;
    	for(int i = index+1; i<prices.length; i++) {
    		if(prices[i]>n) {
    			m = prices[i]-n;
    			max = m>max ? m:max;
    		}
    	}
    }
}