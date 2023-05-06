import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함

	static int leftIdx(int[] array, int n) //왼쪽 index를 반환
	{
		int ans=0;
		for (int i=0; i<=array.length+1; i++) {
			if (array[i]>n) {
				ans=i-1; 
				break;
			}
		}
		return ans;
	}
	
	static int findArray(int[] array, int leftI, int n){
		
		int leftV=array[leftI]+1;
		int rightV=array[leftI+1]-1;
		int cnt=0;
		//System.out.println(leftV+" "+rightV+" ");
		while (true) { //두 개의 항을 가짐. leftV가 왼쪽, rightV가 오른쪽. 
			if (leftV>n) break;
			for (int i=n; i<=rightV; i++) {
				//System.out.println(leftV+" "+i+" ");
				cnt++;
			}
			leftV++;
		}
		
		if (cnt!=0) cnt--; //(n,n)을 빼줌
		return cnt; 
		
	}
	
	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int l= Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n= Integer.parseInt(br.readLine());
		
		int[] array=new int[l+2]; //★ 입력된 배열의 맨왼, 맨오른쪽에 최솟값, 최댓값을 넣어 입력된 범위 외에도 예외없이 탐색할수 있게
		int leftI,cnt;
		
		array[0]=0; //나올 수 없는 최솟값 0
		for(int i=1;i<=l;i++) array[i]=Integer.parseInt(st.nextToken());
		array[l+1]=1001; //나올 수 없는 최댓값 1001
		
		Arrays.sort(array);
		
		leftI=leftIdx(array,n);
		//System.out.println("left Index 값 :" +leftI);
		cnt=findArray(array,leftI,n);
		
		bw.write(Integer.toString(cnt));
	    bw.flush(); bw.close(); 
	   }
	
	
}

