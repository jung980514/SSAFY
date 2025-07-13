import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        
        int A = Integer.parseInt(parts[0]);  // 경쟁사 가격
        int B = Integer.parseInt(parts[1]);  // 경쟁사 성능
        int C = Integer.parseInt(parts[2]);  // WARBOY 가격
        
        // 2. 가격 대비 성능 비율 계산
        // 경쟁사 비율 = B / A
        // WARBOY 비율 = 3 * (B / A)
        // WARBOY 성능 = WARBOY 비율 * C = 3 * (B / A) * C
        int result = (B / A) * 3 * C;
        
        // 3. 결과 출력
        System.out.print(result);
    }
}