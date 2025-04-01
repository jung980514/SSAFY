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
		int[] arr=new int[m];
		for(int i=0;i<m;i++) arr[i]=honey[x][y+i];
		int res=0;
		for(int i=1;i<(1<<m);i++) {
			int sum=0,val=0;
			for(int j=0;j<m;j++) {
				if((i&(1<<j))!=0) {
					sum+=arr[j];
					val+=arr[j]*arr[j];
				}
			}
			if(sum<=c&&val>res) res=val;
		}
		return res;
	}
}
