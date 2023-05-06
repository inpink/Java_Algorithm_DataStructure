import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함

	//a와 tree에 담기는 요소값, 구간 합의 범위가 각각 -2^63~2^63-1이다. 이 범위는 long의 범위이다. 즉, 둘 다 long형 배열을 사용한다.
	//★tree 루트번호는 1부터 시작해야, 2배값이 먹는다. 0부터 시작하면 2배 적용이 안돼서 트리구조가 안된다.
	static void init(long[] a, long[] tree, int node, int start, int end) { //최초 1회 N개의 노드를 가진 세그먼트 트리 생성
		if (start==end) tree[node]=a[start];
		else {
			init(a,tree,2*node,start,(start+end)/2);
			init(a,tree,2*node+1,(start+end)/2+1,end);
			tree[node]=tree[node*2]+tree[node*2+1];
		}
	}
	
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
			//System.out.println(1<<21);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	        StringTokenizer st0= new StringTokenizer(br.readLine());
	        int n=Integer.parseInt(st0.nextToken());
	        int q=Integer.parseInt(st0.nextToken());
			
	        long[] a=new long[n]; //a리스트는 0~n-1번  //10만이 10만번 더해질 수 있으니 10^5*10^5=10^10 long 써야 함
			
			StringTokenizer st1= new StringTokenizer(br.readLine());
			for (int i=0; i<n; i++) a[i]=Long.parseLong(st1.nextToken());
			
			int h=(int)Math.ceil(Math.log(n)/Math.log(2)); 
			long tree[]=new long[1<<(h+1)]; 
			init(a,tree,1,0,n-1);	
			
			
			for (int i=0; i<q;i++) {
				StringTokenizer st2=new StringTokenizer(br.readLine());
				int left=Integer.parseInt(st2.nextToken());
				int right=Integer.parseInt(st2.nextToken());
				if (left>right) { //x~y는 당연히 x번째 부터 y번째가 맞다. 하지만, 이 문제에서는 x > y인 경우 y번째 부터 x번째이다.
					int tmp=left;
					left=right;
					right=tmp;
				}
				int idx=Integer.parseInt(st2.nextToken());
				int value=Integer.parseInt(st2.nextToken());
				bw.write(Long.toString(query(tree, 1, 0, n-1,left-1, right-1))+"\n");
				update(a,tree,1,0,n-1,idx-1,value);
			}
			bw.flush(); bw.close();
	   }
}

