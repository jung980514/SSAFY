import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner sc = new Scanner(System.in);
        
        // 첫 번째 줄에서 n을 입력받음
        int n = sc.nextInt();
        
        // 합을 저장할 변수
        int sum = 0;
        
        // n개의 정수를 입력받고 합산
        for (int i = 0; i < n; i++) {
            sum += sc.nextInt();  // 정수를 입력받아 합산
        }
        
        // 결과 출력
        System.out.println(sum);
        
        // Scanner 자원 반환
        sc.close();
    }
}