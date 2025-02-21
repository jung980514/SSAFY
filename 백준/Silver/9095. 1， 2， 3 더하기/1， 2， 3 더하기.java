import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // dp 배열 생성 (최대 n = 10이므로 크기 11로 설정)
        int[] dp = new int[11];
        
        // 초기값 설정
        dp[0] = 1;  // 0을 만드는 방법은 1가지
        dp[1] = 1;  // 1을 만드는 방법은 1가지
        dp[2] = 2;  // 2를 만드는 방법은 2가지
        dp[3] = 4;  // 3을 만드는 방법은 4가지
        
        // dp 배열 채우기 (n이 4부터 10까지)
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        // 테스트 케이스 개수 입력
        int T = sc.nextInt();
        
        // 각 테스트 케이스에 대해 dp 값을 출력
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
        
        sc.close();
    }
}