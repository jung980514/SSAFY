import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int D = Q - P;
        int[] k = new int[N];
        boolean possible = true;

        if (D == 0) {
            // P == Q 인 경우, 애초에 A[i]==B[i] 여야만 균형을 맞출 수 있음
            for (int i = 0; i < N; i++) {
                if (A[i] != B[i]) {
                    possible = false;
                    break;
                }
                k[i] = 0;
            }
        } else {
            // D != 0 인 경우, (A[i]-B[i]) 가 D로 나누어져야 하고,
            // 그 몫이 0 이상 10000 이하여야 함
            for (int i = 0; i < N; i++) {
                int diff = A[i] - B[i];
                if (diff % D != 0) {
                    possible = false;
                    break;
                }
                int ki = diff / D;
                if (ki < 0 || ki > 10000) {
                    possible = false;
                    break;
                }
                k[i] = ki;
            }
        }

        PrintWriter pw = new PrintWriter(System.out);
        if (!possible) {
            pw.println("NO");
        } else {
            pw.println("YES");
            for (int i = 0; i < N; i++) {
                pw.print(k[i]);
                if (i < N - 1) pw.print(' ');
            }
            pw.println();
        }
        pw.flush();
    }
}