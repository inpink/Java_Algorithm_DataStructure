import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함

	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
	    
	    int n=Integer.parseInt(br.readLine());
	    String[] l=new String[3];
	    HashMap<String,String> map= new HashMap<>();
	    
	    for (int i=0; i<n; i++) {
	    	l=br.readLine().split(" ");
	    	map.put(l[0], l[2]);
	    }
	    
	    int count=Integer.parseInt(br.readLine());
	    for (int i=0; i<count; i++) {
	    	int m=Integer.parseInt(br.readLine());
	    	StringBuilder sb=new StringBuilder();
	    	StringTokenizer st= new StringTokenizer(br.readLine());
	    	for (int j=0; j<m; j++) {
	    		sb.append(map.get(st.nextToken())); sb.append(" ");
	    	}
	    	bw.write(sb.toString()+"\n");
	    }
	    
		bw.flush(); bw.close();
	}
}
