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

        Long n= Long.parseLong(br.readLine());

        //OUTPUT
        bw.write(Long.toString(n*(n-1)/2)+"\n");
        bw.write("2");
        bw.flush();
        bw.close();
    }

}
