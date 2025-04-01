import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		String[] s1 = br.readLine().split(" ");
		String[] s2 = br.readLine().split(" ");
		int[] health = new int[n+1];
		int[] happy = new int[n+1];
		for(int i=1;i<=n;i++) {
			health[i] = Integer.parseInt(s1[i-1]);
			happy[i] = Integer.parseInt(s2[i-1]);
		}
		//KnapSack Problem
		int[][] dp = new int[n+1][101];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=100;j++) {
				if(health[i]>=j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], happy[i]+dp[i-1][j-health[i]]);
				}				
			}
		}
		System.out.println(dp[n][100]);
	}
}

