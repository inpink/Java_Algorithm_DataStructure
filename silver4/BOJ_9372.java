package MainPack; //자바는 제출 시 package 쓰면 안 됨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // class name은 Main 이어야 함
	public static void main(String[] args) throws IOException { // 예외처리 꼭 해줘야 함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		int n,m,a,b;
		for (int i=0; i<t; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			
			for (int j=1; j<=m; j++) {
				StringTokenizer st2= new StringTokenizer(br.readLine());
				a=Integer.parseInt(st2.nextToken());
				b=Integer.parseInt(st2.nextToken());
			}
			System.out.println(n-1);
			
			// 항상 연결 그래프를 이룬다. => ☆어디서 시작하든지☆ 무조건 다 방문할 수 있다.
			//연결 그래프(Connected Graph)
			//: 토너먼트처럼 연결된게 아니라, 경로를 이어서 어떻게든 이어져 있다. (어디서 시작하든 어떻게든 모든 노드를 방문 가능) 
			//☆연결 그래프라면, 이동할 수 있으면(방문하지 않은곳이라면) 이동하는 것이 무조건 최단 거리이다.
			//문제는 이동할 수 있는 없는 경우인데, ☆시작점을 어디로 잡으라는 내용이 없으므로!!!☆
			// => 최소 스패닝(신장) 트리를 쓸 필요도 없다. bfs나 dfs도 마찬가지이다. 애초에 얘네들을 생각할만한, 적용시켜줄만한 부분이 없다.
			// 왜냐하면, 최소 스패닝 트리는 '연결 그래프'에서 '최소 "가중치"의 합이 되는 모두가 한번씩만 이어진 경로'를 구하는 것이고
			//(최소 스패닝 트리) https://blog.naver.com/willyouspeedup/222969517820 <- 참고하기
			//bfs나 dfs로 탐색하는 코드를 짜기 전에, 어디선가는 시작하면 무조건 n개의 노드를 n-1개의 간선으로 한 번씩 방문하여 이어주는 루트가 생긴다는 것을 알 수 있어야 하기 때문이다.
			
			
		}

		//bw.write(ans); bw.flush(); bw.close();
	}
	

}
