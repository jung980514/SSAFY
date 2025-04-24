import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int B = Integer.parseInt(br.readLine());
        int A = B * 10 / 11;
        System.out.println(A);
    }
}