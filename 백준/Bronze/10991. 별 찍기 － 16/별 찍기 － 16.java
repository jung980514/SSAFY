import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i=1;i<=N;i++) {
            // 공백 출력
            for(int j=0;j<N-i;j++) {
                System.out.print(" ");
            }
            // 별 출력
            for(int j=1;j<=i;j++) {
                System.out.print("*");
                if(j != i) System.out.print(" ");
            }
            System.out.println();
        }
    }
}