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

        int n=Integer.parseInt(br.readLine());
        int sLen;
        String s;
        for (int i=0; i<n; i++) {
            s = br.readLine();
            sLen=s.length();

            if (s.charAt(sLen-1)!='.') s+=".";
            System.out.println(s);
        }

    }

}
