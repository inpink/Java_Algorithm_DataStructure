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

        int max=0, maxI=0;
        for (int i=0; i<5;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int sum=0;
            for (int j=0; j<4;j++) sum+=Integer.parseInt(st.nextToken());

            if (max<sum){
                max=sum;
                maxI=i;
            }
        }

        //OUTPUT
        bw.write((maxI+1)+" "+max);
        bw.flush();
        bw.close();
    }



}
