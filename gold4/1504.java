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
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int e=Integer.parseInt(st.nextToken());

        int left, right, value, start, end, ans1=0, ans2=0, realAns=0;
        int INF = Integer.MAX_VALUE;
        ArrayList<Integer[]>[] graph= new ArrayList[n+1]; //선언 시 타입<Integer[]>로 지정해주자!
        for (int i=1; i<=n; i++) graph[i]=new ArrayList<>();

        for (int i = 0; i < e; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            left=Integer.parseInt(stringTokenizer.nextToken());
            right=Integer.parseInt(stringTokenizer.nextToken());
            value=Integer.parseInt(stringTokenizer.nextToken());

            //양쪽 다 넣어줌
            graph[left].add(new Integer[] {right,value});
            graph[right].add(new Integer[] {left,value});
        }
        //System.out.println(Arrays.toString(graph[1].get(0)));

        StringTokenizer st2= new StringTokenizer(br.readLine());
        int v1=Integer.parseInt(st2.nextToken());
        int v2=Integer.parseInt(st2.nextToken());

        start=1;
        end=n;

        //다익스트라
        int[] dpStart=dijk(graph,n,start); //시작점으로 다익스트라 한번 돌리고
        int[] dpV1=dijk(graph,n,v1);
        int[] dpV2=dijk(graph,n,v2);

        int sToV1=dpStart[v1];
        int sToV2=dpStart[v2];
        int v1BetV2=dpV1[v2];
        int v1ToEnd=dpV1[end];
        int v2ToEnd=dpV2[end];

        //ans1: S(1)->v1->v2->E(N)

        //ans1, ans2 두 개 값 비교할 것임
        //공통적인 길이 없는 경우(A랑 B사이가 연결되어 있지 않음)
        if (v1BetV2==INF) realAns=-1;
        else {
            if  (sToV1==INF || v2ToEnd==INF)  ans1=-1;  //하나라도 끊겨있으면 이 노선은 사용 불가
            else ans1=sToV1+v1BetV2+v2ToEnd;

            if  (sToV2==INF || v1ToEnd==INF)  ans2=-1; //하나라도 끊겨있으면 이 노선은 사용 불가
            else ans2=sToV2+v1BetV2+v1ToEnd;
        }


        //OUTPUT
        if (realAns!=-1) realAns=Math.min(ans1,ans2);
        bw.write(Integer.toString(realAns));
        bw.flush();
        bw.close();
    }

    public static int[] dijk(ArrayList<Integer[]>[] graph, int p, int start){
        int left, right, value;
        int INF = Integer.MAX_VALUE;

        int[] dp = new int[p+1]; //해당 노드까지 최소비용이 담김
        for (int i = 1; i <= p; i++) {
            if (i==start) dp[i]=0;
            else dp[i] = INF; //int형의 최댓값으로 초기화 필요
        }

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
