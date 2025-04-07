import java.io.*;
import java.util.*;
/*
 * 메모리:11940KB
 * 시간:72ms
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] map;
	static boolean[][] visited;
	static int r,c,startX,startY,endX,endY;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int result = 0;
	static ArrayList<int[]> water = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		String[] s = br.readLine().split(" ");
		r = Integer.parseInt(s[0]);
		c = Integer.parseInt(s[1]);
		map = new char[r][c];
		visited = new boolean[r][c];
		for(int i=0;i<r;i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]=='S') {
					startX = i;
					startY = j;
				}
				else if(map[i][j]=='D') {
					endX = i;
					endY = j;
				}
				else if(map[i][j]=='*') {
					water.add(new int[] {i,j});
				}
				else if(map[i][j]=='X')
					visited[i][j] = true;
			}
		}
		bfs();
		System.out.println(result==0?"KAKTUS":result);
	}
	public static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		for(int[] w : water) {//물 시작 지점
			q.offer(new int[] {w[0],w[1],1,0});
			visited[w[0]][w[1]] = true;
		}
		//고슴도치 시작점
		q.offer(new int[] {startX,startY,0,0});
		visited[startX][startY] = true;
		
		A:while(!q.isEmpty()) {
			int[] tmp = q.poll();
			//고슴도치일때
			if(tmp[2]==0) {
				for(int i=0;i<4;i++) {
					int nx = tmp[0]+dx[i];
					int ny = tmp[1]+dy[i];
					//도착하면 break
					if(nx==endX && ny==endY) {
						result = tmp[3]+1;
						break A;
					}
					//물,돌이 없고 방문하지 않은 곳으로 이동
					if(isRange(nx,ny) && !visited[nx][ny]) {
						q.offer(new int[] {nx,ny,0,tmp[3]+1});
						visited[nx][ny] = true;
					}
				}
			}
			//물일때
			else {
				for(int i=0;i<4;i++) {
					int nx = tmp[0]+dx[i];
					int ny = tmp[1]+dy[i];
					//범위 안이고 비어있는 곳에 물 이동
					if(isRange(nx,ny) && !visited[nx][ny] && map[nx][ny]=='.') {
						q.offer(new int[] {nx,ny,1,tmp[3]+1});
						visited[nx][ny]= true;
					}
				}
			}
		}
	}
	public static boolean isRange(int x, int y) {
		return x>=0 && y>=0 && x<r && y<c;
	}
}
