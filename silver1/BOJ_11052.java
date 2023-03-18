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
		
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int[] l= new int[n+1]; //0으로 초기화된다 했음 
		
		for (int i=1; i<=n;i++) l[i]=Integer.parseInt(st.nextToken()); //1부터 시작
		
		int[] dp= new int[n+1];
		
		int a,b;
		for (int i=1; i<=n;i++) { //i원을 만드는 것
			for (int j=1;j<=i;j++) { //1번부터 n번 p를 사용할것인가 말 것인가. l[원][p] 까지에서의 최대 효율값.
				a=dp[i];
				b=dp[i-j]+l[j];
				dp[i]= ( a>=b ) ? a : b ;
			}
				
		}
		
		System.out.println(dp[n]);
    }
	

	
		
		
}
	