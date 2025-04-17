import java.io.*;

public class Main {
	static int M, N;
	static int[][] map, dp;
	static int[] dx = {1, -1, 0, 0}; // 열 이동
	static int[] dy = {0, 0, 1, -1}; // 행 이동
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);

		map = new int[M][N];
		dp = new int[M][N];

		for(int i=0;i<M;i++) {
			String[] row = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(row[j]);
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(0, 0));
	}

	static int dfs(int i, int j) {
		if(i == M-1 && j == N-1) return 1;
		if(dp[i][j] != -1) return dp[i][j];

		dp[i][j] = 0;

		for(int d=0;d<4;d++) {
			int ni = i + dy[d];
			int nj = j + dx[d];

			if(ni>=0 && nj>=0 && ni<M && nj<N) {
				if(map[ni][nj] < map[i][j]) {
					dp[i][j] += dfs(ni, nj);
				}
			}
		}

		return dp[i][j];
	}
}