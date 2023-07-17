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

        //DATA
        int[][] graph = new int[101][101]; //100x100
        int n=4;
        int ans=0;
        for (int i=0; i<n; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            for (int x=x1; x<x2; x++){
                for (int y=y1; y<y2; y++){
                    graph[x][y]++;
                }
            }
        }

        for (int i=1; i<=100; i++) {
            for (int j=1; j<=100; j++) {
                if (graph[i][j]>=1) ans++;
            }
        }
        //OUTPUT
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }


}
