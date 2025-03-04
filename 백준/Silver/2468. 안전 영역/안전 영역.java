import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		int n = Integer.parseInt(br.readLine());
		int maxValue = 0;
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(s[j]);
				maxValue = Math.max(maxValue, map[i][j]);
			}
		}
		int result=0;
		for(int i=maxValue;i>=0;i--) {
			visited = new boolean[n][n];
			int count=0;
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(map[j][k]>i && !visited[j][k]) {
						dfs(i,j,k);
						count++;
					}
				}
			}
			result = Math.max(result, count);
		}
		System.out.println(result);
	}
	public static void dfs(int i,int j,int k) {
		if(map[j][k]>i && !visited[j][k])
			visited[j][k] = true;
		else
			return;
		for(int d=0;d<4;d++) {
			int nj = j+dx[d];
			int nk = k+dy[d];
			if(nj<map.length && nk<map.length && nj>=0 && nk>=0)
				dfs(i,nj,nk);
		}
	}
}
