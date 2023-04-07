package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함
	
	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//n이 매우 큰 수가 들어오므로 "입력값만" BigInteger 필수 (long 써도 되긴 함)
		BigInteger n = new BigInteger(br.readLine());
		
		int p=1500000;
		int k=1000000;
		
		n=n.mod(BigInteger.valueOf(p));

		//int newN= Integer.parseInt(n.toString()); //☆
		int newN=n.intValue();
		//System.out.println(newN);
		
		//예외처리
		if (newN==0) {
			System.out.println(0);
			return;
		}
		
		int a=0, b=1, tmp;
		
		//100만으로 나눈 나머지이기 때문에 여기선 BigInteger 안써줘도 됨
		
		for (int i=2; i<=newN; i++) {
			tmp=a;
			a=b;
			b=(b+tmp)%k;
		}
		System.out.println(b);

		
		//bw.write(ans); bw.flush(); bw.close();
	}
	

}
