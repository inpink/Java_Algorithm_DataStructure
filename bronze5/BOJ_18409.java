import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count=0;
        int n= Integer.parseInt(br.readLine());
        String s=br.readLine();

        //정규식 사용하여 찾기
        Pattern pattern = Pattern.compile("a|e|i|o|u");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            //System.out.println(matcher.group());
            count++;
        }

        //Output
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
