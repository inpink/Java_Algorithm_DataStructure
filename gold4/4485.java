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

        int idx=0;
        int[][] dir= new int[][] { {-1,0}, {1,0}, {0,-1}, {0,1} }; //상하좌우
        while (true) {
            //몇개를 어떻게 거쳐가는지는 중요하지 않다. 고정된 A에서 특정 B까지의 "최소비용"을 구하는 것
            //=> 다익스트라
            int n= Integer.parseInt(br.readLine());
            if(n==0) break;
            idx++;

            int INF = Integer.MAX_VALUE;
            int[][] graph= new int[n][n];
            int[][] dp=new int[n][n]; //해당 노드까지 최소비용이 담김

            for (int i=0; i<n; i++){
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++) {
                    graph[i][j]=Integer.parseInt(stringTokenizer.nextToken());
                    dp[i][j]=INF; //int형의 최댓값으로 초기화 필요
                }
            }
            //System.out.println(Arrays.toString(graph[0]));

            PriorityQueue<Integer[]> heap = new PriorityQueue<>((o1, o2) -> {
                return  o1[1]- o2[1]; //작은게 앞으로 가도록 빼줌
            });

            //다익스트라
            int startX=0, startY=0; //시작점

            heap.add(new Integer[]{startX,startY,graph[startX][startY]}); // 시작점 x,y 넣고 시작. 비용은 0,0의 값으로 시작

            while (true){
                if (heap.size()==0) break;

                Integer[] currArr= heap.poll(); //가장 우선순위 높은==현재로서 가장 "누적" 비용 작은 값 꺼내옴
                int currX=currArr[0];
                int currY=currArr[1];
                int accumWeight = currArr[2];

                for ( int[] moveDir : dir ){ //후보는 상하좌우
                    int moveX=moveDir[0];
                    int moveY=moveDir[1];
                    int nextX=currX+moveX;
                    int nextY=currY+moveY;

                    if (nextX<0 || nextX>=n || nextY<0 || nextY>=n) continue;

                    int nextWeight= accumWeight+graph[nextX][nextY];  //★굳이 방문한 곳을 또 방문할 필요가 없으므로(그럼 최솟값이 아니게 됨), dp에 쌓인 값이 아니라 graph의 비용 값(그 곳엔 이번 경로로는 처음감)을 사용
                    if (nextX==startX && nextY==startY) continue; //시작점이 x인데, 자기 자신을 다시 방문해야 하는 경우는 최소가 아니므로 굳이 검사할 필요가 없다
                    if (dp[nextX][nextY]>nextWeight) { //더 작은 비용이여야 추가적으로 탐색. ★더 작은 비용이면 연결된 모든 것들이 다시 갱신된다★
                        dp[nextX][nextY]=nextWeight;
                        heap.add(new Integer[]{nextX,nextY,nextWeight});
                    }
                }
            }
            //System.out.println(Arrays.toString(dp));

            StringBuilder sb= new StringBuilder();
            sb.append("Problem ");
            sb.append(idx);
            sb.append(": ");
            sb.append(dp[n-1][n-1]);
            sb.append("\n");
            bw.write(sb.toString());

        }

        bw.flush();
        bw.close();
    }


}
