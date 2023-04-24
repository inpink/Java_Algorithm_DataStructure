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
		
		int n=Integer.parseInt(br.readLine());
		String tmpName,tmpState;
		
		HashMap<String,Integer> map = new HashMap<>();
		
		
		for (int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tmpName=st.nextToken();
			tmpState=st.nextToken();
			if (tmpState.equals("enter")) map.put(tmpName, 1); //이미 있는 값이면 ☆replace☆된다!
			else map.put(tmpName, 0);
		}
		
		List<String> ans = new ArrayList<>();
		
		for (String tmp : map.keySet()) { //key들의 Set를 반환
			if (map.get(tmp)==1) {
				ans.add(tmp);
			}
		}
		
		Collections.sort(ans);
		
		for (int i=ans.size()-1; i>=0; i--) {
			bw.write(ans.get(i));
			bw.write("\n");
		}
		
		//bw.write(map.toString()); 
		bw.flush(); bw.close();

	}
	

}
