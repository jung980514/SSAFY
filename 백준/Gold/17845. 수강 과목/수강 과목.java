import java.io.*;
import java.util.*;
	
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		int[] important = new int[k+1];
		int[] time = new int[k+1];
		for(int i=1;i<=k;i++) {
			String[] s2 = br.readLine().split(" ");
			important[i] = Integer.parseInt(s2[0]);
			time[i] = Integer.parseInt(s2[1]);
		}
		int[] dp = new int[n+1];
		for(int i=1;i<=k;i++) {
			for(int j=n;j-time[i]>=0;j--) {
				dp[j] = Math.max(dp[j],important[i]+dp[j-time[i]]);
			}
		}
		System.out.println(dp[n]);
	}
}
