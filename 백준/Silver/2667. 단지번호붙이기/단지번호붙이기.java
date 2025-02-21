import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int[][] map;
	public static boolean[][] visited;
	public static List<Integer> estates;
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {1,-1,0,0};	
	public static int count = 0;
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		estates = new ArrayList<>();
		for(int i=0;i<n;i++) {
			char[] c = br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				map[i][j] = c[j]-'0';
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					Dfs(i,j);
					estates.add(count);
					count=0;
				}
			}
		}
		Collections.sort(estates);
		System.out.println(estates.size());
		for(int estate : estates) {
			System.out.println(estate);
		}
	}
	
	public static void Dfs(int r,int c) {
		visited[r][c]=true;
		count++;
		for(int i=0;i<4;i++) {
			int nx = r + dx[i];
			int ny = c + dy[i];
			if(nx<0 || nx>=map.length || ny<0 || ny>=map.length) continue;
			if(map[nx][ny]==1 && !visited[nx][ny]) {
				Dfs(nx,ny);
			}
		}
	}
}