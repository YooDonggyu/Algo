package LeetCode;

public class Lc70 {
	public static void main(String[] args) {
		System.out.println(new Solution_Lc70().climbStairs(3));
	}
}

class Solution_Lc70 {
    public int climbStairs(int n) {
        int[] map = new int[n+1];
        map[0] = map[1] = 1;
        for(int i=2; i<=n; i++) map[i] = map[i-1] + map[i-2];
        
    	return map[n];
    }
}