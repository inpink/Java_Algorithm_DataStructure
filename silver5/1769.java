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

        String str=br.readLine();
        String ans="";
        int count=0;

        while (true){
            if(str.length()==1) {
                int n=Integer.parseInt(str);
                if (n%3==0) ans="YES";
                else ans="NO";
                break;
            }

            count++;

            int sum=0;
            for (int i=0; i<str.length(); i++){
                char oneChr=str.charAt(i);
                int oneNum=oneChr-'0'; //char to int
                sum+=oneNum;
            }

            str=Integer.toString(sum);
            //System.out.println(str);
        }

        //OUTPUT
        bw.write(count+"\n"+ans);
        bw.flush();
        bw.close();
    }

    public static void twoToEight(ArrayList<String> arr,String subString){

        //System.out.println(subString);
        int twoToTen=Integer.parseInt(subString,2);
        //System.out.println(twoToTen);
        String tenToEight=Integer.toOctalString(twoToTen);
        arr.add(tenToEight);

    }

}
