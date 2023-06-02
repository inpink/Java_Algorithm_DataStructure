import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //map 선언하며 초기화하기
        HashMap<String,Float> map = new HashMap<String,Float>(){  
            {
                put("A+", 4.5f); //float는 f
                put("A0",4.0f);
                put("B+",3.5f);
                put("B0",3.0f);
                put("C+",2.5f);
                put("C0",2.0f);
                put("D+",1.5f);
                put("D0",1.0f);
                put("F",0.0f);
            } //중괄호 2번임
        };

        String name,grade;
        float time,gradeSum = 0, timeSum=0, ans;

        for (int i=0; i<20; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            name=st.nextToken();
            time=Float.parseFloat(st.nextToken());
            grade=st.nextToken();

            if (grade.equals("P")) continue;

            gradeSum+=(time*map.get(grade));
            timeSum+=time;
        }

       ///Output
        bw.write(Float.toString(gradeSum/timeSum));
        bw.flush();
        bw.close();
    }
}
