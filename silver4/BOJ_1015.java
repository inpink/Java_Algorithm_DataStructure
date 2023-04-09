package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함
	
	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//비내림차순 :  배열의 모든 요소에 대해, 앞의요소>=뒤의 요소
		//배열 P를 출력하는 것이 이 문제의 목표. P[i]번째를 나열했을 떄 "비내림차순"이 되면 됨.
		//=>단순함. 주어진 배열 A에서 숫자가 몇 번째 index인지 세어주면 됨. 중복되는 숫자만 잘 고려해서.
		//=> 푸는 방법은 여러 개가 있을 듯.
		
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int i,j,count=0;
		List<Integer>[] list=new ArrayList[1001]; 
		int[] ans= new int[n];
		for (i=1;i<=1000;i++) list[i]= new ArrayList<>();

		for (i=0;i<n;i++) {
			list[Integer.parseInt(st.nextToken())].add(i);		
		}
		
		for (i=1;i<=1000;i++) {
			for (j=0;j<list[i].size(); j++) {
				ans[list[i].get(j)]=count++;
			}
		}
		for (i=0;i<n;i++) {
			bw.write(Integer.toString(ans[i]));
			bw.write(" ");
		}
		 bw.flush(); bw.close();
	}
	

}
