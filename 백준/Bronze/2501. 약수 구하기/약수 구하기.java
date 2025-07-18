import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);

        // 약수를 세면서 K번째일 때 바로 출력
        int count = 0;
        for(int i=1;i<=n;i++) {
            if(n % i == 0) {
                count++;
                if(count == k) {
                    System.out.println(i);
                    return;
                }
            }
        }

        // 약수의 개수가 K보다 적으면 0 출력
        System.out.println(0);
    }
}