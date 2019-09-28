package programmers;

public class ProDBFS_1 {
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(new ProDBFS_1_Solution().solution(nums, target));
	}
}
class ProDBFS_1_Solution{
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int pos, int n) {
    	if(pos == numbers.length) {
    		return n == target ? 1: 0;
    	}else {
    		return dfs(numbers, target, pos+1, n+numbers[pos]) + dfs(numbers, target, pos+1, n-numbers[pos]);
    	}
    }
}
