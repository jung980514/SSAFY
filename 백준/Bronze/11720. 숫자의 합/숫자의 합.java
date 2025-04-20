import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 숫자의 개수
        String numbers = br.readLine(); // 공백 없이 이어진 숫자 문자열

        int sum = 0;
        for(int i=0;i<N;i++) {
            sum += numbers.charAt(i) - '0'; // 문자 → 숫자 변환 후 합산
        }

        System.out.println(sum);
    }
}