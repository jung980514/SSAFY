import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] factory;
	static int count;
	public static void main(String[] args) throws IOException{
		int n = Integer.parseInt(br.readLine());
		factory = new int[n];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<s.length;i++) {
			factory[i] = Integer.parseInt(s[i]);
		}
		
		for(int i=0;i<factory.length;i++) {
			if(factory[i]==0) continue;
			if(i+2<factory.length && factory[i+1]> factory[i+2]) {
				int min = Math.min(factory[i], factory[i+1]-factory[i+2]);
				count += 5*min;
				factory[i] -= min;
				factory[i+1] -= min;
			}
			if(i+2<factory.length && factory[i]>=1 && factory[i+1]>=1 && factory[i+2]>=1) {
				int min =Math.min(Math.min(factory[i], factory[i+1]),factory[i+2]);
				count+=7*min;
				factory[i] -= min;
				factory[i+1] -= min;
				factory[i+2] -= min;
			}
			if(i+1<factory.length && factory[i]>=1 && factory[i+1]>=1) {
				int min = Math.min(factory[i], factory[i+1]);
				count += 5*min;
				factory[i] -= min;
				factory[i+1] -= min;
			}
			if(factory[i]>=1) {
				count +=3*factory[i];
				factory[i]=0;
			}
		}
		System.out.println(count);
		
	}
}