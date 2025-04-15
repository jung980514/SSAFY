import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final int mod = 1_000_000_007;
	public static void main(String[] args) throws IOException {
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		
		//nCk = n!/(n-k)!*k!
		//a^p-1 mod p = 1 mod p: 페르마 소정리
		//a^p-2 mod p = a^-1 mod p 
		long fn = factorial(n);
        long fk = factorial(k);
        long fnk = factorial(n - k);

        long nCk = fn * pow(fnk, mod - 2) % mod;
        nCk = nCk * pow(fk, mod - 2) % mod;
        System.out.println((nCk + mod) % mod);
	}
	public static long factorial(int n) {
		long result = 1;
		for(int i=1;i<=n;i++) {
			result = (result*i) % mod;
		}
		return result % mod;
	}
	public static long pow(long a, long b) {
		long result = 1;
        a %= mod;

        while (b>0) {
            if ((b&1) == 1) result = result * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return result;
	}
}
