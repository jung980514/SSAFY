import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map = new int[6][3]; // 팀마다 승 무 패
						//할수있는 경기 15경기
	static int[] teamA = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int[] teamB = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static boolean flag;

	public static void main(String[] args) throws IOException {
		for(int t=0;t<4;t++) {
			String[] s = br.readLine().split(" ");
			int idx=0;
			for(int i=0;i<6;i++) {
				for(int j=0;j<3;j++) {
					map[i][j]=Integer.parseInt(s[idx++]);
				}
			}

			flag=false;
			
			if(isWorldCup()) 
				dfs(0);
			System.out.print(flag?"1 ":"0 ");
		}
	}
	//각 팀의 승,무,패 합이 5이고 전체 합이 30이어야 가능
	public static boolean isWorldCup() {
		int total=0;
		for(int i=0;i<6;i++) {
			int sum=map[i][0]+map[i][1]+map[i][2];
			if(sum!=5) 
				return false;
			total+=sum;
		}
		return total==30;
	}

	public static void dfs(int depth) {
		if(depth==15) {
			flag=true;
			return;
		}
		
		int a=teamA[depth];
		int b=teamB[depth];
		
		//A승 B패
		if(map[a][0]>0 && map[b][2]>0) {
			//백트래킹
			map[a][0]--; 
			map[b][2]--;
			dfs(depth+1);
			map[a][0]++; 
			map[b][2]++;
		}
		//A무 B무
		if(map[a][1]>0 && map[b][1]>0) {
			//백트래킹
			map[a][1]--; 
			map[b][1]--;
			dfs(depth+1);
			map[a][1]++; 
			map[b][1]++;
		}
		//A패 B승
		if(map[a][2]>0 && map[b][0]>0) {
			//백트래킹
			map[a][2]--; 
			map[b][0]--;
			dfs(depth+1);
			map[a][2]++; 
			map[b][0]++;
		}
	}
}
