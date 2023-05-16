package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함

	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
	        //Input, Data
	        int n=Integer.parseInt(br.readLine());
			
	        List<Integer> l = new ArrayList<>();
	        HashMap<Integer,Integer> map=new HashMap<>();
	        
	        int p,num;
	        StringBuilder sb=new StringBuilder();
	        
	        for (int i=0; i<n; i++) {
	        	StringTokenizer st=new StringTokenizer(br.readLine());
	        	p=Integer.parseInt(st.nextToken());
	        	for (int j=0; j<p; j++) {
	        		num=Integer.parseInt(st.nextToken());
	        		l.add(num);
	        		map.put(num, i); //10:0, 40:0, 50:0, 20:1...
	        	}
	        }
	        
	        //Main Logic
			Collections.sort(l);
			
			for (int i=0; i<l.size(); i++) {
				p=map.get(l.get(i));
				sb.append((char) (p+65));
			}
	        
			//Output
	        bw.write(sb.toString());
			bw.flush(); bw.close();
	   }
}

