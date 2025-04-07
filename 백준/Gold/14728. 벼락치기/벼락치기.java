import java.io.*;
import java.util.*;
	
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int T = Integer.parseInt(s[1]);
		int[] time = new int[n+1];
		int[] score = new int[n+1];
		for(int i=1;i<=n;i++) {
			String[] s2 = br.readLine().split(" ");
			time[i] = Integer.parseInt(s2[0]);
			score[i] = Integer.parseInt(s2[1]);
		}
		int[] dp = new int[T+1];
		for(int i=1;i<=n;i++) {
			for(int j=T;j-time[i]>=0;j--) {
				dp[j] = Math.max(dp[j],score[i]+dp[j-time[i]]);
			}
		}
		System.out.println(dp[T]);
	}
}
