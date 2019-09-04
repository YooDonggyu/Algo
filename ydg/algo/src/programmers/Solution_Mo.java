package programmers;

public class Solution_Mo {
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5} ;
		System.out.println(solution(answers));
	}
	
	public static int[] solution(int[] answers) {
        int[] answer;
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int max = 0;
        
        answer = getAnswer(one, answers);
        max = answer.length;
        answer = getAnswer(two, answers);
        max = max < answer.length ? answer.length : max;
        answer = getAnswer(three, answers);
        max = max < answer.length ? answer.length : max;
        
        return answer;
    }
	public static int[] getAnswer(int[] data, int[] answers) {
		
		
		int len = answers.length < data.length ? answers.length : data.length;
		int[] result = new int[len];
		for(int i=0; i<len; i++) {
			if(answers[i] == data[i]) {
				result[i] = data[i];
			}
		}
		return result;
	}
}
