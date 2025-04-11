import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		int[] coins = new int[n];
		for(int i=0;i<n;i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(coins);
		int[] dp = new int[k+1];
		Arrays.fill(dp, 100001);
		dp[0]=0;
		for(int i=0;i<n;i++) {
			for(int j=coins[i];j<=k;j++) {
				dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
			}
		}
		System.out.println(dp[k]==100001?-1:dp[k]);
	}
}
