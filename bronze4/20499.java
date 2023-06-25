import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String ans="";
        String[] arr=br.readLine().split("/");
        int k= Integer.parseInt(arr[0]);
        int d= Integer.parseInt(arr[1]);
        int a= Integer.parseInt(arr[2]);

        if (k+a<d || d==0) ans="hasu";
        else ans="gosu";

        //OUTPUT
        bw.write(ans);
        bw.flush();
        bw.close();
    }


}
