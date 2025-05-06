import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int sum = 0;
        for (String s : input) {
            int num = Integer.parseInt(s);
            sum += num * num;
        }
        System.out.println(sum % 10);
    }
}