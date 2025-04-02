import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 지폐 개수
        int total = 0;

        for (int i = 0; i < N; i++) {
            int width = sc.nextInt();
            int height = sc.nextInt();

            // 세로 길이는 모두 68mm로 같으므로 가로 길이로만 판별
            switch (width) {
                case 136:
                    total += 1000;
                    break;
                case 142:
                    total += 5000;
                    break;
                case 148:
                    total += 10000;
                    break;
                case 154:
                    total += 50000;
                    break;
                default:
                    // 문제 조건상 가로 길이는 위 4개 중 하나이므로 예외 처리 안 해도 됨
                    break;
            }
        }

        System.out.println(total);
    }
}
