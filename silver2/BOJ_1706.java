package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함

	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
	        //r,c Input
	        StringTokenizer st=new StringTokenizer(br.readLine());
	        int r=Integer.parseInt(st.nextToken());
	        int c=Integer.parseInt(st.nextToken());
	        
	        //가로 세로 배열, 단어 담을 리스트
	        String[] xy=new String[r];
	        String[] yx=new String[c];
	        List<String> words = new ArrayList<>(); 
 	        
	        //배열 Input
	        for (int i=0; i<r; i++) {
	        	xy[i]=br.readLine();
	        }
	        
	        //xy array to yx array
	        toYX(xy,yx,r,c);
	        
	        //단어만 찾아서 words list에 담기
	        findWord(xy,words);
	        findWord(yx,words);
	        
	        //sort
	        Collections.sort(words);
	        //System.out.print(words);
	        
	        //Output
	        bw.write(words.get(0));
			bw.flush(); bw.close();
	}
	
	public static void toYX(String[] xy, String[] yx, int r, int c) {
		for (int i=0; i<c; i++) {
			StringBuilder sb= new StringBuilder();
			for (int j=0; j<r; j++) {
				sb.append(xy[j].charAt(i)); //String이라 charAt 써야함
			}
			yx[i]=sb.toString();
			//System.out.println(yx[i]);
		}
	}
	
	public static void findWord(String[] array, List<String> words) {
		String[] tmp;
		for (int i=0; i<array.length; i++) {
			tmp= array[i].split("#");
			for (int j=0; j<tmp.length; j++) {
				//System.out.println("*"+tmp[j]);
				if (isWord(tmp[j])) {
					words.add(tmp[j]);
				}
			} //System.out.println();
		}
	}
	
	
	public static boolean isWord(String word) {
		
		if (word.equals("") || word.length()<=1)
			return false;
		else 
			return true;
	}
}

