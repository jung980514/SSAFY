import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner sc = new Scanner(System.in);
        
        // BigInteger로 A, B를 입력받기
        BigInteger A = sc.nextBigInteger();
        BigInteger B = sc.nextBigInteger();
        
        // A + B를 출력
        System.out.println(A.add(B));
        
        // Scanner 자원 반환
        sc.close();
    }
}