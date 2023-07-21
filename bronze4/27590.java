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

        StringTokenizer st= new StringTokenizer(br.readLine());
        int ds=Integer.parseInt(st.nextToken());
        int ys=Integer.parseInt(st.nextToken());

        StringTokenizer st2= new StringTokenizer(br.readLine());
        int dm=Integer.parseInt(st2.nextToken());
        int ym=Integer.parseInt(st2.nextToken());

        int rest1=ys-ds;
        int rest2=ym-dm;
        while (true){ //1 1, 3 3 같은 경우나 3 3 1 10같은 경우(y-d가 0이 나오는 경우)떄문에 gcd아닌 brute force써야 함 
            if (rest1==rest2) break;

            if (rest1>rest2) rest2+=ym;
            else rest1+=ys;
        }
        //OUTPUT
        bw.write(Integer.toString(rest1));
        bw.flush();
        bw.close();
    }



}
