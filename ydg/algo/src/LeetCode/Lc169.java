package LeetCode;

import java.util.HashMap;
import java.util.Iterator;

public class Lc169 {
	public static void main(String[] args) {
		int[] nums = {3,3,4};
		System.out.println(new Solution_Lc169().majorityElement(nums));
	}
}
class Solution_Lc169 {
    public int majorityElement(int[] nums) {
    	
    	HashMap<String, Integer> map = new HashMap<>();
    	for(int i=0; i<nums.length; i++) {
    		String n = Integer.toString(nums[i]);
    		int v ;
    		if(map.containsKey(n)) {
    			v = map.get(n);
    			map.put(n, v+1);
    		}else {
    			map.put(n, 1);
    		}
    	}
    	
    	int max = 0;
    	String bigNum = "";
    	Iterator<String> it = map.keySet().iterator();
    	while(it.hasNext()) {
    		String str = it.next();
    		int cnt = map.get(str);
    		if(max < cnt ) {
    			max = cnt;
    			bigNum = str;
    		}
    	}
    	
        return Integer.parseInt(bigNum);
    }
}
/*
 
class Solution {
    public int majorityElement(int[] nums) {
        int max = nums.length/2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > max) {
                return num;
            }

        }

        return -1;    
    }
}
 
 
 
 */