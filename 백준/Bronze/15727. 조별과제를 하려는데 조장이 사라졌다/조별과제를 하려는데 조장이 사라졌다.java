import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int L = Integer.parseInt(br.readLine());
        int t = (L + 4) / 5; // ceil(L / 5.0)
        System.out.println(t);
    }
}
