import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄: 세로 길이 A
        int A = Integer.parseInt(br.readLine());
        // 두 번째 줄: 가로 길이 B
        int B = Integer.parseInt(br.readLine());
        
        // 넓이 계산 및 출력
        int area = A * B;
        System.out.println(area);
    }
}