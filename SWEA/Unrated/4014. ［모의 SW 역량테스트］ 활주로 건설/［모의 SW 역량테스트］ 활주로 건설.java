import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int x = Integer.parseInt(s[1]);
			int[][] map = new int[n][n];
			int[][] counts = new int[n][n];
			int result=0;
			for(int i=0;i<n;i++) {
				String[] s2 = br.readLine().split(" ");
				for(int j=0;j<n;j++) 
					map[i][j] = Integer.parseInt(s2[j]);
			}
			//가로 개수 카운팅
			for(int i=0;i<n;i++) {
				int idx=0;
				int cur = map[i][0];
				counts[i][idx]++;
				for(int j=1;j<n;j++) {
					if(cur!=map[i][j]) {
						cur = map[i][j];
						idx++;
						counts[i][idx]++;
					}
					else {
						counts[i][idx]++;
					}
				}
			}
			//가로 활주로 건설 방법 세기
			for(int i=0;i<n;i++) {
				int idx=0;
				int cur = map[i][0];
				boolean flag = true;
				for(int j=1;j<n;j++) {
					if(cur < map[i][j]) {
						if(map[i][j]-cur <= counts[i][idx]/x) {
							counts[i][idx] -= (map[i][j]-cur)*x;
							cur = map[i][j];
							idx++;
						}
						else {
							flag = false;
							break;
						}
					}
					else if(cur > map[i][j]) {
						idx++;
						if(cur-map[i][j] <= counts[i][idx]/x) {
							counts[i][idx] -= (cur-map[i][j])*x;
							cur = map[i][j];
						}
						else {
							flag = false;
							break;
						}
					}
				}
				if(flag) {
					result++;
				}
			}
			
			//세로 개수 카운팅
			counts = new int[n][n];
			for(int i=0;i<n;i++) {
				int idx=0;
				int cur = map[0][i];
				counts[i][idx]++;
				for(int j=1;j<n;j++) {
					if(cur!=map[j][i]) {
						cur = map[j][i];
						idx++;
						counts[i][idx]++;
					}
					else {
						counts[i][idx]++;
					}
				}
			}
			//세로 활주로 건설 방법 세기
			for(int i=0;i<n;i++) {
				int idx=0;
				int cur = map[0][i];
				boolean flag = true;
				for(int j=1;j<n;j++) {
					if(cur < map[j][i]) {
						if(map[j][i]-cur <= counts[i][idx]/x) {
							counts[i][idx] -= (map[j][i]-cur)*x;
							cur = map[j][i];
							idx++;
						}
						else {
							flag = false;
							break;
						}
					}
					else if(cur > map[j][i]) {
						idx++;
						if(cur-map[j][i] <= counts[i][idx]/x) {
							counts[i][idx] -= (cur-map[j][i])*x;
							cur = map[j][i];
						}
						else {
							flag = false;
							break;
						}
					}
				}
				if(flag) {
					result++;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
