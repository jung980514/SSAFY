import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int INF = Integer.MAX_VALUE;

    // Trie 노드
    static class Node {
        Node[] next = new Node[26];
        int first = INF, second = INF; // 이 노드를 지나는 단어 중 입력 순서가 빠른 두 개 저장
    }

    static Node root = new Node();
    static int maxLen = 0;
    static int bestS = INF, bestT = INF;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        // 입력 단어 및 Trie에 삽입
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            insert(words[i], i);
        }

        // Trie 탐색으로 최대 접두사와 단어 쌍 찾기
        dfs(root, 0);

        // 원래 입력 순서대로 출력
        if (bestS > bestT) { int tmp = bestS; bestS = bestT; bestT = tmp; }
        System.out.println(words[bestS]);
        System.out.println(words[bestT]);
    }

    // 트라이에 단어 삽입, 노드마다 first/second 갱신
    static void insert(String s, int idx) {
        Node cur = root;
        for (int d=1;d<=s.length();d++) {
            int c = s.charAt(d-1)-'a';
            if (cur.next[c] == null) cur.next[c] = new Node();
            cur = cur.next[c];
            // 현재 idx를 노드의 first/second에 반영
            if (idx < cur.first) {
                cur.second = cur.first;
                cur.first = idx;
            } else if (idx < cur.second) {
                cur.second = idx;
            }
        }
    }

    // DFS로 노드 탐색, depth: 트리 깊이(접두사 길이)
    static void dfs(Node node, int depth) {
        if (node == null) return;
        // 두 개 이상의 단어가 이 접두사를 공유하면 candidate
        if (node.second < INF) {
            if (depth > maxLen
             || (depth == maxLen && (node.first < bestS
                                     || (node.first == bestS && node.second < bestT)))
            ) {
                maxLen = depth;
                bestS = node.first;
                bestT = node.second;
            }
        }
        for (int i = 0; i < 26; i++) {
            dfs(node.next[i], depth + 1);
        }
    }
}