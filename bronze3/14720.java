import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n= Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());

        int tmp, milk=0;

        for (int i=0; i<n; i++){
            tmp= Integer.parseInt(st.nextToken());
            if( tmp==(milk%3)) milk++;
        }

        //OUTPUT
        bw.write(Integer.toString(milk));
        bw.flush();
        bw.close();
    }


}
