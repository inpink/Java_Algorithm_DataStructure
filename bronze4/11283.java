import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*System.out.println( (int) '가' - 44031);
        System.out.println( (int) '힣' - 44031);
        System.out.println( (int) '백' - 44031);*/

        System.out.println( (int) br.readLine().charAt(0) - 44031);

        /*//OUTPUT
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();*/
    }


}
