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

        int n = 5, max = 0;
        String[] l = new String[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            l[i] = br.readLine();
            max = Math.max(max, l[i].length());
        }


        for (int i = 0; i < max; i++) {//열
            for (int j = 0; j < n; j++) { //행은 n=5로 고정
                if (l[j].length()<=i) continue;
                sb.append(l[j].charAt(i));
                //System.out.println(i+" "+j);
            }

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
