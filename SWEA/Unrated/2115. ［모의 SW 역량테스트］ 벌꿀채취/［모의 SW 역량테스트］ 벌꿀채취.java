import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n,m,c,max;
	static int[][] honey;
	static int[][] profit;

	public static void main(String[] args) throws IOException{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String[] s=br.readLine().split(" ");
			n=Integer.parseInt(s[0]);
			m=Integer.parseInt(s[1]);
			c=Integer.parseInt(s[2]);
			honey=new int[n][n];
			profit=new int[n][n];
			for(int i=0;i<n;i++) {
				String[] s2=br.readLine().split(" ");
				for(int j=0;j<n;j++) {
					honey[i][j]=Integer.parseInt(s2[j]);
				}
			}
			// 각 위치별 최대 수익 계산
			for(int i=0;i<n;i++) {
				for(int j=0;j<=n-m;j++) {
					profit[i][j]=getMaxProfit(i,j);
				}
			}
			// 두 일꾼 조합으로 최대 수익 계산
			max=0;
			for(int i1=0;i1<n;i1++) {
				for(int j1=0;j1<=n-m;j1++) {
					for(int i2=i1;i2<n;i2++) {
						for(int j2=0;j2<=n-m;j2++) {
							if(i1==i2&&j2<j1+m) continue;
							int sum=profit[i1][j1]+profit[i2][j2];
							if(sum>max) max=sum;
						}
					}
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}

	static int getMaxProfit(int x,int y) {
		//Knapsack Problem
		int[] w = new int[m]; // 무게 = 꿀 양
		int[] v = new int[m]; // 가치 = 꿀 제곱
		for(int i=0;i<m;i++) {
			w[i] = honey[x][y+i];
			v[i] = w[i]*w[i];
		}
		int[][] dp=new int[m+1][c+1]; // dp[i][j] = i번째까지 봤을 때, 용량 j로 얻을 수 있는 최대 수익
		for(int i=1;i<=m;i++) {
			for(int j=0;j<=c;j++) {
				if(w[i-1]>j) dp[i][j]=dp[i-1][j];
				else dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i-1]]+v[i-1]);
			}
		}
		return dp[m][c];
	}

}
