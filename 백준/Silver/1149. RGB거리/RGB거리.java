import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][3];
		int[][] cost = new int[n][3];
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<3;j++)
				cost[i][j] = Integer.parseInt(s[j]);
		}
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];		
		for(int i=1;i<n;i++) {
			dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]),dp[n-1][2]));
	}
}
