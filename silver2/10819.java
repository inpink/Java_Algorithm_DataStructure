import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main { //class명 Main 필수

    public static int max=0;

    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n= Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer=new StringTokenizer(br.readLine());
        int[] arr= new int[n];

        for (int i=0; i<n; i++) arr[i]=Integer.parseInt(stringTokenizer.nextToken());

        perm(arr, new int[n],new boolean[n] , 0, n);

        //OUTPUT
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n)  {
        if (depth == n) {

            int sum=0;
            for (int i=1;i<n;i++) sum+=Math.abs(output[i]-output[i-1]);
            max=Math.max(max,sum);

            //System.out.println(Arrays.toString(output));
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n);
                visited[i] = false;;
            }
        }

    }


}
