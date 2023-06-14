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

        int n= Integer.parseInt(br.readLine());

        int num;
        String strNum;
        for (int i=0; i<n; i++){
            StringBuilder ansNum=new StringBuilder();
            num=Integer.parseInt(br.readLine());
            num++;
            strNum= Integer.toString(num);
            for ( char c : strNum.toCharArray()) {
                if (c=='0') ansNum.append('1');
                else ansNum.append(c);
            }
            bw.write(ansNum.toString()+"\n");
        }

        //OUTPUT

        bw.flush();
        bw.close();
    }


}
