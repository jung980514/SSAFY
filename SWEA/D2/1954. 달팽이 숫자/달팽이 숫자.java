import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int num=1;
			int x=0;
			int y=0;
			int idx=0;
			for(int j=0;j<n;j++) {
				map[x][y+j] = num++;
			}
			y = n-1;
			while(true) {
				idx++;
				for(int j=0;j<n-idx;j++) {
					if(idx%2==1)
						map[++x][y] = num++;
					else
						map[--x][y] = num++;
				}
				for(int j=0;j<n-idx;j++) {
					if(idx%2==1)
						map[x][--y] = num++;
					else
						map[x][++y] = num++;
				}
				if(num>n*n)
					break;
			}
			System.out.println("#"+i);
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					System.out.print(map[j][k]+" ");
				}
				System.out.println();
			}
		}
	}
}