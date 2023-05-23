import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main { //class명 Main 필수
    public static void main(String[] args)  throws IOException { //예외 처리 필수
        //40분 소요 
        
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int m= Integer.parseInt(st.nextToken());
        int n= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());

        //☆좌표 시작점이 왼쪽 아래이므로, m,n이 아닌 n,m으로 둠
        int[][] graph=new int[n][m];
        int x0,y0, x1, y1, size;
        List<Integer> list = new ArrayList<>();

        for (int a=0; a<k; a++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            x0 = Integer.parseInt(st1.nextToken());
            y0 = Integer.parseInt(st1.nextToken());
            x1 = Integer.parseInt(st1.nextToken());
            y1 = Integer.parseInt(st1.nextToken());

            square(graph,x0,y0,x1,y1,m);
        }

        /*for (int i=0; i<n;i++){
            System.out.println(Arrays.toString(graph[i]));
        }*/

        bfs_candi(list,graph,n,m);
        size=list.size();
        Collections.sort(list);

        //OUTPUT
        bw.write(Integer.toString(size));
        bw.write("\n");

        for (int i=0; i<size; i++) bw.write(list.get(i)+" ");
        bw.flush(); bw.close();
    }

    //사각형 범위 표시하는 method
    //왼쪽 아래, 오른쪽 위라고 정해줬으므로 x0<=x1, y0<=y1
    public static void square(int[][] graph, int x0, int y0, int x1, int y1, int m){

        for (int i=x0; i<x1; i++){
            for (int j=y0; j<y1; j++){
                graph[i][j]++;
            }
        }
    }

    public static void bfs_candi(List<Integer> list, int[][] graph,  int n, int m){

        int[][] visited= new int[n][n];

        int count=0;

        for( int i=0; i<n; i++){
            for (int j=0; j<m; j++) {
                if (graph[i][j]==0 && visited[i][j] == 0) { //탐색해야 하는 경우
                    //System.out.println(i+" "+j);
                    list.add(bfs(graph,visited,n,m,i,j));
                }
            }
        }
    }

    public static int bfs(int[][] graph,int[][] visited, int n, int m, int startX, int startY) {
        //System.out.println("시작"+startX+" "+startY);

        int count=1; //★ 최소 turn을 구하는 게 아니라, 방문한 모든 장소를 구하는 것이므로, 전역으로 체크하면 됨
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});

        //시작점 방문 채크
        visited[startX][startY] = 1;

        //방향 (상,하,좌,우)
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[] curXYC;
        int curX, curY, dirX, dirY, moveX, moveY;

        while (true) {
            if (queue.size() == 0) return count;

            curXYC = queue.remove();
            curX = curXYC[0];
            curY = curXYC[1];

            for (int i = 0; i < 4; i++) {
                dirX = dir[i][0];
                dirY = dir[i][1];

                moveX = curX + dirX;
                moveY = curY + dirY;

                if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= m) continue; //벽

                else if (graph[moveX][moveY]==0 && visited[moveX][moveY] == 0) { //탐색가능한 곳을 만났다면
                    count++; //무조건 방문할 수 있다는 것이므로 count++
                    //System.out.println(moveX+" "+moveY+" "+(count+1));
                    queue.add(new int[]{moveX, moveY});
                    visited[moveX][moveY] = 1;
                }
            }
        }

    }
}
