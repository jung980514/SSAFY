import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][n];
		int[][] tri = new int[n][n];
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<s.length;j++) {
				tri[i][j] = Integer.parseInt(s[j]);
			}
		}
		dp[0][0] = tri[0][0];
		for(int i=1;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j==0)
					dp[i][j] = dp[i-1][j]+ tri[i][j];
				else
					dp[i][j] = Math.max(dp[i-1][j]+tri[i][j], dp[i-1][j-1]+ tri[i][j]);
			}
		}
		int result = 0;
		for(int i=0;i<n;i++) {
			result = Math.max(dp[n-1][i] , result);
		}
		System.out.println(result);
	}
}
