import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        String C = sc.next();  // C는 매우 큰 수이므로 문자열로 입력

        // C의 마지막 자리를 보고 홀/짝 판단
        char lastDigit = C.charAt(C.length() - 1);
        boolean isOdd = (lastDigit - '0') % 2 == 1;

        if (isOdd) {
            System.out.println(A ^ B);  // XOR 1번
        } else {
            System.out.println(A);  // XOR 짝수번 -> 변화 없음
        }
    }
}
