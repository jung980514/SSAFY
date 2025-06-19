import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 총 자리 수
        int K = Integer.parseInt(input[1]); // 제거할 개수
        int toPick = N - K;                 // 남길 숫자 개수

        String number = br.readLine(); // 전체 숫자 문자열
        StringBuilder answer = new StringBuilder();

        int start = 0; // 현재 탐색 시작 인덱스
        for(int i = 0; i < toPick; i++) {
            // 남은 숫자 중 선택 가능한 최대 인덱스 (K개의 삭제 기회 고려)
            int end = K + i;
            char maxDigit = '0';
            int maxIndex = start;

            // [start ~ end] 구간 중 가장 큰 숫자 찾기
            for(int j = start; j <= end; j++) {
                if(number.charAt(j) > maxDigit) {
                    maxDigit = number.charAt(j);
                    maxIndex = j;

                    // 가장 큰 숫자인 9면 바로 break (더 이상 볼 필요 없음)
                    if(maxDigit == '9') break;
                }
            }

            answer.append(maxDigit);
            start = maxIndex + 1; // 다음 선택은 그 다음 자리부터
        }

        // 결과 출력
        System.out.println(answer.toString());
    }
}