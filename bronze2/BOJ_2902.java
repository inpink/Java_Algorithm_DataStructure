import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 5, max = 0;
        StringBuilder sb= new StringBuilder();
        String[] l = br.readLine().split("-");

        for (int i=0; i<l.length; i++) sb.append(l[i].charAt(0));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
