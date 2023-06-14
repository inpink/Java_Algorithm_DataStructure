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
        StringBuilder ans = new StringBuilder();
        
        if (n==0) ans.append("1");
        else if (n==1) ans.append("0");
        else{
            if (n%2!=0) ans.append("4");
            for (int i=0; i<n/2; i++) ans.append("8");

        }
        //OUTPUT
        bw.write(ans.toString());
        bw.flush();
        bw.close();
    }

}
