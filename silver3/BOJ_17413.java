package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main { //class name은 Main 이어야 함
	public static void main(String[] args) throws IOException { //예외처리 꼭 해줘야 함
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] l=br.readLine().split(""); //하나하나씩 자름
		
		StringBuilder sb=new StringBuilder();
		
		boolean isThan=false; 
		
		//자바에서 배열[]은 크기 꽉차면 늘려줄 수 X. List는 가능함.
		List<String> tmp= new ArrayList<>();
		 
		for (int i=0; i<l.length;i++) {
			
			//< > 때문에 그냥 넣어줘야 하는 경우를 먼저 판단함
			if (l[i].equals("<")) {
				for (int j=tmp.size()-1; j>=0;j--) sb.append(tmp.remove(j)); //<를 만났을때도 단어끝이므로 모아놓은것 꺼내줘야함
				isThan=true;
				sb.append(l[i]);
			}
			else if (l[i].equals(">")) {
				isThan=false;
				sb.append(l[i]);
			}
			else if (isThan==true) sb.append(l[i]);
			
			//여기서부터는 뒤집어줘야 하는 범위임.
			else if (l[i].equals(" ")) { //공백인 경우, 지금까지 모아온것 뒤에서부터 꺼내서 넣어줌
				for (int j=tmp.size()-1; j>=0;j--) sb.append(tmp.remove(j));
				sb.append(" ");
			}
			
			else { //뒤집어줘야 하는 실제 문자들임
				tmp.add(l[i]);
			}
		}
		
		//마지막에 tmp에 남아있는 문자 있을수 있으니 한 번 더
		for (int j=tmp.size()-1; j>=0;j--) sb.append(tmp.remove(j));
		
		System.out.print(sb.toString());
    }
	
		
		
}
	
