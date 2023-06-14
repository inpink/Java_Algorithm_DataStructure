import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int f=Integer.parseInt(st.nextToken());

        int minI=0;
        double restTime,minTime=10001f;
        for (int i=0; i<n; i++){
            StringTokenizer st2= new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st2.nextToken());
            float v=Float.parseFloat(st2.nextToken());

            restTime=  (f-x)/v; //올림안함
            //System.out.println(restTime);
            if (restTime<minTime){
                minTime=restTime;
                minI=i+1;
            }
        }
        //OUTPUT
        bw.write(Integer.toString(minI));
        bw.flush();
        bw.close();
    }

}
