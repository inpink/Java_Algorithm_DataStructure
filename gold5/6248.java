import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //몇개를 어떻게 거쳐가는지는 중요하지 않다. 고정된 A에서 특정 B까지의 "최소비용"을 구하는 것
        //=> 다익스트라
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int x = Integer.parseInt(stringTokenizer.nextToken()); //출발점

        int left, right, value,max=0;
        int INF = Integer.MAX_VALUE;
        // graph[1]=[ [2,10], [3,5] .. ]
        ArrayList<Integer[]>[] graph= new ArrayList[n+1]; //선언 시 타입<Integer[]>로 지정해주자!
        for (int i=1; i<=n; i++) graph[i]=new ArrayList<>();

        int[] dp = new int[n+1]; //해당 노드까지 최소비용이 담김(int 범위 내 보장)
        for (int i=1; i<=n; i++) dp[i]=INF; //int형의 최댓값으로 초기화 필요

        PriorityQueue<Integer[]> heap = new PriorityQueue<>((o1, o2) -> {
            return  o1[1]- o2[1]; //작은게 앞으로 가도록 빼줌
        });

        //입력
        for (int a=0; a<m; a++) {
            StringTokenizer st= new StringTokenizer(br.readLine());

            left=Integer.parseInt(st.nextToken());
            right=Integer.parseInt(st.nextToken());
            value=Integer.parseInt(st.nextToken());

            //양쪽 다 넣어줌
            graph[left].add(new Integer[] {right,value});
            graph[right].add(new Integer[] {left,value}); //양방향이 아니면 빼줘야 함
        }

        //다익스트라
        left=x; //시작점

        heap.add(new Integer[]{left,0}); // 시작점 1 넣고 시작. 비용은 0으로 시작

        while (true){
            if (heap.size()==0) break;

            Integer[] currArr= heap.poll(); //가장 우선순위 높은==현재로서 가장 "누적" 비용 작은 값 꺼내옴
            int currNode=currArr[0];
            int accumWeight = currArr[1];

            //sort
            Collections.sort(graph[currNode], (o1, o2) -> {
                return o1[1]-o2[1];
            });

            for (Integer[] candi : graph[currNode] ){
                //System.out.println(Arrays.toString(candi));

                int nextNode= candi[0];
                int nextWeight= accumWeight+candi[1];
                if (nextNode==x) continue; //시작점이 x인데, 자기 자신을 다시 방문해야 하는 경우는 최소가 아니므로 굳이 검사할 필요가 없다
                if (dp[nextNode]>nextWeight) { //더 작은 비용이여야 추가적으로 탐색. ★더 작은 비용이면 연결된 모든 것들이 다시 갱신된다★
                    dp[nextNode]=nextWeight;
                    heap.add(new Integer[]{nextNode,nextWeight});
                }
            }
        }

        //System.out.println(Arrays.toString(dp));

        //OUTPUT
        for (int i : dp){
            if (i==INF) continue;

            if (i>max) max=i;
        }

        if (max==0) bw.write("-1");
        else bw.write(Integer.toString(max*2));
        bw.flush();
        bw.close();
    }


}
