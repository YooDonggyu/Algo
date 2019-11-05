package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Lc20 {
	public static void main(String[] args) {
		
		System.out.println(new Solution_Lc20().isValid("(("));
	}
}

class Solution_Lc20 {
    public boolean isValid(String s) {
    	if(s.length() %2 != 0) return false;

    	Deque<Integer> q = new LinkedList<>();
    	for(int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		if(c == '(') q.add(1);
    		else if(c == ')') q.add(-1);
    		else if(c == '[') q.add(2);
    		else if(c == ']') q.add(-2);
    		else if(c == '{') q.add(3);
    		else if(c == '}') q.add(-3);
    	}//for

    	Deque<Integer> result = new LinkedList<>();
    	while(q.size() > 0) {
    		int n = q.removeFirst();
    		if(n > 0) result.add(n);
    		else {
    			if(result.size() <= 0) return false;
    			int temp = result.removeLast();
    			if(temp != Math.abs(n)) return false;
    		}
    	}//while
    	
    	if(result.size() != 0 ) return false;
    	return true;
    }
}
