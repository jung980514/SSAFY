import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] child = new int[n+1];
		for(int i=1;i<=n;i++) {
			child[i] = Integer.parseInt(s[i-1]);
		}
		int[] dp = new int[n+1];
		int max = 0;
		//dp[i] = i번까지 1씩 증가하는 부분수열 길이
		for(int i=1;i<=n;i++) {
			dp[child[i]] = dp[child[i]-1]+1;
			max = Math.max(max, dp[child[i]]);
		}
		System.out.println(n-max);
	}
}
