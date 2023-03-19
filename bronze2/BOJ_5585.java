package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main { //class name은 Main 이어야 함
	public static void main(String[] args) throws IOException { //예외처리 꼭 해줘야 함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int n=Integer.parseInt(br.readLine());
		int count=0;
		n=1000-n;
		
		int[] money= {500,100,50,10,5,1};
		
		for (int i=0; i<money.length; i++) {
			count+=(n/money[i]);
			n%=money[i];
		}
		/*
		 * count+=(n%500); n-=(n%500)*500;
		 */
		
		System.out.println(count);
		
		
    }
	

	
		
		
}
	