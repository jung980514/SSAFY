import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long N = Long.parseLong(br.readLine());  // N도 long으로
        
        // 1) 전체 상금의 22% 세금 납부 → 남는 78%
        long case1 = N * 78 / 100;
        
        // 2) 80% 필요경비 인정 → 과세 대상 20% 중 22% 세금 → 최종 수령 비율 0.956
        long case2 = N * 956 / 1000;  // 956은 long 리터럴이어서 N*956 연산은 long
        
        System.out.println(case1 + " " + case2);
    }
}
