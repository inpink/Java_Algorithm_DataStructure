import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함

	//a와 tree에 담기는 요소값, 구간 합의 범위가 각각 -2^63~2^63-1이다. 이 범위는 long의 범위이다. 즉, 둘 다 long형 배열을 사용한다.
	//★tree 루트번호는 1부터 시작해야, 2배값이 먹는다. 0부터 시작하면 2배 적용이 안돼서 트리구조가 안된다.
	static void init(long[] a, long[] tree, int node, int start, int end) { //최초 1회 N개의 노드를 가진 세그먼트 트리 생성
		if (start==end) tree[node]=a[start];
		else {
			init(a,tree,2*node,start,(start+end)/2);
			init(a,tree,2*node+1,(start+end)/2+1,end);
			tree[node]=Math.min(tree[node*2],tree[node*2+1]);
		}
	}

	static long query(long[] tree, int node, int start, int end, int left, int right) { //left~right 구간 합 구하기
		if (left>end || right<start) return 1000000001; //최댓값+1을 담아 min 갱신될 수 있게함
		if (left<=start && end<=right ) return tree[node];
		
		long lmin=query(tree, node*2, start, (start+end)/2, left,right);
		long rmin=query(tree,node*2+1,(start+end)/2+1,end,left,right);
		return Math.min(lmin, rmin);
	}
	

	/*static void update(long[] a,long[] tree,int node, int start,int end, int index, long val ) {
		if (index<start || index>end) return;
		if (start==end && start==index) { //말단 노드이자, 내가 업데이트 시키고자 하는 index번째
			a[start]=val;
			tree[node]=val;
			return;
		}
		//자식들 호출하는 재귀
		update(a,tree,node*2,start,(start+end)/2,index,val);
		update(a,tree,node*2+1,(start+end)/2+1,end,index,val);
		
		//거슬러 올라가며 min도 다시 업데이트 해줘야 함
		tree[node]=Math.min(tree[node*2],tree[node*2+1]);
	}*/
	
	
	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	        StringTokenizer st= new StringTokenizer(br.readLine());
			int n= Integer.parseInt(st.nextToken());
			int m= Integer.parseInt(st.nextToken());
			
			long a[]=new long[n]; //a리스트는 0~n-1번  //☆최댓값이 10억이니까 int써도 됨
			
			for (int i=0; i<n; i++) a[i]=Long.parseLong(br.readLine());
			
			int h=(int)Math.ceil(Math.log(n)/Math.log(2)); 
			long tree[]=new long[1<<(h+1)]; 
			
			init(a,tree,1,0,n-1);	
			for (int i=0; i<m;i++) {
				StringTokenizer st1=new StringTokenizer(br.readLine());
				int idx1=Integer.parseInt(st1.nextToken())-1;
				int idx2=Integer.parseInt(st1.nextToken())-1;
				bw.write(Long.toString(query(tree, 1, 0, n-1,idx1,idx2))+"\n");
			}
			bw.flush(); bw.close();
	   }
}
