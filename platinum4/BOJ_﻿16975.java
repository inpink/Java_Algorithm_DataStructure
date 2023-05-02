package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함

	static void init(long[] a, long[] tree, int node, int start, int end) { 
		if (start==end) tree[node]=a[start]; //말단노드에만 값 담아놓고,
		else {
			init(a,tree,2*node,start,(start+end)/2);
			init(a,tree,2*node+1,(start+end)/2+1,end);
			//tree[node]=Math.min(tree[node*2],tree[node*2+1]); //거슬러 올라가며 아무것도 해놓지않음
		}
	}
	
	static void update(long[] tree, int node, int start, int end, int left, int right, int plus) { //left~right 구간에 추가값 적용
		if (left>end || right<start) return; //추가값 없다 
		if (left<=start && end<=right ) {
			tree[node]+=plus;
			return;
		}	
		update(tree, node*2, start, (start+end)/2, left,right,plus);
		update(tree,node*2+1,(start+end)/2+1,end,left,right,plus);
		//return Math.min(lmin, rmin); //거슬러 올라가며 아무것도 해놓지않음. 딱 해당되는 구간에만 추가값 표시함
	}
	
	static long query(long[] tree,int node, int start, int end, int index ) { //추가값 구하기
		if (index<start || index>end) return 0; //해당안되면 추가값 0
		if (start==end && start==index) return tree[node]; //말단노드까지 내려감!
		
		//자식들 호출하는 재귀
		long lsum=query(tree,node*2,start,(start+end)/2,index);
		long rsum=query(tree,node*2+1,(start+end)/2+1,end,index);
		//System.out.println(node+" "+lsum+rsum);
		return lsum+rsum+tree[node]; //말단노드에서 최초의 맨 위까지 거슬러 올라가며 추가값들의 합 구해줌
	}
	
	
	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	        
			int n= Integer.parseInt(br.readLine());
			long[] a=new long[n]; //a리스트는 0~n-1번  //100만이 10만번 더해질 수 있으니 10^6*10^5=10^11 long 써야 함
			
			StringTokenizer st= new StringTokenizer(br.readLine());
			for (int i=0; i<n; i++) a[i]=Long.parseLong(st.nextToken());
			
			int h=(int)Math.ceil(Math.log(n)/Math.log(2)); 
			long tree[]=new long[1<<(h+1)]; 
			init(a,tree,1,0,n-1);	
			
			int m= Integer.parseInt(br.readLine());
			
			for (int i=0; i<m;i++) {
				StringTokenizer st1=new StringTokenizer(br.readLine());
				if (st1.nextToken().equals("1")) update(tree,1,0,n-1,Integer.parseInt(st1.nextToken())-1,Integer.parseInt(st1.nextToken())-1,Integer.parseInt(st1.nextToken()));
				else bw.write(Long.toString(query(tree, 1, 0, n-1,Integer.parseInt(st1.nextToken())-1))+"\n");
				/*for (int j=1; j<1<<(h+1); j++) System.out.print(tree[j]+" ");
				System.out.println();*/
			}
			bw.flush(); bw.close();
	   }
}
