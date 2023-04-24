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
		
		int[][] l=new int[101][101];
		int ans=0;
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		int x1,y1,x2,y2;
		for (int i=0; i<n; i++) {
			StringTokenizer st2=new StringTokenizer(br.readLine());
			x1= Integer.parseInt(st2.nextToken());
			y1= Integer.parseInt(st2.nextToken());
			x2= Integer.parseInt(st2.nextToken());
			y2= Integer.parseInt(st2.nextToken());
			
			for (int j=x1; j<=x2; j++) {
				for (int k=y1; k<=y2; k++) {
					l[j][k]++;
				}
			}
		}
		
		for (int i=1; i<=100; i++) {
			for (int j=1; j<=100; j++) {
				if (l[i][j]>m) ans++;
			}
		}
		
		bw.write(Integer.toString(ans));
		bw.flush(); bw.close();

	}
	


}
