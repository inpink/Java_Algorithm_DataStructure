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

        int t=1;
        while (true) {
            //Union-Find

            Set<Integer> ansSet = new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            if (n==0) break; //종료조건

            int[] arr = new int[n];
            int[][] graph = new int[n][2]; //x,y좌표 담음
            for (int i = 0; i < n; i++) {
                arr[i] = i; //집합 초기화

                //좌표 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                graph[i][0] = Integer.parseInt(st.nextToken());
                graph[i][1] = Integer.parseInt(st.nextToken());
            }

            //가장 가까운 이웃들과 집합 통합
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arrayList = findNeighborList(graph, i);

                for (int j : arrayList) arr[find(arr, i)] = find(arr, j);
            }

            //merge후 정답 출력
            for (int i = 0; i < n; i++) ansSet.add(find(arr,i));
            System.out.println("Sky " + t++ + " contains " + ansSet.size() + " constellations.");

        }
        /*//OUTPUT
        bw.write(Integer.toString(ansSet.size()));
        bw.flush();
        bw.close();*/
    }

    public static int find(int[] arr, int num){

        if (arr[num]==num) return num;

        arr[num]= find(arr,arr[num]); //★ 탐색하는 과정에서 부모들을 같이 업데이트 시켜주자!
        return arr[num];
    }

    public static ArrayList<Integer> findNeighborList(int[][] graph, int cur){
        ArrayList<Integer> arrayList = new ArrayList<>();

        //(a,b) (c,d)면 ☆거리를 abs(a-b)+abs(c-d)로 함!
        int curDis, minDis=2001; //0,0부터 1000,1000까지 최대 차이 2000
        int curX,curY;
        curX=graph[cur][0];
        curY=graph[cur][1];

        for (int i=0; i<graph.length; i++){
            if (i==cur) continue; //자기자신은 빼고 검사

            curDis= Math.abs(curX-graph[i][0]) + Math.abs(curY-graph[i][1]);
            if (curDis<minDis){
                arrayList.clear(); //지울 때 clear가 더 빠르다
                arrayList.add(i);
                minDis=curDis;
            }
            else if (curDis==minDis){
                arrayList.add(i);
            }
        }

        return  arrayList;
    }

}
