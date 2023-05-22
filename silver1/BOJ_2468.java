import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main { //class명 Main 필수
    public static void main(String[] args)  throws IOException { //예외 처리 필수

        //1시간 소요

        //INPUT & Data
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n=Integer.parseInt(br.readLine());
        int max=0,answer=1; //☆1인 이유 아래에
        int[][] graph= new int[n][n];

        for( int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                graph[i][j]= Integer.parseInt(st.nextToken());
                max=Math.max(max,graph[i][j]);
            }
        }

        //☆비가 하나도 안내렸을 때 (cut=0)는 정답이 1이다.
        //비가 최대한으로 내렸을 때(cut=max)는 정답이 0이다.
        //즉, 최소 정답은 1인 것이다. answer=1으로 해두고, cut=1부터 검사한다.

        //☆모든 가능한 cut를 다 각각 bfs를 새롭게 돌려 탐색해주면 된다.
        for ( int cut=1; cut<max; cut++){
            answer=Math.max(answer,bfs_candi(graph, n, cut));
            //System.out.println("s = " + s);
        }

        //OUTPUT
        bw.write(Integer.toString(answer)); bw.flush(); bw.close();
    }

    //☆코드가 길어져서, 다음과 같이 기능을 3개로 분리함
    // cut
    // -> 하나의 큰 bfs에서 안전영역 시작점xy  (bfs_candi)
    // -> 내부 핵심bfs. 시작점xy와 맞닿은 안전영역 모두 체크 (bfs)
    public static int bfs_candi(int[][] graph,  int n, int cut){

        int[][] visited= new int[n][n];

        int count=0;

        for( int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                if (graph[i][j] > cut && visited[i][j] == 0) { //탐색해야 하는 경우
                    bfs(graph,visited,n,cut,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void bfs(int[][] graph,int[][] visited, int n, int cut, int startX, int startY) {

        //☆큐! 자바에서 queue는 LinkedList를 사용한다
        //큐는 출력하려면 peek()로 맨 앞에거 출력 가능하고, 전체를 출력하고싶으면 whule문에서 iterator.hasNext() 써줘야 한다.
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});

        //시작점 방문 채크
        visited[startX][startY] = 1;

        //방향 (상,하,좌,우)
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[] curXY;
        int curX, curY, dirX, dirY, moveX, moveY;

        while (true) {
            if (queue.size() == 0) break;

            curXY = queue.remove();
            curX = curXY[0];
            curY = curXY[1];

            for (int i = 0; i < 4; i++) {
                dirX = dir[i][0];
                dirY = dir[i][1];

                moveX = curX + dirX;
                moveY = curY + dirY;

                if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= n) continue; //벽

                else if (graph[moveX][moveY] > cut && visited[moveX][moveY] == 0) { //탐색해야 하는 경우
                    //System.out.println(moveX+" "+moveY);
                    queue.add(new int[]{moveX, moveY});
                    visited[moveX][moveY] = 1;
                }
            }
        }
    }
}
