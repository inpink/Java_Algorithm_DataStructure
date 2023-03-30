import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { //class name은 Main 이어야 함
	public static void main(String[] args) throws IOException { //예외처리 꼭 해줘야 함
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int seconds=0;	
		int n= Integer.parseInt(br.readLine());
		
		int l[][]= new int[n+2][n+2]; //상하좌우로 각 1줄씩, 총 2줄 늘려줘야 함!!!
		int visited[][]= new int[n+2][n+2];
		Integer[] removeXY;
		int tmp,sharkX=0,sharkY=0,i,j,newX,newY,moving=0,searchX,searchY,stopNum=999;
		int shark_size=2;
		int eat_count=0;
		int directions[][]={ {-1,0}, {0,-1}, {1,0} ,{0,1}}; 

		Deque<Integer[]> dq = new ArrayDeque<>(); //☆
        
		PriorityQueue<Integer[]> hq = new PriorityQueue<>(new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] a1, Integer[] a2) { //compare 연산자를 내가 재정의 해줘야 하는구나.. 내가 다 짜줘야 하는구나.. 파이썬이면 훨씬 쉬운 문제인데..	
				if(a1[0]<a2[0]) {
					return -1; //더 작으니까 더 앞에 가겠지
				}
				else if (a1[0]==a2[0]) {
					if (a1[1]<a2[1]) return -1;
					else if (a1[1]==a2[1]) {
						if(a1[2]<a2[2]) return -1;
						else return 1;
					}
					else return 1;
				}
				else return 1;
			}
		}
		);
		
		for (i=1; i<=n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (j=1;j<=n;j++) {
				tmp=Integer.parseInt(st.nextToken());
				l[i][j]=tmp;
				if (tmp==9) {
					sharkX=i;
					sharkY=j;
				}
			}
		}
		l[sharkX][sharkY]=0; //shark 있는 곳 0처리 해줘야 나중에 shark가 지나가도 이자리도 지나감..
			
		while (true) {
			dq.clear(); //데큐 초기화시키고
			dq.add(new Integer[] {0,sharkX,sharkY}); //현재 상어 위치를 시작으로 bfs 돌려서, 후보지들을 힙에 담고, 가장 작은 값 뽑아낸다.
			for (int a=1; a<=n;a++) { //visited 초기화시키기!
				for (int b=1; b<=n; b++) {
					visited[a][b]=0;
				}
			}
			visited[sharkX][sharkY]=1; //새로운 시작점 방문 체크
			stopNum=999;
			
			//bfs
			while (true) {
				if (dq.size()==0) break; 
                
				removeXY=dq.remove(); 
				moving=removeXY[0]+1; //시작 지점으로부터 몇 칸 움직여야 여기에 닿을 수 있는지 
				searchX=removeXY[1];
				searchY=removeXY[2];
				visited[searchX][searchY]=1; //★ 아..
	
				if (moving==stopNum) break;
				
				for (i=0; i<4;i++) {
					newX=searchX+directions[i][0];
					newY=searchY+directions[i][1];
					
					if (newX<1 || newX>n || newY<1 || newY>n) continue; //벽이면 탐색자체를 하면 안됨
					else if (l[newX][newY]>shark_size) { visited[newX][newY]=1; continue; } //자기보다 크면 못지나감
					else if (visited[newX][newY]==1 ) continue; //방문한 곳이면 지나치세요
					//자기보다 사이즈 작고, 아직 방문하지 않은 곳이라면 && 0이면 먹을 수 있는게 아님!
					else if (l[newX][newY]<shark_size && l[newX][newY]!=0  ) 
					{
						hq.add(new Integer[] {moving,newX,newY}); //☆
						dq.add(new Integer[] {moving,newX,newY}); //그 위치도 탐색 후보가 됨 
						visited[newX][newY]=1;
						stopNum=moving+1; //현재 단계보다 더 높은 단계는 bfs 멈춘다!
					}
					//사이즈 같고, 아직 방문하지 않은 곳이라면
					else {
						//System.out.print(newX+" "+newY+"\n");
						dq.add(new Integer[] {moving,newX,newY}); //그 위치도 탐색 후보가 됨 
						visited[newX][newY]=1;
					}
				}		
			}
			if (hq.size()==0) break;  //전체 종료 조건. 힙에 아무것도 없다 = 남은 물고기가 없다
			
      removeXY=hq.remove(); 
			hq.clear(); //☆뽑았으면 moving값이 다시 업데이트 되므로 힙도 초기화 시켜줘야함!
			sharkX=removeXY[1]; //상어 위치 업데이트 시켜줘야함 
			sharkY=removeXY[2];
			moving=removeXY[0];
			eat_count++; 
			l[sharkX][sharkY]=0; //먹어버림
			seconds+=moving; 
			
			if (eat_count==shark_size) { //level up이 가능한 size 상태라면
				shark_size++;
				eat_count=0; 
			} //레벨업 처리 완료
		}
		System.out.println(seconds);
    }
}
