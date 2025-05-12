import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        // 한 셀 너비만큼의 '@' 문자열 생성
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) sb.append("@");
        String vert = sb.toString();    // 세로 기둥
        // 전체 가로 길이(5셀)만큼의 '@' 문자열 생성
        sb.setLength(0);
        for(int i = 0; i < 5 * N; i++) sb.append("@");
        String hori = sb.toString();    // 바닥 가로

        // 위쪽 4셀 높이만큼 세로 기둥 출력
        for(int i = 0; i < 4 * N; i++) {
            System.out.println(vert);
        }
        // 마지막 셀 높이만큼 바닥 가로 및 세로 기둥 출력
        for(int i = 0; i < N; i++) {
            System.out.println(hori);
        }
    }
}