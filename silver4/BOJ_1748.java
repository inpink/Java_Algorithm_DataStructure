import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함
	
	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String n = br.readLine();
		
		long ans=0l; //선언시에만 l을 붙여주면 된다
		long cnt=0l;
		
		for (int a=1; a<n.length(); a++) { //a=1~ len(n)-1
			cnt+=(9*Math.pow(10, a-1));
			ans+=(9*Math.pow(10, a-1)*a); //☆
			//bw.write(Long.toString(cnt)+" "+Long.toString(ans)+"\n");
		}
		
		//젤 큰 자리수는 따로 처리 
		ans+=((Long.parseLong(n)-cnt)*n.length());
		
		bw.write(Long.toString(ans));
		bw.flush(); bw.close();

	}
	


}
