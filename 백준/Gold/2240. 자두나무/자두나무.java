import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T: 자두가 떨어지는 시간(초), W: 이동 가능한 최대 횟수
        String[] tw = br.readLine().split(" ");
        int T = Integer.parseInt(tw[0]);
        int W = Integer.parseInt(tw[1]);

        // tree[i] = i초에 자두가 떨어지는 나무 번호 (1 또는 2)
        int[] tree = new int[T + 1]; // 1초부터 시작
        for (int i = 1; i <= T; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        // dp[t][w] = t초에 w번 움직였을 때 받을 수 있는 자두 최대 개수
        int[][] dp = new int[T + 1][W + 1];

        // DP 점화식 수행
        for (int t = 1; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                // 현재 w번 이동한 상태에서 자두가 서 있는 위치
                // 처음은 1번 위치에 있음 → w가 짝수면 1번, 홀수면 2번 나무 아래
                int pos = (w % 2) + 1;

                // 자두가 떨어지는 나무 == 현재 위치라면 자두를 받을 수 있음
                if (tree[t] == pos) {
                    if (w == 0) {
                        // 이동하지 않은 상태에서는 이전 상태에서 이어 받기
                        dp[t][w] = dp[t - 1][w] + 1;
                    } else {
                        // 이동하지 않은 상태와, 이전에 이동한 상태 중 큰 값 + 1
                        dp[t][w] = Math.max(dp[t - 1][w], dp[t - 1][w - 1]) + 1;
                    }
                } else {
                    if (w == 0) {
                        // 이동 없이, 위치가 다르면 못 받음
                        dp[t][w] = dp[t - 1][w];
                    } else {
                        // 현재 위치에서는 못 받지만, 이동해서 받을 수 있었는지는 비교
                        dp[t][w] = Math.max(dp[t - 1][w], dp[t - 1][w - 1]);
                    }
                }
            }
        }

        // 최대 자두 개수 찾기 (T초까지 끝났을 때 가능한 w값 전체 중 최댓값)
        int max = 0;
        for (int w = 0; w <= W; w++) {
            max = Math.max(max, dp[T][w]);
        }

        System.out.println(max);
    }
}
