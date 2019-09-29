package programmers;

public class ProDBFS_3 {
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(new Solution().solution(begin, target, words));
	}
}

final class Solution{
	int[] visit;
	int answer = 999;
    public int solution(String begin, String target, String[] words) {
    	visit = new int[words.length];
        for(int i=0; i<words.length; i++) {
        	if(target.equals(words[i])) {
        		break;
        	}
        	else if (i == words.length-1) return 0;
        }
        //System.out.println(answer);
        for(int i=0; i<words.length; i++) {
        	if(visit[i] == 0) {
        		dfs(begin, target, words, i);
        	}
        }
        
        //for(int i=0; i<visit.length; i++) System.out.println(visit[i]);
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, int pre) {
    	
    	for(int i=0; i<words.length; i++) {
    		if(visit[i] == 0 && diff(begin, words[i])) {
    			visit[i]=visit[pre]+1;
    			if(target.equals(words[i])) {
    				if(answer != 0) 
    					answer = answer < visit[i] ? answer : visit[i];
    			}
    			dfs(words[i], target, words, i);
    			visit[i]= 0;
    		}
    	}
    }
    
    public boolean diff(String str1, String str2) {
    	int n = 0;
    	for(int i=0; i<str1.length(); i++) 
    		if(str1.charAt(i) != str2.charAt(i)) n++;
    	//System.out.println("str1 = "+str1+", str2 = "+ str2+", n = "+n);
    	return n == 1 ? true : false;
    }
}