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
		StringTokenizer st= new StringTokenizer(br.readLine());
		int x=Integer.parseInt(br.readLine());
		int[] l = new int[st.countTokens()];
		int[] nums= new int[2000001];
		int count=0;
		
		for (int i=0; i<n; i++)  {
			l[i]=Integer.parseInt(st.nextToken());
			nums[l[i]]=1;
		}
		
		// 1) x <= l[i]인 경우도 고려해야 함. 
		
		for (int i=0; i<n; i++) {
			if (x-l[i]<=0) continue;
			if (nums[x-l[i]]==1) count++;
		}
	
		System.out.print(count/2);
		
    }
	
		
		
}
	