package LeetCode;

public class Lc338 {
	public static void main(String[] args) {
		int[] a =  new Solution_Lc338().countBits(2);
		for(int i=0; i<a.length; i++) System.out.println(a[i]);
	}
}


class Solution_Lc338 {
    public int[] countBits(int n) {
    	int[] a = new int[n+1];
    	a[0] = 0;
    	if(n == 0) return a;
    	a[1] = 1;
    	if(n == 1) return a;
    	
    	int p = 2;
    	while(p<=n*2) {
    		int index = 0;
    		for(int i=p; i<p*2; i++) {
    			if(i <= n)a[i] = a[index++]+1;
    			else break;
    		}
    		p*=2;
    	}
    	
    	return a;
    }
}
