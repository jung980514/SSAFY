import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		int[] nums = new int[n];
		int result=1;
		String[] s = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			nums[i] = Integer.parseInt(s[i]);
		}
		dp[0] = 1;
		for(int i=1;i<n;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(nums[i]>nums[j] && dp[i] <= dp[j])
					dp[i] = dp[j]+1;
			}
			result = Math.max(result,dp[i]);
		}
		System.out.println(result);
	}
}