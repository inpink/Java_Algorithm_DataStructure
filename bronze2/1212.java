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

        String A=br.readLine();
      
        //Main Logic
        if (A.equals("0")) { //0은 예외임
            System.out.println(0);
            return;
        };

        StringBuilder sb= new StringBuilder();
        String[] eightToTwo= {"000", "001", "010","011","100","101","110","111"};

        //★8진수 한자리는 2진수 3자리다★
        for (int i=0; i<A.length(); i++){
            sb.append(eightToTwo[A.charAt(i)-'0']); //char to int
        }
        
        //앞에 0이 있으면 없애줘야 한다
        String twoS=sb.toString();
        int idx=0;
        int n=sb.length();
        while(true){
            if (twoS.charAt(idx)=='1') break;
            idx++;
        }

        //OUTPUT
        bw.write(sb.substring(idx,n));
        bw.flush();
        bw.close();
    }

}
