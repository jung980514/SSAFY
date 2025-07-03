import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;


    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    static int find(int x) {
    	if (parent[x] == x) return x;
    	return parent[x] = find(parent[x]);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력: N 통나무 개수, Q 쿼리 개수
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int Q = Integer.parseInt(s[1]);

        int[] x1 = new int[N];
        int[] x2 = new int[N];
        int[] y  = new int[N];
        
        for (int i = 0; i < N; i++) {
            String[] s2 = br.readLine().split(" ");
            x1[i] = Integer.parseInt(s2[0]);
            x2[i] = Integer.parseInt(s2[1]);
            y[i]  = Integer.parseInt(s2[2]);
        }

        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        //Subtask1 전용 스캔: x = 0..1000 (좌표 범위 작음)
        List<Integer> list = new ArrayList<>();
        for (int x=0;x<=1000;x++) {
            list.clear();
            // 현재 x를 덮는 통나무 인덱스를 모두 수집
            for (int i = 0; i < N; i++) {
                if (x1[i] <= x && x <= x2[i]) {
                    list.add(i);
                }
            }
            if (list.size() < 2) continue;  // 2개 이상일 때만 연결 고려
            // y(높이) 오름차순 정렬 → 인접한 것들끼리 수직 점프 가능
            Collections.sort(list, Comparator.comparingInt(i -> y[i]));
            // 정렬된 리스트에서 이웃한 두 통나무를 union
            for (int i = 0; i + 1 < list.size(); i++) {
                union(list.get(i), list.get(i+1));
            }
        }

        // 두 통나무가 같은 컴포넌트인지 확인
        StringBuilder sb = new StringBuilder();
        for (int qi = 0; qi < Q; qi++) {
            String[] s3 = br.readLine().split(" ");
            int u = Integer.parseInt(s3[0]) - 1;
            int v = Integer.parseInt(s3[1]) - 1;
            // find(u)==find(v) 이면 이동 가능 → '1', 아니면 '0'
            sb.append(find(u) == find(v) ? '1' : '0').append('\n');
        }
        System.out.print(sb);
    }
}