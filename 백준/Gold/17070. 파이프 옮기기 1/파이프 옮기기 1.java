import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,1,1};
	static int[] dy = {1,1,0};	
	static int result = 0;
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		int flag = 0; // 0:가로 1:대각선  2:세로
		visited[0][0]=true;
		visited[0][1]=true;
		dfs(0,1,flag,n);
		System.out.println(result);
	}
	public static void dfs(int x,int y,int flag,int n) {
		if(x==n-1 && y==n-1) {
			result++;
			return;
		}
		if(flag==0) {
			for(int i=0;i<2;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(i==1) {
					if(isRange(nx,ny,n) && !visited[nx][y] && !visited[x][ny] 
							&& !visited[nx][ny] && map[nx][ny]==0 && map[nx][y]==0
									&& map[x][ny]==0) {
						visited[nx][ny] = true;
						visited[nx][y] = true;
						visited[x][ny] = true;
						dfs(nx,ny,i,n);
						visited[nx][ny] = false;
						visited[nx][y] = false;
						visited[x][ny] = false;
					}
				}
				else {
					if(isRange(nx,ny,n) && !visited[nx][ny] && map[nx][ny]==0) {
						visited[nx][ny] = true;
						dfs(nx,ny,i,n);
						visited[nx][ny] = false;
					}
				}
			}
		}
		else if(flag==1) {
			for(int i=0;i<3;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(i==1) {
					if(isRange(nx,ny,n) && !visited[nx][y] && !visited[x][ny] 
							&& !visited[nx][ny] && map[nx][ny]==0 && map[nx][y]==0
									&& map[x][ny]==0) {
						visited[nx][ny] = true;
						visited[nx][y] = true;
						visited[x][ny] = true;
						dfs(nx,ny,i,n);
						visited[nx][ny] = false;
						visited[nx][y] = false;
						visited[x][ny] = false;
					}
				}
				else {
					if(isRange(nx,ny,n) && !visited[nx][ny] && map[nx][ny]==0) {
						visited[nx][ny] = true;
						dfs(nx,ny,i,n);
						visited[nx][ny] = false;
					}
				}
			}
		}
		else {
			for(int i=1;i<3;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(i==1) {
					if(isRange(nx,ny,n) && !visited[nx][y] && !visited[x][ny] 
							&& !visited[nx][ny] && map[nx][ny]==0 && map[nx][y]==0
									&& map[x][ny]==0) {
						visited[nx][ny] = true;
						visited[nx][y] = true;
						visited[x][ny] = true;
						dfs(nx,ny,i,n);
						visited[nx][ny] = false;
						visited[nx][y] = false;
						visited[x][ny] = false;
					}
				}
				else {
					if(isRange(nx,ny,n) && !visited[nx][ny] && map[nx][ny]==0) {
						visited[nx][ny] = true;
						dfs(nx,ny,i,n);
						visited[nx][ny] = false;
					}
				}
			}
		}
	}
	public static boolean isRange(int x,int y,int n) {
		if(x>=0 && y>=0 && x<n && y<n) return true;
		else return false;
	}
}
