import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int[] w = new int[n+1];
		int[] v = new int[n+1];
		for(int i=1;i<=n;i++) {
			String[] s2 = br.readLine().split(" ");
			w[i] = Integer.parseInt(s2[0]);
			v[i] = Integer.parseInt(s2[1]);
		}
		int[][] dp = new int[n+1][m+1];
		for(int i=0;i<=n;i++) {
			Arrays.fill(dp[i], 0);
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(w[i] > j)
					dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = Math.max(dp[i-1][j], v[i]+dp[i-1][j-w[i]]);
				}
			}
		}
		System.out.println(dp[n][m]);
	}
}
