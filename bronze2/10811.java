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


        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr= new int[n+1];
        for (int i=1; i<=n; i++) arr[i]=i; //초기화

        for (int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            reverseArr(arr,start,end);
        }

        //OUTPUT
        for (int i=1; i<=n; i++) bw.write(Integer.toString(arr[i])+" ");
        bw.flush();
        bw.close();
    }

    public static void reverseArr(int[] arr, int start, int end){
        int n= end-start;
        int[] tmpArr= new int[n+1];

        for (int i=start; i<=end; i++) tmpArr[n--]=arr[i];
        for (int i=start; i<=end; i++) arr[i]=tmpArr[i-start];

    }

}
