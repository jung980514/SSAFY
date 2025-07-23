import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 표준 입력을 위한 BufferedReader 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int totalScore = 0;
        // 5회 게임 점수를 한 줄씩 읽어 합산
        for (int i = 0; i < 5; i++) {
            // 줄 단위로 읽은 후 정수로 변환
            int score = Integer.parseInt(br.readLine().trim());
            totalScore += score;
        }
        
        // 결과 출력
        System.out.println(totalScore);
        
        br.close();
    }
}