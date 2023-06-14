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

        String strN=br.readLine();
        int intN=Integer.parseInt(strN);
        int extraCount=0;

        for (int i=0; i<intN; i++){
            if (Integer.toString(i).contains("50")) //들어있는지
                extraCount++;
        }

        //OUTPUT
        bw.write(Integer.toString(intN+extraCount));
        bw.flush();
        bw.close();
    }

}
