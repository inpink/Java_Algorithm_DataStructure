package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main { // class name은 Main 이어야 함
	
	static long[][] l = { {1,1},{1,0}};

	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = Long.parseLong(br.readLine()); //n은 최대 1,000,000,000,000,000,000 => long 써야 함
	    if (n==1) {
	    	System.out.println(1); return;
	    }
	    long[][] ans_list=DaCfExp(n-1);
	      
	      //System.out.println(Arrays.toString(matrixMulti(l,l)[0]));
	      
	    bw.write(Long.toString(ans_list[0][0])); bw.flush(); bw.close();
	      
	   }
	   
	   static long[][] matrixMulti(long[][] left, long[][] right){ //행렬곱
	      long[][] tmp_list = new long[2][2]; //새로운 리스트 만들어서  //☆최댓값이  1,000,000,006으로 int는 당연히 안되고, 10^9*10^9=10^18로 long범위 oK
	      for (int i=0; i<2;i++) {
	         for (int j=0; j<2; j++) {
	            for (int k=0;k<2;k++) {
	               tmp_list[i][j]+= left[i][k]*right[k][j]%1000000007; //어느 정도 외우기. 애초에 행렬곱 공식이 이거니까.
	            } tmp_list[i][j]%=1000000007; //★나머지 분배법칙!!
	         }
	      }//System.out.println(Arrays.toString(tmp_list[0]));
	      return tmp_list; //left 행렬, right 행렬을 곱한 것을 tmp_list에 담아서 반환 
	   }
	   
	   static long[][] DaCfExp(long n){   //Divide and Conquer for Exponentiation
	      
	      if (n==1) return l; //★ 최대한 쪼갠다음, 그 다음에서야 1 1 1 0부터 "행렬곱 메소드"에 가게 해준다!!★
	      
	      long[][] rec=DaCfExp(n/2); //쪼개서 rec에 담아서 이동시킴! rec에 담겨서 전달하는 것임! 
	      
	      if (n%2==0) return matrixMulti(rec,rec); //지금까지 
	      else return matrixMulti(matrixMulti(rec,rec),l);
	      
	   }
	   //예 - dac(8) -> d(4) -> d(2) -> d(1)으로 쪼개고,
	   //d(1)단계에서 l리턴 -> d(2)로와서 rec=l 담김! mat(l,l)계산결과 보내짐!
	   //d(4)로 와서 rec=mat(1,1) 담김! mat(mat(1,1),mat(1,1)) 계산결과 보내짐!
	   //d(8)로 와서 rec=mat(mat(1,1),mat(1,1)) 담기고,   mat(mat(mat(1,1),mat(1,1)),mat(mat(1,1),mat(1,1))) 계산결과 보내짐!
	   //더 이상 만들어진 dac 메소드 없으므로 위의 것이 정답!  (((l^2)^2^2)) !! l^8!!! 
}
