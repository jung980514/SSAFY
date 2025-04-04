import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[31];
		dp[1] = 0;
		dp[2] = 3;
		dp[3] = 0;
		dp[4] = 11;
		for(int i=5;i<=n;i++) {
			if(i%2==1)
				dp[i] = 0;
			else {
				dp[i] = dp[i-2]*4-dp[i-4];
			}
		}
		System.out.println(dp[n]);
	}
}
