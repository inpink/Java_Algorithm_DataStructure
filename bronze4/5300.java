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

        int n=Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int i=1; i<=n; i++) {
            sb.append(i+" ");
            if (i%6==0) sb.append("Go! ");
        }

        if (n%6!=0) sb.append("Go!"); //n이 6의 배수면 마지막에 GO가 있으니까 더 안넣음

        //Output
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}
