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
		dp[0]=1;
		for(int i=0;i<n;i++) {
			for(int j=coins[i];j<=k;j++) {
				dp[j] += dp[j-coins[i]];
			}
		}
		System.out.println(dp[k]);
	}
}
