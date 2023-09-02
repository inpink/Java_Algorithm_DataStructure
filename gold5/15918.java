import java.io.*;
import java.util.*;

public class Main {

    static int count=0;
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        int x= Integer.parseInt(st.nextToken());
        int y= Integer.parseInt(st.nextToken());
        int reserve=y-x-1;

        int[] arr= new int[n*2];
        boolean[] visited=new boolean[n+1];

        arr[x-1]=reserve;
        arr[y-1]=reserve;
        visited[reserve]=true;

        BackTracking(arr, visited,0);
        System.out.println(count);
    }


    public static void BackTracking(int[] arr, boolean[] visited, int depth){
        //System.out.println("백트래킹 시작"+Arrays.toString(arr)+" "+Arrays.toString(visited)+" "+depth);
        if (depth== n*2) {
            count++;
            return;
        }

        if (arr[depth]!=0){ //이미 값이 들어있으면 다음걸로 보내주기만
            //System.out.println(depth);
            BackTracking(arr,visited,depth+1);
        }

        else{
            //현재 depth번째 값을 채워야 함
            for (int i=1; i<=n; i++){
                //System.out.println("반복문안"+Arrays.toString(arr)+" "+Arrays.toString(visited)+" "+i+" "+depth);
                if (visited[i] ) continue;
                if (depth+i+1>=n*2) break;
                if (arr[depth+i+1]!=0) continue;

                arr[depth]=i;
                arr[depth+i+1]=i;
                visited[i]=true;
                BackTracking(arr,visited,depth+1);
                arr[depth]=0;
                arr[depth+i+1]=0;
                visited[i]=false;

            }
        }



    }

}
