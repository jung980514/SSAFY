import java.util.*;
/**
 * 문제 분석
 * 1.핀볼은 사방탐색을 통해 이동하며 출발위치로 돌아오거나 블랙홀에 만나면 끝난다
 * 2.벽이나 블록에 부딪혀야 점수 증가되고 웜홀은 점수 포함 X, 블랙홀에 빠져서 게임이 끝나도 점수 유지
 * 3.웜홀을 만나면 같은 수의 다른 웜홀로 이동 방향은 그대로
 * 4.블록에 부딪히면 방향이 바뀌는데 
 * 	4-1.1번 블록 : v -> > , < -> ^ , > -> < , ^ -> V
 * 	4-2.2번 블록 : v -> ^ , < -> V , > -> < , ^ -> >
 * 	4-3.3번 블록 : v -> ^ , < -> > , > -> V , ^ -> <
 * 	4-4.4번 블록 : v -> < , < -> > , > -> ^ , ^ -> V
 * 	4-5.5번 블록 : v -> ^ , < -> > , > -> < , ^ -> V
 * 5.벽에 부딪히면 5번블록과 같이 방향이 180도 바뀐다
 * 6.출발 위치와 진행 방향 임의로 정할때, 게임에서 얻을 수 있는 최대값 
 * @author SSAFY
 *
 */
public class Solution {
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] wormhole;
    static int n, score, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            n = sc.nextInt();
            map = new int[n + 2][n + 2];
            wormhole = new int[5][4];
            result = 0;

            for (int i = 0; i < n + 2; i++) {
                Arrays.fill(map[i], 5); // 벽으로 초기화
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] >= 6) {
                        if (wormhole[map[i][j] - 6][0] == 0) {
                            wormhole[map[i][j] - 6][0] = i;
                            wormhole[map[i][j] - 6][1] = j;
                        } else {
                            wormhole[map[i][j] - 6][2] = i;
                            wormhole[map[i][j] - 6][3] = j;
                        }
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] == 0) {
                        for (int dir = 0; dir < 4; dir++) {
                            score = 0;
                            GameStart(i, j, dir);
                            result = Math.max(result, score);
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + result);
        }
        sc.close();
    }

    public static void GameStart(int i, int j, int dir) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j, dir});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int nx = tmp[0] + dx[tmp[2]];
            int ny = tmp[1] + dy[tmp[2]];

            if (nx == i && ny == j) break; // 출발 위치로 돌아옴
            if (map[nx][ny] == -1) break; // 블랙홀 도달

            if (map[nx][ny] == 0) {
                q.offer(new int[]{nx, ny, tmp[2]});
            } else if (map[nx][ny] >= 1 && map[nx][ny] <= 5) {
                int ndir = block(map[nx][ny], tmp[2]);
                score++;
                q.offer(new int[]{nx, ny, ndir});
            } else { // 웜홀
                int wormNum = map[nx][ny] - 6;
                if (wormhole[wormNum][0] == nx && wormhole[wormNum][1] == ny) {
                    q.offer(new int[]{wormhole[wormNum][2], wormhole[wormNum][3], tmp[2]});
                } else {
                    q.offer(new int[]{wormhole[wormNum][0], wormhole[wormNum][1], tmp[2]});
                }
            }
        }
    }

    public static int block(int n, int dir) {
        if (n == 1) {
            if (dir == 0) return 1;
            else if (dir == 1) return 3;
            else if (dir == 2) return 0;
            else return 2;
        } else if (n == 2) {
            if (dir == 0) return 3;
            else if (dir == 1) return 0;
            else if (dir == 2) return 1;
            else return 2;
        } else if (n == 3) {
            if (dir == 0) return 2;
            else if (dir == 1) return 0;
            else if (dir == 2) return 3;
            else return 1;
        } else if (n == 4) {
            if (dir == 0) return 1;
            else if (dir == 1) return 2;
            else if (dir == 2) return 3;
            else return 0;
        } else {
            if (dir == 0) return 1;
            else if (dir == 1) return 0;
            else if (dir == 2) return 3;
            else return 2;
        }
    }
}
