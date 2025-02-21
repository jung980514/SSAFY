import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[] dna;
	static int[] contain;
	static int countA = 0;
	static int countC = 0;
	static int countG = 0;
	static int countT = 0;
	static int result = 0;
	static int[] delta = {-1,1};
	
	public static void checkDna(int i, int d) {
		switch (dna[i]) {
		case 'A':
			countA+=delta[d];
			break;
		case 'C':
			countC+=delta[d];
			break;
		case 'G':
			countG+=delta[d];
			break;
		case 'T':
			countT+=delta[d];
			break;
		default:
			break;
		}
	}
	public static boolean isDna() {
		if(countA >= contain[0] && countC >= contain[1] 
				&& countG >= contain[2] && countT >=contain[3])
			return true;
		else
			return false;
			
	}
	public static void main(String[] args) throws IOException{
		String[] str = br.readLine().split(" ");
		int s = Integer.parseInt(str[0]);
		int p = Integer.parseInt(str[1]);
		dna = br.readLine().toCharArray();
		String[] str2 = br.readLine().split(" ");
		contain = new int[4];
		contain[0] = Integer.parseInt(str2[0]);
		contain[1] = Integer.parseInt(str2[1]);
		contain[2] = Integer.parseInt(str2[2]);
		contain[3] = Integer.parseInt(str2[3]);
		
		for(int i=0;i<p;i++) {
			checkDna(i,1);
		}
		if(isDna())
			result++;
		
		for(int i=1;i<=s-p;i++) {
			checkDna(i-1,0);
			checkDna(i-1+p,1);
			if(isDna())
				result++;
		}
		System.out.println(result);
	}
}