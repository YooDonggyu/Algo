package programmers;

public class ProDBFS_2 {
	public static void main(String[] args) {
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		int n = 3;
		System.out.println(new ProDBFS_2_Solution().solution(n, computers));
	}
}
class ProDBFS_2_Solution{
	static boolean[][] ch;
	public void dfs(int[][] computers, int pos, int n) {
		for(int i = 0; i < n; i++) {			
			if(computers[pos][i] == 1 && !ch[pos][i]) {
				ch[pos][i] = ch[i][pos] = true;
				dfs(computers, i, n);
			}
		}
	}
	
	public int solution(int n, int[][] computers) {
		int answer = 0;
		ch = new boolean[n][n];
		
        for(int i = 0; i < n; i++) {
        	if(!ch[i][i]) {
        		dfs(computers, i, n);
        		answer++;
        	}
        }
		return answer;
    }
}