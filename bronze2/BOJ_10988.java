import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main { //class명 Main 필수
    public static void main(String[] args)  throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s= br.readLine();
        String ans="1";
        int n= s.length();
        int half= (int) Math.ceil(n/2.0);

        //System.out.println(half);
        
        for (int i=0; i<half; i++) {
            if(s.charAt(i)!= s.charAt(n-1-i)) {
                ans="0";
                break;
            }
        }

        bw.write(ans);
        bw.flush();
        bw.close();
    }

}
