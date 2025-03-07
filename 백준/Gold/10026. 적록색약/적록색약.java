import java.io.*;
import java.util.*;
/*
 * 	메모리 12752KB
 * 	시간	92ms
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] map;
	static boolean[][] visited;
	static boolean[][] disabledVisited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};	
	static int count;
	static int disabledCount;
	//범위 안인지 체크
	public static boolean isRange(int x,int y,int n) {
		if(x>=0 && y>=0 && x<n && y<n) return true;
		else return false;
	}
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
		}
		visited = new boolean[n][n];
		disabledVisited = new boolean[n][n];
		//모든 배열 돌면서 방문이 안된 곳이면 dfs 혹은 적록색약dfs
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]) {
					Dfs(i,j,n);
					count++;
				}
				if(!disabledVisited[i][j]) {
					DisabledDfs(i,j,n);
					disabledCount++;
				}
			}
		}
		System.out.println(count +" "+disabledCount);
	}
	//범위안이고 방문하지 않았고 색이 같으면 다음 재귀로 이동
	public static void Dfs(int x,int y,int n) {
		visited[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isRange(nx,ny,n) && !visited[nx][ny] && map[x][y] == map[nx][ny]) {
				visited[nx][ny] = true;
				Dfs(nx,ny,n);
			}
		}
	}
	// 범위 안이고 방문하지 않았고 둘다 B가 아니거나 둘다 B면 다음 재귀로 이동
	public static void DisabledDfs(int x,int y,int n) {
		disabledVisited[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isRange(nx,ny,n) && !disabledVisited[nx][ny]) {
				if((map[x][y]!='B' && map[nx][ny]!='B') || (map[x][y]=='B' && map[nx][ny]=='B')) {
					disabledVisited[nx][ny] = true;
					DisabledDfs(nx,ny,n);
				}
			}
		}
	}
}
