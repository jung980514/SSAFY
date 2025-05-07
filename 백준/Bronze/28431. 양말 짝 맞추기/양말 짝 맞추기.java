import java.io.*;

public class Main {
    // BufferedReader + split()만 사용하여 입력 처리
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 0~9 숫자 등장 횟수 저장
        int[] cnt = new int[10];

        // 5개의 양말 숫자 입력
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());
            cnt[num]++;
        }

        // 짝이 없는(홀수인) 숫자 출력
        for (int i = 0; i < 10; i++) {
            if (cnt[i] % 2 == 1) {
                System.out.println(i);
                break;
            }
        }
    }
}
