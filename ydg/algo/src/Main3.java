import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3 {
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			long cnt = Integer.parseInt(br.readLine());
			long intNums[] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			Arrays.sort(intNums);
			long num1 = 0;
			long num2 = 0;
			long dist = Long.MAX_VALUE;
			
			for(int i = 0; i<cnt-1; i++) {
				for(int j = i+1; j<cnt; j++) {
					if((dist > Math.abs(intNums[i] - intNums[j]))) {
						num1 = intNums[i];
						num2 = intNums[j];
						dist = Math.abs(intNums[i] - intNums[j]);
					}
				}//for
			}//for
			
			System.out.println(num1+" "+num2);
		}
		catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
