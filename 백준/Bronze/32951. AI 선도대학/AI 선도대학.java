import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받은 연도를 정수로 변환
        int N = Integer.parseInt(br.readLine());
        // 2024년으로부터 지난 년수 계산 및 출력
        System.out.println(N - 2024);
        br.close();
    }
}