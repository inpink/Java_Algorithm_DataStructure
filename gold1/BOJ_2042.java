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
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			
			long a[]=new long[n]; //a리스트는 0~n-1번
			
			//트리 노드의 개수는 레벨에 따라 1+2+4+8+...n이다. 그리고, 트리 레벨은 log2n+1이다. 레벨 개수만큼 1+2+4...+n을 해주면 되는 것이다.
			//1,2,4,..n일 때, 1부터 n/2까지의 합+1은 n과 같다! 따라서, n<=2^h가 되는 적합한 h를 찾고, 2^h*2= 2^(h+1)을 해주면 해당 n에서의, 레벨에서의 넉넉한 총 노드의 개수가 되는 것이다!
			//자바에는 Math.log, Math.log10이 있다. 첫번째는 자연상수e가 밑이 된다. 밑이 2인 로그메소드는 안만들어져있기 때문에, 아래와 같이 로그의 나눗셈을 이용하여 밑이2이고 진수가 n인 log2(n)을 만들 수 있다.
			int h=(int)Math.ceil(Math.log(n)/Math.log(2)); //반올림해서 자기 다음의 2^h에서의 h를 찾는다!
			
			
			long tree[]=new long[1<<(h+1)]; //트리의 0번은 안씀. ★★비트 연산을 이용하여 2^h을 빠르게 구하기!! 2^(h+1)을 구하는 것이다.
		    //또는, n의 최대가 100만이므로 2^20=104만이고, 2^21인 209만~ 이상의 값을 넣어도 항상 통과하긴 한다. 메모리 절약을 위해 적절한 공식을 사용해줬다.	
        
			for (int i=0; i<n; i++) a[i]=Long.parseLong(br.readLine());
			init(a,tree,1,0,n-1);
			
			for (int i=0; i<m+k;i++) {
				StringTokenizer st1=new StringTokenizer(br.readLine());
				if (st1.nextToken().equals("1")) update(a,tree,1,0,n-1,Integer.parseInt(st1.nextToken())-1,Long.parseLong(st1.nextToken()));
				else bw.write(Long.toString(query(tree, 1, 0, n-1,Integer.parseInt(st1.nextToken())-1,Integer.parseInt(st1.nextToken())-1))+"\n");
			}
			bw.flush(); bw.close();
	   }
}
