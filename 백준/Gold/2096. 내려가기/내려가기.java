import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[][] down = new int[n][3];
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			down[i][0] = Integer.parseInt(s[0]);
			down[i][1] = Integer.parseInt(s[1]);
			down[i][2] = Integer.parseInt(s[2]);
		}
		int[][] dp = new int[n][3];
		dp[0][0] = down[0][0];
		dp[0][1] = down[0][1];
		dp[0][2] = down[0][2];
		for(int i=1;i<n;i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + down[i][0];
			dp[i][1] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]),dp[i-1][2]) + down[i][1];
			dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + down[i][2];
		}
		sb.append(Math.max(Math.max(dp[n-1][0], dp[n-1][1]),dp[n-1][2]));
		for(int i=1;i<n;i++) {
			dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + down[i][0];
			dp[i][1] = Math.min(Math.min(dp[i-1][0], dp[i-1][1]),dp[i-1][2]) + down[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + down[i][2];
		}
		sb.append(" ").append(Math.min(Math.min(dp[n-1][0], dp[n-1][1]),dp[n-1][2]));
		System.out.println(sb.toString());
	}
}