import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // dp[i] = i를 1로 만들기 위한 최소 연산 횟수 저장
        int[] dp = new int[n + 1];

        // from[i] = i가 어떤 숫자에서 왔는지 기록 
        int[] from = new int[n + 1];

        // dp 배열 초기화: 연산 횟수는 최대한 큰 값으로 초기화
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 1은 자기 자신이므로 연산 횟수 0
        dp[1] = 0;

        // 2부터 n까지 반복하면서 최소 연산 횟수 갱신
        for (int i = 2; i <= n; i++) {
            //  -1 연산
            if (dp[i - 1] + 1 < dp[i]) {
                dp[i] = dp[i - 1] + 1;
                from[i] = i - 1;
            }

            //  /2 연산 (i가 2의 배수인 경우)
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                from[i] = i / 2;
            }

            //  /3 연산 (i가 3의 배수인 경우)
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                from[i] = i / 3;
            }
        }

        // 최소 연산 횟수 출력
        System.out.println(dp[n]);

        // 경로 추적: n -> 1로 가는 경로를 저장
        StringBuilder sb = new StringBuilder();
        int current = n;

        while (current != 0) {
            sb.append(current).append(" ");
            current = from[current]; // 다음 숫자 = 현재 숫자가 오게 된 이전 숫자
        }

        // 경로 출력
        System.out.println(sb.toString().trim());
    }
}
