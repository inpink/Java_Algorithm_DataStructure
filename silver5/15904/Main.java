import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine(); //문자열 입력. 문자의 맨 첫번째만 사용하는게 아니라, 모든 문자를 사용한다.
        // 그래서 split안하고 String s로 받음

        char[] ucpc = {'U', 'C', 'P', 'C'};
        int index = 0;
        int sLen=s.length();
        boolean isPossible=false;
        String ans="";

        for(int i=0; i<sLen; i++) {
            if(s.charAt(i) == ucpc[index]) index++;  //포인터로 하나씩 가리키기!

            if(index == 4) { //UCPC 문자열 완성되면 완성 체크하고, 더 탐색할 필요 없음!
                isPossible=true;
                break;
            }
        }

        if (isPossible) ans="I love UCPC";
        else ans="I hate UCPC";
        //ans = (isPossible) ? "I love UCPC": "I hate UCPC"; //3항 연산자 이용해도 됨

        bw.write(ans);
        bw.flush();
        bw.close();

    }


}
