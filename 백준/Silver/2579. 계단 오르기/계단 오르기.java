import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int[] stairs = new int[n+1];
		for(int i=1;i<=n;i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] dp = new int[2][n+1];
		dp[0][0] = 0;
		dp[1][0] = 0;
		dp[0][1] = stairs[1];
		dp[1][1] = 0;
		if(n>=2) {
			dp[0][2] = dp[0][1]+stairs[2];
			dp[1][2] = dp[1][0]+stairs[2];
			for(int i=3;i<=n;i++) {
				dp[0][i] = dp[1][i-1] + stairs[i];
				dp[1][i] = Math.max(dp[0][i-2], dp[1][i-2]) + stairs[i];
			}			
		}
		System.out.println(Math.max(dp[0][n], dp[1][n]));
	}
}
