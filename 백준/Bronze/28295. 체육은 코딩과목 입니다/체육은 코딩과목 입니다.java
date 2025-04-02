import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 방향: 0 = 북(N), 1 = 동(E), 2 = 남(S), 3 = 서(W)
        int direction = 0;

        for (int i = 0; i < 10; i++) {
            int command = sc.nextInt();
            if (command == 1) {
                direction += 1; // 우향우
            } else if (command == 2) {
                direction += 2; // 뒤로 돌아
            } else if (command == 3) {
                direction -= 1; // 좌향좌
            }
        }

        // 방향을 0~3 사이로 맞춤 (음수 보정 포함)
        direction = (direction % 4 + 4) % 4;

        // 방향 매핑 배열
        char[] dirMap = {'N', 'E', 'S', 'W'};

        // 결과 출력
        System.out.println(dirMap[direction]);
    }
}
