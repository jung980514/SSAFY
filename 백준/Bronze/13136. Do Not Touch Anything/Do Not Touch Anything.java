import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 표준 입력을 위한 BufferedReader 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력: R C N
        String[] parts = br.readLine().split(" ");
        long R = Long.parseLong(parts[0]);
        long C = Long.parseLong(parts[1]);
        long N = Long.parseLong(parts[2]);
        
        // 세로 방향으로 필요한 CCTV 대수 = ceil(R / N)
        long rows = (R + N - 1) / N;
        // 가로 방향으로 필요한 CCTV 대수 = ceil(C / N)
        long cols = (C + N - 1) / N;
        
        // 전체 필요 CCTV = rows * cols
        System.out.println(rows * cols);
    }
}