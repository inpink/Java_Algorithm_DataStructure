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

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상하좌우
        //몇개를 어떻게 거쳐가는지는 중요하지 않다. 고정된 A에서 특정 B까지의 "최소비용"을 구하는 것
        //=> 다익스트라
        StringTokenizer st= new StringTokenizer(br.readLine());
        int c=Integer.parseInt(st.nextToken());
        int p=Integer.parseInt(st.nextToken());
        int pb=Integer.parseInt(st.nextToken());
        int pa1=Integer.parseInt(st.nextToken());
        int pa2=Integer.parseInt(st.nextToken());

        int left, right, value, start, end;
        int INF = Integer.MAX_VALUE;
        ArrayList<Integer[]>[] graph= new ArrayList[p+1]; //선언 시 타입<Integer[]>로 지정해주자!
        for (int i=1; i<=p; i++) graph[i]=new ArrayList<>();


        for (int i = 0; i < c; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            left=Integer.parseInt(stringTokenizer.nextToken());
            right=Integer.parseInt(stringTokenizer.nextToken());
            value=Integer.parseInt(stringTokenizer.nextToken());

            //양쪽 다 넣어줌
            graph[left].add(new Integer[] {right,value});
            graph[right].add(new Integer[] {left,value});
        }
        //System.out.println(Arrays.toString(graph[0]));



        //다익스트라
        int[] dp1=dijk(graph,p,pb); //시작점으로 다익스트라 한번 돌리고

        //더 비용이 적게드는 곳을 먼저 방문하고, 그곳에서 다른 지점으로 최종 방문하는 dijk 돌리면 됨
        if (dp1[pa1]>dp1[pa2]) {
            start=pa2;
            end=pa1;
        }
        else {
            start=pa1;
            end=pa2;
        }
        int[] dp2=dijk(graph,p,start);

        //OUTPUT
        bw.write(Integer.toString(dp1[start]+dp2[end]));
        bw.flush();
        bw.close();
    }

    public static int[] dijk(ArrayList<Integer[]>[] graph, int p, int start){
        int left, right, value;
        int INF = Integer.MAX_VALUE;

        int[] dp = new int[p+1]; //해당 노드까지 최소비용이 담김
        for (int i = 1; i <= p; i++) dp[i] = INF; //int형의 최댓값으로 초기화 필요

        PriorityQueue<Integer[]> heap = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1]; //작은게 앞으로 가도록 빼줌
        });

        //다익스트라
        left=start; //시작점
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
                if (nextNode==start) continue; //시작점 자기 자신을 다시 방문해야 하는 경우는 최소가 아니므로 굳이 검사할 필요가 없다
                if (dp[nextNode]>nextWeight) { //더 작은 비용이여야 추가적으로 탐색. ★더 작은 비용이면 연결된 모든 것들이 다시 갱신된다★
                    dp[nextNode]=nextWeight;
                    heap.add(new Integer[]{nextNode,nextWeight});
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp;

    }

}
