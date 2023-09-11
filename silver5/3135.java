import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());

        int n=Integer.parseInt(br.readLine());
        int[] frequencyArr=new int[n];
        int[] buttonCountArr=new int[n+1];
        OptionalInt ans;

        for (int i=0; i<n; i++){
            frequencyArr[i]= Integer.parseInt(br.readLine());
            buttonCountArr[i]= Math.abs( frequencyArr[i] - b) + 1; //텔레포트에 1회 필요
        }

        //텔레포트 안하고 하나씩 누르는 경우
        buttonCountArr[n]=Math.abs(a-b);

        ans= Arrays.stream(buttonCountArr).min();

        System.out.println( ans.getAsInt() );

    }



}
