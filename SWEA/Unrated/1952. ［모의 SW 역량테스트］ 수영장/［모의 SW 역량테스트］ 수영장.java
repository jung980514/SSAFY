import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			String[] s = br.readLine().split(" ");
			int day1 = Integer.parseInt(s[0]);
			int month1 = Integer.parseInt(s[1]);
			int month3 = Integer.parseInt(s[2]);
			int year1 = Integer.parseInt(s[3]);
			String[] s2 = br.readLine().split(" ");
			int[] plan = new int[13];
			for(int j=0;j<12;j++) {
				plan[j+1] = Integer.parseInt(s2[j]);
			}
			int[] dp = new int[13];
			dp[1] = Math.min(plan[1]*day1, month1);
			for(int j=2;j<=12;j++) {
				if(j>2) {
					dp[j] = Math.min(Math.min(dp[j-1]+ plan[j]*day1, dp[j-1]+month1) , dp[j-3]+month3);
				}
				else {
					dp[j] = Math.min(dp[j-1]+ plan[j]*day1, dp[j-1]+month1);
				}
			}
			System.out.println("#"+i+" "+ Math.min(dp[12], year1));
		}
		
	}
}
