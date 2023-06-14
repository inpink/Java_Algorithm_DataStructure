import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s=br.readLine();

        HashSet<Character> set = new HashSet<>() {{
           add('I'); add('O'); add('S'); add('H'); add('Z'); add('X'); add('N');
        }};

        String ans="YES";

        for ( char c : s.toCharArray() ) {
            if (!set.contains(c)) {
                ans="NO";
                break;
            }
        }

        //OUTPUT
        bw.write(ans);
        bw.flush();
        bw.close();
    }


}
