import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[10000001];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 7;
		for(int i=3;i<=n;i++) {
			dp[i] = (3*(dp[i-1]%1000000007) + (dp[i-2]%1000000007) - (dp[i-3]%1000000007)+1000000007)%1000000007;
		}
		System.out.println(dp[n]);
	}
}
