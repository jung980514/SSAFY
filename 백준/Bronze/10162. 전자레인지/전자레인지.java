import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 목표 시간(초)

        // 10초 단위로만 맞출 수 있으므로, 10으로 나누어떨어지지 않으면 불가능
        if (T % 10 != 0) {
            System.out.println(-1);
            return;
        }

        // 그리디: 가장 큰 버튼부터 최대한 누르기
        int a = T / 300;  // A 버튼(5분 = 300초)
        T %= 300;

        int b = T / 60;   // B 버튼(1분 = 60초)
        T %= 60;

        int c = T / 10;   // C 버튼(10초)
        
        // 결과 출력: A B C 누른 횟수
        System.out.println(a + " " + b + " " + c);
    }
}