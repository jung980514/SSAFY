import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 받기
        int N = sc.nextInt();
        
        // dp 배열 초기화
        int[] dp = new int[N + 1];
        
        // dp[1]은 0, 1에서 1로 가는 데 필요한 연산은 0번
        dp[1] = 0;
        
        // 2부터 N까지 최소 연산 횟수 계산
        for (int i = 2; i <= N; i++) {
            // 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;
            
            // 2로 나누어 떨어지면
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            
            // 3으로 나누어 떨어지면
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        
        // 결과 출력
        System.out.println(dp[N]);
        
        sc.close();
    }
}