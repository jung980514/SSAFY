import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: 참가자 수 N, 예산 B, 호텔 수 H, 주 수 W
        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int B = Integer.parseInt(first[1]);
        int H = Integer.parseInt(first[2]);
        int W = Integer.parseInt(first[3]);

        int answer = B + 1;  // 예산을 넘는 값으로 초기화

        // 각 호텔 정보 처리
        for(int i=0;i<H;i++){
            int p = Integer.parseInt(br.readLine());        // 1인당 숙박비용
            String[] weeks = br.readLine().split(" ");      // 각 주의 수용 인원

            int cost = N * p;
            // 예산을 넘으면 굳이 주별 확인할 필요 없음
            if(cost > B) continue;

            // 수용 가능한 주가 하나라도 있으면 후보
            for(int j=0;j<W;j++){
                int a = Integer.parseInt(weeks[j]);
                if(a >= N){
                    if(cost < answer) {
                        answer = cost;
                    }
                    break;  // 이 호텔은 이미 가능하므로 다음 호텔로
                }
            }
        }

        // 결과 출력
        if(answer <= B) {
            System.out.println(answer);
        } else {
            System.out.println("stay home");
        }
    }
}