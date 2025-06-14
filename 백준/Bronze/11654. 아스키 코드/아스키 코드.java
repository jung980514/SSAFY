import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char ch = br.readLine().charAt(0); // 입력의 첫 문자만 읽음
        System.out.println((int)ch); // 아스키 코드 출력
    }
}