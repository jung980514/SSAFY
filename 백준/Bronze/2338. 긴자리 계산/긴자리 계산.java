import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // A, B 입력
        BigInteger A = new BigInteger(sc.nextLine());
        BigInteger B = new BigInteger(sc.nextLine());

        // 연산 수행
        BigInteger sum = A.add(B);
        BigInteger diff = A.subtract(B);
        BigInteger prod = A.multiply(B);

        // 결과 출력
        System.out.println(sum);
        System.out.println(diff);
        System.out.println(prod);

        sc.close();
    }
}