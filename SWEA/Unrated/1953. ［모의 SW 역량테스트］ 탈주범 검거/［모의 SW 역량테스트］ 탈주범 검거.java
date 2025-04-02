import java.io.*;
import java.util.*;	

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static boolean[][] visited;
					  //상 하 좌 우	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int count;
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			int r = Integer.parseInt(s[2]);
			int c = Integer.parseInt(s[3]);
			int time = Integer.parseInt(s[4]);
			map = new int[n][m];
			visited = new boolean[n][m];
			count = 0;
			for(int j=0;j<n;j++) {
				String[] s2 = br.readLine().split(" ");
				for(int k=0;k<m;k++) {
					map[j][k] = Integer.parseInt(s2[k]);
				}
			}
			bfs(n,m,r,c,time);
			System.out.println("#"+i+" "+ count);
		}
	}
	public static void bfs(int n, int m, int r, int c, int time) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c, 1}); 
		visited[r][c]= true;
		count++;

		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			int t = tmp[2];

			if(t >= time) continue; // 시간 제한 넘기면 넘김

			switch (map[x][y]) {
				case 1: // 상 하 좌 우
					for(int i=0;i<4;i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(isRange(n,m,nx,ny) && !visited[nx][ny] && isConnected(i, nx, ny)) {
							q.offer(new int[] {nx,ny,t+1});
							visited[nx][ny] = true;
							count++;
						}
					}
					break;
				case 2: // 상 하
					for(int i=0;i<2;i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(isRange(n,m,nx,ny) && !visited[nx][ny] && isConnected(i, nx, ny)) {
							q.offer(new int[] {nx,ny,t+1});
							visited[nx][ny] = true;
							count++;
						}
					}
					break;
				case 3: // 좌 우
					for(int i=2;i<4;i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(isRange(n,m,nx,ny) && !visited[nx][ny] && isConnected(i, nx, ny)) {
							q.offer(new int[] {nx,ny,t+1});
							visited[nx][ny] = true;
							count++;
						}
					}
					break;
				case 4: // 상 우
					for(int i : new int[]{0,3}) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(isRange(n,m,nx,ny) && !visited[nx][ny] && isConnected(i, nx, ny)) {
							q.offer(new int[] {nx,ny,t+1});
							visited[nx][ny] = true;
							count++;
						}
					}
					break;
				case 5: // 하 우
					for(int i : new int[]{1,3}) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(isRange(n,m,nx,ny) && !visited[nx][ny] && isConnected(i, nx, ny)) {
							q.offer(new int[] {nx,ny,t+1});
							visited[nx][ny] = true;
							count++;
						}
					}
					break;
				case 6: // 하 좌
					for(int i : new int[]{1,2}) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(isRange(n,m,nx,ny) && !visited[nx][ny] && isConnected(i, nx, ny)) {
							q.offer(new int[] {nx,ny,t+1});
							visited[nx][ny] = true;
							count++;
						}
					}
					break;
				case 7: // 상 좌
					for(int i : new int[]{0,2}) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(isRange(n,m,nx,ny) && !visited[nx][ny] && isConnected(i, nx, ny)) {
							q.offer(new int[] {nx,ny,t+1});
							visited[nx][ny] = true;
							count++;
						}
					}
					break;
			}
		}
	}
	public static boolean isRange(int n , int m , int x , int y ) {
		return x>=0 && y>=0 && x<n && y<m;
	}
	public static boolean isConnected(int i,int x, int y) {
		if(i==0) {//상
			return (map[x][y]==1 || map[x][y]==2 || map[x][y]==5 || map[x][y]==6);
		}
		else if(i==1) {//하
			return (map[x][y]==1 || map[x][y]==2 || map[x][y]==4 || map[x][y]==7);
		}else if(i==2) {//좌
			return (map[x][y]==1 || map[x][y]==3 || map[x][y]==4 || map[x][y]==5);
		}else {//우
			return (map[x][y]==1 || map[x][y]==3 || map[x][y]==6 || map[x][y]==7);
		}
	}
}
