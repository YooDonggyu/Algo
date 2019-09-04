import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String strNum1 = br.readLine();
			String strNum2 = "";
			String strSum = "";
			int sum = 0;
			int cnt = 3;
			
			while(cnt>0) {
				for(int i =strNum1.length()-1; i>=0; i--) {
					strNum2 += strNum1.charAt(i);
				}
				sum = Integer.parseInt(strNum1) + Integer.parseInt(strNum2);
				strSum = Integer.toString(sum);
				
				char temp1 ;
				char temp2 ;
				for(int i =0; i<strSum.length()/2; i++ ) {
					temp1 = strSum.charAt(i);
					temp2 = strSum.charAt(strSum.length()-1-i);
					if(temp1 != temp2 || sum >= 10000) {
						if(cnt == 1) {
							sum = -1;
						}
						break;
					}
					else {
						if(i == strSum.length()/2-1) {
							cnt = -1;
						}
					}
				}//for
				cnt --;
				strNum1 = strSum;
				strNum2 = "";
			}
			System.out.println(sum);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
}
