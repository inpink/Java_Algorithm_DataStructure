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

        //'고정된 출발점'에서 '근처'의 갈 수 있는 노드들만 탐색 => 다익스트라
        //DP는 매번 초기화한다. 매번 새롭게 다익스트라한다! DP[b]에는 a노드에서 b노드까지의 최소비용(뭘 거치든 중요하지 않다. 최소 비용만 담아둠) 담아둠
        //=> 4000*1000 OK
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int left, right, value;

        // graph[1]=[ [2,10], [3,5] .. ]
        ArrayList<Integer[]>[] graph= new ArrayList[n+1]; //선언 시 타입<Integer[]>로 지정해주자!
        for (int i=1; i<=n; i++) graph[i]=new ArrayList<>();

        //Test
        /*graph[1].add(new Integer[] {1,10});
        System.out.println(Arrays.toString(graph[1].get(0)));
        System.out.println(graph[1]);*/

        int[] dp = new int[n+1]; //해당 노드까지 최소비용이 담김(int 범위 내 보장)

        //★힙.  '최소 누적 weight'를 꺼낸다.
        // (힙이 필요한 이유. weight는 계속 누적되기 때문에,
        // 큰값을 꺼내고 작은값을 꺼내면
        // 힙에도 더 많은 candi가 들어가게 되고,
        // 갱신되는 것도 더 많아져서
        // 시간이 더 많이 걸려버림. 처음부터 작은 값을 꺼내서 탐색, 갱신 최소화)
        PriorityQueue<Integer[]> heap = new PriorityQueue<>((o1, o2) -> {
                return  o1[1]- o2[1]; //작은게 앞으로 가도록 빼줌
        });

        for (int a=0; a<k; a++) {
            StringTokenizer st= new StringTokenizer(br.readLine());

            if (st.nextToken().equals("1")) { //간선 생성
                left=Integer.parseInt(st.nextToken());
                right=Integer.parseInt(st.nextToken());
                value=Integer.parseInt(st.nextToken());

                //양쪽 다 넣어줌
                graph[left].add(new Integer[] {right,value});
                graph[right].add(new Integer[] {left,value});

            }else{ //작은것부터 sort하는게 소용있을지? ㅇㅇ 갱신적어질테니까.  구현도 어렵지 않고. 근데 경우에 따라 매번 sort하는게 더 시간이 많이 들 수 있다는건 주의하자.
                //left->right로 하자
                left=Integer.parseInt(st.nextToken());
                right=Integer.parseInt(st.nextToken());

                for (int i=1; i<=n; i++) dp[i]=Integer.MAX_VALUE; //int형의 최댓값으로 매번! 초기화 필요

                heap.add(new Integer[]{left,0}); // 시작점 넣고 시작. 비용은 0으로 시작

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
                        if (dp[nextNode]>nextWeight) { //더 작은 비용이여야 추가적으로 탐색. ★더 작은 비용이면 연결된 모든 것들이 다시 갱신된다★
                            dp[nextNode]=nextWeight;
                            heap.add(new Integer[]{nextNode,nextWeight});
                        }
                    }
                }
                //System.out.println(Arrays.toString(dp));
                //출력
                if (dp[right]==Integer.MAX_VALUE) bw.write("-1"); //dp[right]값이 바뀌지 않았다면 어떻게해도 left에서는 right를 못간다는 것
                else bw.write(Integer.toString(dp[right]));
                bw.write("\n");
            }
        }

        //OUTPUT
        bw.flush();
        bw.close();
    }


}
