import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//첫 번째 입력
			int cnt = Integer.parseInt(br.readLine());
			//두 번째 입력
			long nums[] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			
			long max ; //최대값 저장
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			if(cnt ==1 ) {
				System.out.println(nums[0]*2);
			}else {
				while(true) {
					Arrays.sort(nums);
					max = nums[0];
					for(int j=1; j<cnt; j++) {
						max = new Main().compareNums(max, nums[j]);
					}//for
					sb.append(Long.toString(max));
					sb1.insert(0, Long.toString(max));
					
					int index = Arrays.binarySearch(nums, max);
					for(int k=index; k<cnt-1; k++) {
						nums[k] = nums[k+1];
					}
					cnt--;
					
					if(cnt<=1) {
						sb.append(Long.toString(nums[0]));
						sb1.insert(0, Long.toString(nums[0]));
						break;
					}
				}//while
				long sum = Long.parseLong(sb.toString())+Long.parseLong(sb1.toString());
				System.out.println(sum);
				
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}	
		
	}
	
	public long compareNums(long num1, long num2) {
		long temp1 = (num1/10==0)? num1: num1%10;
		long temp2 = (num2/10==0)? num2: num2%10;
		if(temp1 == temp2) {
			return (num2%10>=num1)?num2:num1;
		}else {
			return (temp1>temp2)? num1: num2;
		}
	}
	
}
