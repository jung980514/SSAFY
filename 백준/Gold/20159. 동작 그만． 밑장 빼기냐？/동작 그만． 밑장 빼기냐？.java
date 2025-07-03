import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(in[i]);
        }

        int m = n / 2;                 // 정훈이가 받는 턴 수
        long evenSum = 0;              // 밑장 없이 받는 짝수 인덱스 카드 합
        for (int k = 0; k < m; k++) {
            evenSum += cards[2 * k];
        }

        // suffixDiff[t] = ∑_{u=t+1..m-1}(cards[2u] - cards[2u-1])
        long[] suffixDiff = new long[m];
        suffixDiff[m - 1] = 0;
        for (int t = m - 2; t >= 0; t--) {
            suffixDiff[t] = suffixDiff[t + 1]
                          + (cards[2 * (t + 1)]     // 원래 내 차례 카드
                           - cards[2 * (t + 1) - 1] // 원래 상대 차례 카드
                          );
        }

        long ans = evenSum;  // 밑장 없이 그대로 받았을 때

        // 각 턴 t = 0..m-1 에서
        //  • 상대 턴(홀수 배분) 밑장: oppScore = evenSum - suffixDiff[t]
        //  • 정훈 턴(짝수 배분) 밑장: jScore   = evenSum - cards[2*t] + cards[n-1] - suffixDiff[t]
        for (int t = 0; t < m; t++) {
            // 1) 상대에게 줄 때 밑장 → 내 카드 변화만큼만 반영
            long oppScore = evenSum - suffixDiff[t];
            if (oppScore > ans) ans = oppScore;

            // 2) 내 차례에 밑장 → 내 차례 카드 하나 바뀜 + 뒤쪽 밀림 보정
            long jScore = evenSum
                        - cards[2 * t]   // 원래 t번째 내 카드 제거
                        + cards[n - 1]   // 밑장에서 뽑아온 카드 추가
                        - suffixDiff[t]; // 뒤쪽 밀림 보정
            if (jScore > ans) ans = jScore;
        }

        System.out.println(ans);
    }
}