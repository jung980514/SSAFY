import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] child = new int[n+1];
            for(int i=1;i<=n;i++) {
                child[i] = Integer.parseInt(s[i-1]);
            }
            int[] dp = new int[n+1];
            int max = 0;
            for(int i=1;i<=n;i++) {
                dp[child[i]] = dp[child[i]-1]+1;
                max = Math.max(max, dp[child[i]]);
            }
            System.out.println("#"+t+" "+(n-max));
        }
	}
}
