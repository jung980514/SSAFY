import java.io.*;
import java.util.*;

// 선분을 나타내는 클래스
class Interval implements Comparable<Interval> {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // 시작점을 기준으로 오름차순 정렬
    @Override
    public int compareTo(Interval other) {
        return this.start - other.start;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 선을 그은 횟수 입력
        Interval[] lines = new Interval[n];

        // 선분 입력 받기
        for(int i=0;i<n;i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            lines[i] = new Interval(x, y);
        }

        // 시작점을 기준으로 정렬
        Arrays.sort(lines);

        // 초기 구간 설정
        int currentStart = lines[0].start;
        int currentEnd = lines[0].end;
        int totalLength = 0;

        // 모든 선분 순회하며 병합
        for(int i=1;i<n;i++) {
            // 현재 구간과 겹치는 경우 → 병합
            if(lines[i].start <= currentEnd) {
                currentEnd = Math.max(currentEnd, lines[i].end);
            } else {
                // 겹치지 않는 경우 → 이전 구간 길이 더하고 새 구간 시작
                totalLength += (currentEnd - currentStart);
                currentStart = lines[i].start;
                currentEnd = lines[i].end;
            }
        }

        // 마지막 구간 길이 추가
        totalLength += (currentEnd - currentStart);

        // 결과 출력
        System.out.println(totalLength);
    }
}