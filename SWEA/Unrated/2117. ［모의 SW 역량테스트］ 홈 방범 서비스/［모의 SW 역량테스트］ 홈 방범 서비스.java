import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			map = new int[n][n];
			for(int j=0;j<n;j++) {
				String[] s2 = br.readLine().split(" ");
				for(int k=0;k<n;k++) {
					map[j][k] = Integer.parseInt(s2[k]);
				}
			}
			int count = 0;
			for(int area=2*n;area>0;area--) {
				for(int j=0;j<n;j++) {
					for(int k=0;k<n;k++) {
						count = Math.max(count, countHouse(j,k,n,m,area));
					}
				}
				if(count!=0)
					break;
			}
			System.out.println("#"+i +" "+ count);
		}
	}
	public static int countHouse(int x, int y, int n, int m, int k) {
	    int house = 0;
	    for (int i=0; i<n; i++) {
	        for (int j=0; j<n; j++) {
	            if (Math.abs(x-i) + Math.abs(y-j)<k && map[i][j] == 1) {
	                house++;
	            }
	        }
	    }
	    int cost = k*k + (k-1)*(k-1);
	    if (house*m >= cost) return house;
	    return -1;
	}

	public static boolean isRange(int x, int y, int n) {
		return x>=0 && y>=0 && x<n && y<n;
	}
}
