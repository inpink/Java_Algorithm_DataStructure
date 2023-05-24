import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.regex.Pattern;

public class Main { //class명 Main 필수
    public static void main(String[] args)  throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s= br.readLine();
        String[] array=s.split(" "); //☆단순히 공백으로만 잘라줘도 되는 문제임
        //System.out.println(Arrays.toString(array));

        if (Integer.parseInt(array[0]) + Integer.parseInt(array[2]) == Integer.parseInt(array[4])) bw.write("YES");
        else bw.write("NO");


        bw.flush(); bw.close();
    }

}
