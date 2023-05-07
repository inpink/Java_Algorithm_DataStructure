package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함

	
	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    int s=Integer.parseInt(st.nextToken());
	    int t=Integer.parseInt(st.nextToken());
	    int d=Integer.parseInt(st.nextToken());
	    
	    int ans=d/(s*2)*t;
	    bw.write(Integer.toString(ans));
		bw.flush(); bw.close();
	}
}
