package programmers;

import java.util.Arrays;

public class ProDP_3 {
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3,8}, {8,1, 0}, {2,7,4,4}, {4,5, 2, 6, 5}};
		System.out.println(new Solution_ProDP_3().solution(triangle));
	}
}
class Solution_ProDP_3{
	
	int[][] result ;
	
	public int solution(int[][] triangle) {
        int answer = 0;
        
        result = triangle;
        
        buttomUp(triangle);
        
        Arrays.sort(result[result.length-1]);
        answer = result[result.length-1][result[result.length-1].length-1];
        
        return answer;
    }
	
	public void buttomUp(int[][] triangle) {
		for(int i=1; i<triangle.length; i++) {	
			for(int j=0; j<triangle[i].length; j++) {
				if(j == 0) 
					result[i][j] = result[i-1][j] + triangle[i][j]; 
				
				else if(j == triangle[i].length-1) 
					result[i][j] = result[i-1][j-1] + triangle[i][j];
				
				else
					result[i][j] = Math.max(result[i-1][j], result[i-1][j-1]) + triangle[i][j];
				
			}
		}
	}
}
