import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[][] map;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
//		for(int i=0;i<n;i++) {
//			graph.add(new ArrayList<>());
//		}
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(s[j]);
//				if(map[i][j]!=0) {
//					graph.get(i).add(j);
//				}
			}
		}
		visited = new boolean[n];
		result = Integer.MAX_VALUE;
		//시작위치를 제외한 나머지 위치 순열로 뽑기
		Permutation(0,n,0,0);
		System.out.println(result);
	}
	public static void Permutation(int depth,int n,int from,int cost) {
		if(depth == n-1) {
			//다 돌고 처음위치로 돌아올때 갈수있는지 체크후 갈수 있으면 돌아옴
			if(map[from][0]!=0)
				result = Math.min(result, cost+map[from][0]);
			return;
		}
		for(int i=1;i<n;i++) {
			//갈수없으면 무시
			if(map[from][i]==0) continue;
			//방문하지 않은 곳이면 다음위치로
			if(!visited[i]) {
				visited[i] = true;
				Permutation(depth+1,n,i,cost+map[from][i]);
				visited[i] = false;
			}
		}
	}
}