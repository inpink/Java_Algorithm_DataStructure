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
	
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		int summ=0;
		
		/*hashmap sort
		1) sort by key
		 1-1) 오름차순
			key만 담아둔 List keySet 생성 (☆map자체가 중복값이 안되고 순서가 보장되지않으니 Set라는 이름이 붙음)
			Collections.sort(keySet)로 정렬
			keySet의 요소를 이용하여 map.get(요소)로 value 접근
			for (String key : keySet) {
		        System.out.print("Key : " + key);
		        System.out.println(", Val : " + map.get(key)); }
		 1-2) 내림차순
		    동일한데 Collections.reverse(keySet); 사용
		    
		2) sort by value
			key만 담아둔 List keySet 생성 
			Comparator를 이용하여 가능. (다른 문제에서 적용시켜볼 예정)
				 keySet.sort(new Comparator<String>() {
		            @Override
		            public int compare(String o1, String o2) {
		                return map.get(o1).compareTo(map.get(o2));
	            	}
        		 });
		*/
		
		//Input
		for (int i=0; i<8;i++) {
			hashmap.put(Integer.parseInt(br.readLine()), i); //int To String
		}
		
		//hashMap의 key만 ArrayList에 담기
		List<Integer> keySet = new ArrayList<>(hashmap.keySet()); 
		
		//ArrayList 정렬
		Collections.sort(keySet);
		
		//hashmap의 value 출력을 정렬해줘야 하기 때문에, 정답을 담아줄 리스트 선언 
		List<Integer> ansL = new ArrayList<>();
		
		for (int i=3; i<=7; i++) {
			ansL.add(hashmap.get(keySet.get(i))+1);
			summ+=keySet.get(i);
		}
		
		//정답 리스트 정렬 
		Collections.sort(ansL);
			
		//출력 
		System.out.println(summ);
		for (int i=0; i<5;i++) System.out.print(ansL.get(i)+" ");
		
    }
			
		
		
		
}
	