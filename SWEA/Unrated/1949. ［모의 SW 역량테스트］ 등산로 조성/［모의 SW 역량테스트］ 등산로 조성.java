import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	static boolean[][] visited;
	static int[][] start;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n;
	static int result;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			int k = Integer.parseInt(s[1]);
			map = new int[n+1][n+1];
			start = new int[n*n+1][2];
			int maxValue = 0;
			for(int i=1;i<=n;i++) {
				String[] s2 = br.readLine().split(" ");
				for(int j=1;j<=n;j++) {
					map[i][j] = Integer.parseInt(s2[j-1]);
					maxValue = Math.max(maxValue, map[i][j]);
				}
			}
			int idx=1;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(map[i][j]==maxValue) {
						start[idx] = new int[] {i,j};
						idx++;
					}
				}
			}
			result = 0;
			for(int i=1;i<=n;i++) {
				if(start[i][0]!=0 && start[i][1]!=0) {
					for(int j=1;j<=k;j++) {
						visited = new boolean[n+1][n+1];
						visited[start[i][0]][start[i][1]] = true;
						dfs(start[i][0],start[i][1],j,false,1);						
						visited[start[i][0]][start[i][1]] = false;
					}
				}
				
			}
			System.out.println("#"+t+" "+result);
		}
	}
	public static void dfs(int x, int y, int k,boolean isBreak,int count) {
		result = Math.max(result, count);
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(!isRange(nx, ny, n)) continue;
			if(isBreak) {//이미 부순 상태이면
				//지나갈 수 있으면 지나가고 아님 말고
				if(!visited[nx][ny] && map[nx][ny]<map[x][y]) {
					visited[nx][ny] = true;
					dfs(nx,ny,k,true,count+1);
					visited[nx][ny] = false;					
				}
			}
			else { //안부순 상태이면
				//공사 가능하면 공사 하고 지나가거나 안감
				if(!visited[nx][ny] && map[nx][ny]-k<map[x][y]) {
					visited[nx][ny] = true;
					map[nx][ny] -= k;
					dfs(nx,ny,k,true,count+1);
					visited[nx][ny] = false;
					map[nx][ny] += k;
				}
				if(!visited[nx][ny] && map[nx][ny]<map[x][y]) {
					visited[nx][ny]= true;
					dfs(nx,ny,k,false,count+1);
					visited[nx][ny]= false;
				}
			}
		}
		
	}
	public static boolean isRange(int x, int y, int n) {
		return x>=1 && y>=1 && x<=n && y<=n; 
	}
}
