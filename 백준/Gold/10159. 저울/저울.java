import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());

        // heavier[i][j] == true 면 i번이 j번보다 무겁다는 뜻
        boolean[][] heavier = new boolean[N][N];

        for (int m = 0; m < M; m++) {
            String[] line = in.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            heavier[a][b] = true;
        }

        // 플로이드–워셜
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (!heavier[i][k]) continue;
                for (int j = 0; j < N; j++) {
                    if (heavier[k][j]) {
                        heavier[i][j] = true;
                    }
                }
            }
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int unknown = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                // i>j도 아니고 j>i도 아니라면 모르는 관계
                if (!heavier[i][j] && !heavier[j][i]) {
                    unknown++;
                }
            }
            out.append(unknown).append('\n');
        }

        System.out.print(out);
    }
}