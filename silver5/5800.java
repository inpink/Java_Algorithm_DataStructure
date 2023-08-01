import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t= Integer.parseInt(br.readLine());

        for (int i=1; i<=t; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());

            int[] arr= new int[n];

            //입력
            for (int j=0; j<n; j++) arr[j]=Integer.parseInt(st.nextToken());

            Arrays.sort(arr);
            int max=arr[n-1];
            int min=arr[0];
            int gap=0;

            for (int j=0; j<n-1; j++) gap=Math.max(gap,arr[j+1]-arr[j]);

            bw.write("Class "+i+"\n");
            bw.write("Max "+max+", Min "+min+", Largest gap "+gap+"\n");

        }

        bw.flush();
        bw.close();
    }



}
