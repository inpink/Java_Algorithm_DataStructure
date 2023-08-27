import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int n = Integer.parseInt(br.readLine());
        int ans, cutOff, usedN;
		double sum = 0;
		int[] arr = new int[n];

		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);
		cutOff = (int) Math.round(n*0.15);

		for(int i=cutOff; i<n-cutOff; i++) sum += arr[i];
        
        usedN=n-cutOff*2;
        ans=(int) Math.round(sum/(usedN));
		System.out.println(ans);
	}
}
