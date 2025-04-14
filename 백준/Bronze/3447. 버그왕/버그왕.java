import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            // BUG가 더 이상 없을 때까지 반복해서 제거
            while (line.contains("BUG")) {
                line = line.replace("BUG", "");
            }
            System.out.println(line);
        }
    }
}
