import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		//각 열이 의미하는 것 : 마지막 집이 빨강 초록 파랑인 경우
		int[][] dp = new int[n+1][3];
		int[][] cost = new int[n+1][3];
		
		for(int i=1;i<=n;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<3;j++) {
				cost[i][j] = Integer.parseInt(s[j]);
			}
		}
		dp[1][0] = cost[1][0];
		dp[1][1] = cost[1][1];
		dp[1][2] = cost[1][2];
		for(int i=2;i<=n;i++) {
			//빨강 칠할때는 이전에 파랑,초록을 칠했던 경우+빨강 칠하는 비용의 최소값저장
			dp[i][0] = Math.min(cost[i][0]+dp[i-1][1], cost[i][0]+dp[i-1][2]);
			//초록 칠할때는 이전에 빨강,파랑을 칠했던 경우+초록 칠하는 비용의 최소값저장
			dp[i][1] = Math.min(cost[i][1]+dp[i-1][0], cost[i][1]+dp[i-1][2]);
			//파랑 칠할때는 이전에 빨강,초록을 칠했던 경우+파랑 칠하는 비용의 최소값저장
			dp[i][2] = Math.min(cost[i][2]+dp[i-1][0], cost[i][2]+dp[i-1][1]);
		}
		int result = Integer.MAX_VALUE;
		//3 종류 집 중 최대값 출력
		for(int i=0;i<3;i++) {
			result = Math.min(result, dp[n][i]);
		}
		System.out.println(result);
	}
}
