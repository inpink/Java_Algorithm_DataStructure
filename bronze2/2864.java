import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());
        String a=st.nextToken();
        String b=st.nextToken();

        int minA,minB, maxA,maxB;

        minA=trans(a,'6','5');
        minB=trans(b,'6','5');
        maxA=trans(a,'5','6');
        maxB=trans(b,'5','6');

        //OUTPUT
        bw.write((minA+minB)+" "+(maxA+maxB));
        bw.flush();
        bw.close();
    }

    public static int trans(String s, char from, char to){
        StringBuilder sb= new StringBuilder();
        for (char c : s.toCharArray()){
            if (c==from) sb.append(to);
            else sb.append(c);
        }

        return  Integer.parseInt(sb.toString());
    }
}
