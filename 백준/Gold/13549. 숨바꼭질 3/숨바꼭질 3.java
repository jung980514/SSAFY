import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 200001;
    static int[] dp = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Arrays.fill(dp, Integer.MAX_VALUE);
        bfs(n);

        System.out.println(dp[k]);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        dp[start] = 0;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            // x * 2 (0초 이동)
            if (cur * 2 < MAX && dp[cur * 2] > dp[cur]) {
                dp[cur * 2] = dp[cur];
                q.offer(cur * 2);
            }

            // x + 1 (1초 이동)
            if (cur + 1 < MAX && dp[cur + 1] > dp[cur] + 1) {
                dp[cur + 1] = dp[cur] + 1;
                q.offer(cur + 1);
            }

            // x - 1 (1초 이동)
            if (cur - 1 >= 0 && dp[cur - 1] > dp[cur] + 1) {
                dp[cur - 1] = dp[cur] + 1;
                q.offer(cur - 1);
            }
        }
    }
}
