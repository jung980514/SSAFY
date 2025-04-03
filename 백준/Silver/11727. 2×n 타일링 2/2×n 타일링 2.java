import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		for(int i=3;i<=n;i++) {
				//	1*1 타일 남았을때 1*2타일만 가능하므로 dp[i-1]
				//  2*2 타일 남았을때 2*1타일과 2*2 타일 2가지 가능하므로 dp[i-2] * 2
			dp[i] = (dp[i-1]%10007 + dp[i-2]*2%10007)%10007;			
		}
		System.out.println(dp[n]);
	}
}
