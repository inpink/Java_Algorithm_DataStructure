package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함

	/*static void init(long[] a, long[] tree, int node, int start, int end) { //최초 1회 N개의 노드를 가진 세그먼트 트리 생성
		if (start==end) tree[node]=a[start];
		else {
			init(a,tree,2*node,start,(start+end)/2);
			init(a,tree,2*node+1,(start+end)/2+1,end);
			tree[node]=tree[node*2]+tree[node*2+1];
		}
	}*/
	
	static long query(long[] tree, int node, int start, int end, int left, int right) { //left~right 구간 합 구하기
		if (left>end || right<start) return 0; //구간 합에 0을 더해
		if (left<=start && end<=right ) return tree[node];
		
		long lsum=query(tree, node*2, start, (start+end)/2, left,right);
		long rsum=query(tree,node*2+1,(start+end)/2+1,end,left,right);
		return lsum+rsum;
	}
	
	static void update(long[] a,long[] tree,int node, int start,int end, int index, long val ) {
		if (index<start || index>end) return;
		if (start==end && start==index) { //말단 노드이자, 내가 업데이트 시키고자 하는 index번째
			a[start]=val;
			tree[node]=val;
			return;
		}
		//자식들 호출하는 재귀
		update(a,tree,node*2,start,(start+end)/2,index,val);
		update(a,tree,node*2+1,(start+end)/2+1,end,index,val);
		
		//거슬러 올라가며 합계도 다시 업데이트 해줘야 함
		tree[node]=tree[node*2]+tree[node*2+1];
	}
	
	
	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			
			long a[]=new long[n]; //a리스트는 0~n-1번
			
			int h=(int)Math.ceil(Math.log(n)/Math.log(2)); 
			
			long tree[]=new long[1<<(h+1)]; 
			
			int left,right,tmp;
        
			//init(a,tree,1,0,n-1); //1. 여기서 초기값은 0으로 init 필요없음
			
			for (int i=0; i<m;i++) {
				StringTokenizer st1=new StringTokenizer(br.readLine());
				if (st1.nextToken().equals("1")) update(a,tree,1,0,n-1,Integer.parseInt(st1.nextToken())-1,Long.parseLong(st1.nextToken()));
				else {
					//2. left>right일 수 있다. 문제의 조건을 꼼꼼히 읽자.
					left=Integer.parseInt(st1.nextToken())-1;
					right=Integer.parseInt(st1.nextToken())-1;
					if (left>right) {
						tmp=left;
						left=right;
						right=tmp;
					}
					bw.write(Long.toString(query(tree, 1, 0, n-1,left,right))+"\n");
				}
			}
			bw.flush(); bw.close();
	   }
}
