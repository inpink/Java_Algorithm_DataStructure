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

        int n= Integer.parseInt(br.readLine());
        bw.write("Gnomes:"+"\n");
        for (int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());

            if (isOrdered(a,b,c)) bw.write("Ordered");
            else bw.write("Unordered");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }


    public static boolean isOrdered(int a, int b, int c){
        if (a<=b && b<=c) return true;
        else if (a>=b && b>=c) return true;
        else return false;
    }
}
