import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄 입력: N, k
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // 점수 입력
        int[] scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        
        // 내림차순 정렬
        Arrays.sort(scores);
        
        // 커트라인 출력 (k번째 높은 점수 -> 인덱스 N-k)
        System.out.println(scores[N - k]);
    }
}
