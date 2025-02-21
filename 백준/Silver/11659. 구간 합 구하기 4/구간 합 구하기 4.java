import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // N: 수의 개수, M: 합을 구해야 하는 횟수
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        // 수 배열 입력
        int[] arr = new int[N + 1];  // 1-based index 사용
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 누적 합 배열 계산
        int[] prefix = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        
        // 각 구간에 대해 합 계산
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            // start부터 end까지의 합: prefix[end] - prefix[start-1]
            System.out.println(prefix[end] - prefix[start - 1]);
        }
        
        sc.close();
    }
}