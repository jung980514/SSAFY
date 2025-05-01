import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        int[] order = new int[n];         // 입력 순서 저장

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            order[i] = i;
        }

        // 사전순 정렬용 인덱스 배열
        Integer[] sort = new Integer[n];
        for (int i = 0; i < n; i++) sort[i] = i;
        Arrays.sort(sort, (a, b) -> words[a].compareTo(words[b]));

        // 인접한 정렬된 쌍의 LCP 계산
        int[] lcp = new int[n];
        lcp[0] = 0;
        for (int i = 1; i < n; i++) {
            lcp[i] = findPrefix(words[sort[i-1]], words[sort[i]]);
        }

        // 최대 접두사 길이 찾기
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            if (lcp[i] > maxLen) {
                maxLen = lcp[i];
            }
        }

        // 클러스터 단위로 묶어서, 입력 순서 기준 가장 앞선 S,T 찾기
        int ans1 = -1, ans2 = -1;
        int bestSorder = Integer.MAX_VALUE, bestTorder = Integer.MAX_VALUE;

        int start = 0;
        for (int i = 1; i <= n; i++) {
            // 클러스터 경계: lcp[i] < maxLen 이거나 배열 끝
            if (i == n || lcp[i] < maxLen) {
                if (i - start >= 2) {
                    // sort[start..i-1] 이 한 덩어리(cluster)
                    // 1) S: 해당 군에서 입력 순서 가장 빠른 단어
                    int Sidx = sort[start];
                    int Sorder = order[Sidx];
                    for (int k = start + 1; k < i; k++) {
                        int idx = sort[k];
                        if (order[idx] < Sorder) {
                            Sorder = order[idx];
                            Sidx = idx;
                        }
                    }

                    // 2) T: S가 뽑힌 뒤, 나머지 중 입력 순서 가장 빠른 단어
                    int Tidx = -1;
                    int Torder = Integer.MAX_VALUE;
                    for (int k = start; k < i; k++) {
                        int idx = sort[k];
                        if (idx == Sidx) continue;
                        if (order[idx] < Torder) {
                            Torder = order[idx];
                            Tidx = idx;
                        }
                    }

                    // 3) 지금 군의 (Sorder, Torder) 를 전 군(bestSorder, bestTorder) 와 lex 비교
                    if (Sorder < bestSorder
                     || (Sorder == bestSorder && Torder < bestTorder)) {
                        bestSorder = Sorder;
                        bestTorder = Torder;
                        ans1 = Sidx;
                        ans2 = Tidx;
                    }
                }
                start = i;
            }
        }

        // 출력은 항상 원래 입력 순서 기준으로 S, T
        if (order[ans1] < order[ans2]) {
            System.out.println(words[ans1]);
            System.out.println(words[ans2]);
        } else {
            System.out.println(words[ans2]);
            System.out.println(words[ans1]);
        }
    }

    // 두 문자열의 공통 접두사 길이 계산
    public static int findPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) return i;
        }
        return len;
    }
}