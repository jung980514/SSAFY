import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] map;
	static int[] output;
	static int result=0;
	static int[][] isConnected;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		map = new char[5][5];
		output = new int[7];
		for(int i=0;i<5;i++) {
			map[i] = br.readLine().toCharArray();
		}
		Combination(0,0,0,0);
		System.out.println(result);
	}
	public static void Combination(int depth, int start,int s, int y) {
		if(s>=4 && depth == 7) {
			isConnected = new int[5][5];
			for(int i=0;i<7;i++) {
				isConnected[output[i]/5][output[i]%5] = 1;
			}
			visited = new boolean[5][5];
			int cnt= dfs(output[0]/5,output[0]%5);
			if(cnt==7) result++;
			return;
		}
		if(y>=4)
			return;
		for(int i=start;i<25;i++) {
			output[depth] = i;
			if(map[i/5][i%5]=='Y')
				Combination(depth+1,i+1,s,y+1);
			else
				Combination(depth+1,i+1,s+1,y);			
		}
	}
	public static int dfs(int x, int y) {
	    visited[x][y] = true;
	    int cnt = 1;

	    int[] dx = {-1,1,0,0};
	    int[] dy = {0,0,-1,1};

	    for (int i=0;i<4;i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];

	        if (isRange(nx,ny) && isConnected[nx][ny]==1 && !visited[nx][ny]) {
	            cnt += dfs(nx,ny); // 방문한 만큼 누적
	        }
	    }

	    return cnt;
	}

	public static boolean isRange(int x,int y) {
		return x>=0 && y>=0 && x<5 && y<5;
	}
}
