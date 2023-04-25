package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함
	
	static long[][] l = { {1L,1L},{1L,0L}};

	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		//3항 비교 
		
		int n = Integer.parseInt(br.readLine());
		
		String[][] l = new String[n][4];
		
	    for (int i=0; i<n;i++) {
	    	StringTokenizer st=new StringTokenizer(br.readLine());
	    	l[i][0]=st.nextToken(); //NAME
	    	l[i][1]=st.nextToken(); //D
	    	l[i][2]=st.nextToken(); //M
	    	l[i][3]=st.nextToken(); //Y
	    }
	    
	    
	    Arrays.sort(l,new Comparator<String[]>() { //★ 일반 배열 sort-comparator 재정의, 2차원 일반 배열
			@Override
			public int compare(String[] i1, String[] i2) {
				int leftD,leftM,leftY,rightD,rightM,rightY;
				leftD=Integer.parseInt(i1[1]);
				leftM=Integer.parseInt(i1[2]);
				leftY=Integer.parseInt(i1[3]);
				rightD=Integer.parseInt(i2[1]);
				rightM=Integer.parseInt(i2[2]);
				rightY=Integer.parseInt(i2[3]);
				
				if (leftY<rightY) { //연도가 작으면 
		    		return -1;
		    	}
				else if (leftY==rightY) { //연도가 같으면
					if (leftM<rightM) return -1; //월 비교해서 작은 left가 앞으로
					else if (leftM==rightM) { //월마저 같으면
						if (leftD<rightD) return -1; //일 비교해서 작은게 앞으로
						else return 1; //연,월,일 다 같은 경우는 들어오지 않는다고 함 
					}
					else return 1; //연도가 같은데 left의 월이 더 큰 경우 left가 뒤로
				}
				else return 1; //left의 연도가 더 크면 left가 뒤로
			}
			
		});
	    
	    
	    bw.write(l[n-1][0]+"\n"+l[0][0]); bw.flush(); bw.close();
	      
	   }

}
