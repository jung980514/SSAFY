import java.io.*;
import java.util.*;

public class Main {
    // BufferedReader + split() 방식으로만 입력을 처리합니다.
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        // 입력: x0, N
        String[] in = br.readLine().split(" ");
        long a = Long.parseLong(in[0]);
        long N = Long.parseLong(in[1]);

        // 사이클 탐지를 위해 이미 본 값을 저장할 집합
        Set<Long> seen = new HashSet<>();

        // 1) N만큼 반복하면서 사이클 진입 지점 탐색
        //    f(x)를 바로 적용한 결과를 seen에 추가해보고, 이미 있으면 사이클 시작점 발견
        while (N-- > 0) {
            a = f(a);
            if (!seen.add(a)) {
                // 사이클이 시작된 순간 탈출
                break;
            }
        }

        // 2) N번 모두 돌았다면(사이클 없이), 최종값 출력 후 종료
        if (N < 0) {
            System.out.println(a);
            return;
        }

        // 3) 사이클을 이루는 값을 리스트에 모은다.
        //    'a'가 사이클의 시작값이고, f(a)를 반복 적용해 다시 a가 나올 때까지 기록
        List<Long> cycle = new ArrayList<>();
        long start = a;
        cycle.add(start);
        long x = f(start);
        while (x != start) {
            cycle.add(x);
            x = f(x);
        }

        // 4) 남은 반복 횟수 N을 사이클 길이로 나눈 나머지만큼 이동한 값을 출력
        int len = cycle.size();
        // 음수가 나올 수도 있으니 안전하게 정규화
        int idx = (int)(((N % len) + len) % len);
        System.out.println(cycle.get(idx));
    }

    // 문제에서 정의한 상태 전이 함수:
    // 짝수 → floor(x/2) xor 6,  홀수 → (2*x) xor 6
    static long f(long x) {
        if ((x & 1) == 0) {
            // 짝수일 때
            return (x >> 1) ^ 6L;
        } else {
            // 홀수일 때
            return (x << 1) ^ 6L;
        }
    }
}
