package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

public class Main { //class name은 Main 이어야 함
	public static void main(String[] args) throws IOException { //예외처리 꼭 해줘야 함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Greedy 문제. 시간복잡도 : 정렬을 위한 nlogn만 있으면 됨.
		
		String s= br.readLine();
		String[] sArray= s.split(""); 
		
		Arrays.sort(sArray, Collections.reverseOrder());   //내림차순 정렬
		//System.out.println(Arrays.toString(sArray)); //배열[] 출력해서 확인하는 방법! 
		
		//Wrapper 클래스(Integer, String 등)에만 적용이 가능하다. char 배열엔 적용 불가능.
		//적용해주고 싶으면, StringBuilder reverse 기능 등을 사용하자.
		//Arrays.sort : 자바에서 모든 배열[] 정렬하기! String, double 등 배열이면 다 가능!
		//(ArrayList 정렬할 땐 Collections.sort라고 배웠다!)
		
		//sArray.toString()하면 [3,0] 이렇게 다 들어와버림..;; 결국 for문써서 내가 직접 구현해주면 되는구나..ㅎ
		// => 문자열 담을 땐 내 사랑 StringBuilder 쓰자!
		StringBuilder sb=new StringBuilder();
		for (int i=0; i<sArray.length;i++) sb.append(sArray[i]);
		BigInteger Bi = new BigInteger(sb.toString()); //BigInteger는 매개변수로 String을 보낸다는 것 잊지 말자

		if (Bi.mod(BigInteger.valueOf(30)).equals(BigInteger.valueOf(0)))  //equals도 당연히 된다! 같으면 true, 다르면 false 반환
			System.out.print(Bi.toString());
		else System.out.println(-1);
		
    }


	
		
		
}
	