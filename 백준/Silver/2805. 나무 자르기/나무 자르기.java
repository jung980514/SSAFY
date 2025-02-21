import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		String[] strTree = br.readLine().split(" ");
		Integer[] trees = new Integer[n];
		for(int i=0;i<strTree.length;i++) {
			trees[i] = Integer.parseInt(strTree[i]);
		}
		int max = 0;
		for(int i=0;i<trees.length;i++) {
			if(max<trees[i])
				max = trees[i];
		}
		// 이분 탐색
        int left = 0, right = max;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long total = 0; // 자른 나무 길이 합

            for (int tree : trees) {
                if (tree > mid) { // mid 보다 큰 나무만 잘린다.
                    total += tree - mid;
                }
            }

            if (total >= m) { // 충분히 가져갈 수 있다면, 더 높은 톱 높이 탐색
                answer = mid;
                left = mid + 1;
            } else { // 부족하면 톱을 낮춘다.
                right = mid - 1;
            }
        }
        System.out.println(answer);
	}
}