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
		
		//입력받기
		StringTokenizer st0=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st0.nextToken());
		int k=Integer.parseInt(st0.nextToken());
		
		int[][] l = new int[n+1][4];
		
	    for (int i=1; i<=n;i++) {
	    	StringTokenizer st=new StringTokenizer(br.readLine());
	    	int idx=Integer.parseInt(st.nextToken()); //NUM
	    	l[idx][0]=idx;
	    	l[idx][1]=Integer.parseInt(st.nextToken()); //Gold
	    	l[idx][2]=Integer.parseInt(st.nextToken()); //Silver
	    	l[idx][3]=Integer.parseInt(st.nextToken()); //Bronze
	    }
	    
	    
	    int rank=1;
	    //중복 고려한순위 정해주기
	    for(int i=1; i<=n; i++) {
			if(l[i][1] > l[k][1]) {
				rank++;
			}
			else if(l[i][1] == l[k][1] && l[i][2] > l[k][2]) {
				rank++;
			}
			else if(l[i][1] == l[k][1] && l[i][2] == l[k][2] && l[i][3] > l[k][3]) {
				rank++;
			}
		}
	    
	    bw.write(Integer.toString(rank)); bw.flush(); bw.close(); 
	   }	
}

