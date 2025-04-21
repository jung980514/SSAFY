import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int sumX;
	static int sumY;
	static int[][] worm;
	static long min;
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			sumX=0;
			sumY=0;
			worm = new int[n][2];
			min = Long.MAX_VALUE;
			for(int i=0;i<n;i++) {
				String[] s = br.readLine().split(" ");
				worm[i][0] = Integer.parseInt(s[0]);
				worm[i][1] = Integer.parseInt(s[1]);
				sumX +=worm[i][0];
				sumY +=worm[i][1];
			}
			int selectX = 0;
			int selectY = 0;
			Combination(n,n/2,0,0,selectX,selectY);
			System.out.println("#"+t+" "+min);
		}
	}
	public static void Combination(int n, int r, int start,int depth, int selectX, int selectY) {
		if(depth==r) {
			int notSelectX = sumX-selectX;
			int notSelectY = sumY-selectY;
			min = Math.min(min,(long)(Math.pow(selectX-notSelectX, 2)+ Math.pow(selectY-notSelectY, 2)));
			return;
		}
		for(int i=start;i<n;i++) {
			Combination(n,r,i+1,depth+1,selectX+worm[i][0],selectY+worm[i][1]);
		}
	}
}
