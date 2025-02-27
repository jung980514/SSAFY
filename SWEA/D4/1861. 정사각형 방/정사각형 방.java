import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};	
	static int[][] map;
	static boolean[][] visited;
	static int[] result;
	static ArrayList<Integer> pos;
	public static void main(String[] args) throws IOException{
		int T  = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for(int j=0;j<n;j++) {
				String[] s = br.readLine().split(" ");
				for(int k=0;k<n;k++) {
					map[j][k] = Integer.parseInt(s[k]);
				}
			}
			result = new int[2];
			result[0] = Integer.MAX_VALUE;
			result[1] = 1;
			for(int x=0;x<n;x++) {
				for(int y=0;y<n;y++) {
					visited = new boolean[n][n];
					pos = new ArrayList<>();
					dfs(x,y,n,1);
					if(pos.size()>result[1]) {
						result[1] = pos.size();
						result[0] = pos.get(0);
					}
					if(pos.size()==result[1]) {
						result[0] = Math.min(result[0], pos.get(0));
					}
				}
			}
			System.out.println("#"+i+" "+result[0]+" "+result[1]);
			
		}
	}
	public static boolean isRange(int x,int y,int n) {
		if(x>=0 && x<n && y>=0 && y<n) return true;
		else return false;
	}
	public static void dfs(int x,int y,int n,int count) {
		visited[x][y] = true;
		pos.add(map[x][y]);
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isRange(nx,ny,n) && !visited[nx][ny] & Math.abs(map[nx][ny]-map[x][y])==1) {
				visited[nx][ny] = true;
				dfs(nx,ny,n,count+1);
				visited[nx][ny] = false;
			}
		}
	}
}