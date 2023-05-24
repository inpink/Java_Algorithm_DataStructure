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
        
        /* 정규식 1
        String str3 = "1 + 2 = 3";
        Pattern p2 = Pattern.compile("[0-9]+");
        Matcher m2 = p2.matcher(str3);

        while (m2.find()) {
            System.out.println(m2.group()); //1  2  3
        }
        */
        
        /* 정규식 2
        String txt4 = "1 + 2 = 3";
        String[] txts2 = txt4.split("[+= ]+"); //  +,=,' '을 기준으로 분할. +을 달아줬기에 +=  이 여러 개 올수있음을 알려줌 
        System.out.println(txts2[0]); //1
        System.out.println(txts2[1]); //2
        System.out.println(txts2[2]); //3
        */

        bw.flush(); bw.close();
    }

}
