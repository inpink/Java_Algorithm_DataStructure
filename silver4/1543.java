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


        String s1 = br.readLine();
        String s2 = br.readLine();

        int s1Start=0, s1Len=s1.length(), s2Len=s2.length();
        int ans=0,s1Stack=0, s2Stack=0;

        while (true){
            if (s1Stack==s1Len) break;

            //System.out.println(s1.substring(s1Start,s1Len)+"ㅇ"+s1.charAt(s1Stack)+" "+s2.charAt(s2Stack));

            if (s1.charAt(s1Stack)==s2.charAt(s2Stack)) {
                s1Stack++;
                s2Stack++;

                if (s2Stack==s2Len) {
                    s1Start=s1Stack; //앞에서 문자열이 만들어졌으면 여기까진 절대안씀
                    ans++;
                    s2Stack=0;
                }
            }
            else { //다른 문자열이면
                s1Start++; //앞에 하나 버림
                s1Stack=s1Start; //앞에서부터 다시 탐색
                s2Stack=0;
            }


        }

        //OUTPUT
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }
}
