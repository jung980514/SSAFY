import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 0! = 1 처리
        if (N == 0) {
            System.out.println(1);
            return;
        }
        
        // 1부터 N까지 BigInteger로 최소 힙에 넣기
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            pq.add(BigInteger.valueOf(i));
        }
        
        // 항상 가장 작은 두 수를 꺼내 곱한 뒤 다시 넣기
        while (pq.size() > 1) {
            BigInteger a = pq.poll();
            BigInteger b = pq.poll();
            pq.offer(a.multiply(b));
        }
        
        // 결과 출력
        System.out.println(pq.poll());
    }
}
