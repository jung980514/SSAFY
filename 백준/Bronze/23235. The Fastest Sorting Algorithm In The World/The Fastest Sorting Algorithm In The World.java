import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNumber = 1;  // 케이스 번호를 추적
        
        while (true) {
            int N = sc.nextInt();  // N을 입력받음
            
            if (N == 0) {
                break;  // N이 0이면 종료
            }
            
            // N개의 정수를 입력받아서 넘어감 (실제로 정렬은 필요 없음)
            for (int i = 0; i < N; i++) {
                sc.nextInt();  // 입력값을 받지만 사용하지 않음
            }
            
            // 케이스 번호와 함께 "Sorting... done!" 출력
            System.out.println("Case " + caseNumber + ": Sorting... done!");
            
            caseNumber++;  // 케이스 번호 증가
        }
        
        sc.close();
    }
}