import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		String[] s = br.readLine().split(" ");
		int r = Integer.parseInt(s[1]);
		int c = Integer.parseInt(s[0]);
		char[][] str = new char[r][c];
		for(int i=0;i<c;i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j=0;j<r;j++) {
				str[j][i] = ch[j];
			}
		}
		Set<String> set = new HashSet<>();
		int count = -1;
		A:for(int i=0;i<c;i++) {
			for(int j=0;j<r;j++) {
				String st = String.valueOf(str[j], i, c-i);
				if(set.contains(st)) {
					break A;
				}
				else {
					set.add(st);
				}
			}
			set.clear();
			count++;
		}
		System.out.println(count==-1?0:count);
	}
}
