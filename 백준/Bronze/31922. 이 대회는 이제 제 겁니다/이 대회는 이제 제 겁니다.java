import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int P = Integer.parseInt(s[1]);
        int C = Integer.parseInt(s[2]);

        int div1Prize = A + C;
        int div2Prize = P;

        System.out.println(Math.max(div1Prize, div2Prize));
    }
}