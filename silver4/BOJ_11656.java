import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함

	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s= br.readLine();
		int len=s.length();
		String[] l = new String[len];
		
		for (int i=0; i<len; i++) l[i]=s.substring(i, len);
		
		Arrays.sort(l);
		for (int i=0; i<len; i++) bw.write(l[i]+"\n");
	    bw.flush(); bw.close(); 
	   }	
}

