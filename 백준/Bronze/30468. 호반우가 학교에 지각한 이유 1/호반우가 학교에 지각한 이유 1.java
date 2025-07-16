import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int str = Integer.parseInt(input[0]);
        int dex = Integer.parseInt(input[1]);
        int intel = Integer.parseInt(input[2]); // int는 예약어라 intel로 사용
        int luk = Integer.parseInt(input[3]);
        int n = Integer.parseInt(input[4]);
        
        int sum = str + dex + intel + luk;
        int required = 4 * n;

        int result = Math.max(0, required - sum);
        System.out.println(result);
    }
}
