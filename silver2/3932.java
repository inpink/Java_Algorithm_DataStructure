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

        /*
        J : 메시지의 모든 문자를 왼쪽으로 하나씩 회전시킵니다. 예 "aB23d" -> "B23da"
        C : 메시지의 모든 문자를 오른쪽으로 하나씩 회전시킵니다.  예  "aB23d"-> "daB23"
        E : 메시지의 왼쪽 절반을 오른쪽 절반과 바꿉니다. 메시지의 문자 수가 홀수이면 가운데 메시지는 이동하지 않습니다.
           예 "e3ac" -> "ace3"   "aB23d" -> "3d2aB"
        A : 메시지를 뒤집는다. 예  "aB23d" -> "d32Ba"
        P : 메시지의 모든 숫자를 하나씩 증가시킵니다. 숫자가 '9'이면 '0'이 됩니다. 알파벳 문자는 변경되지 않습니다
           예  "aB23d" -> "aB34d"
        M : 메시지의 모든 숫자를 하나씩 감소시킵니다. 숫자가 '0'이면 '9'가 됩니다. 알파벳 문자는 변경되지 않습니다
           예  "aB23d" -> "aB12d"
         */

        // 원본 메세지로 복원하는 것이기에, 거꾸로 구현하면 됨

        String[] members;
        String s;

        int n= Integer.parseInt(br.readLine().replace(" ","")); //공백 제거가 필요하네
        for (int i=0; i<n; i++ ){

            members=br.readLine().replace(" ","").split("");
            s=br.readLine().replace(" ","");

            for (int j=members.length-1; j>=0; j--){
                switch (members[j]){
                    case "J":
                        s=resJ(s); break;
                    case "C":
                        s=resC(s); break;
                    case "E":
                        s=resE(s); break;
                    case "A":
                        s=resA(s); break;
                    case "P":
                        s=resP(s); break;
                    case "M":
                        s=resM(s); break;
                }
                //System.out.println("members[j] : "+ members[j]+ ", S : "+s);
            }
            //System.out.println("정답:"+s+"\n");
            System.out.println(s);
        }



        /*//OUTPUT
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();*/
    }

    //메시지의 모든 문자를 오른쪽으로 하나씩 회전시킵니다.  예  "aB23d"-> "daB23"
    public static String resJ(String s){
        StringBuilder sb=  new StringBuilder();
        int n= s.length();

        sb.append(s.charAt(n-1)); //맨뒤에거 먼저 넣고
        for (int i=0; i<n-1; i++) sb.append(s.charAt(i));//나머지 순서대로 넣기

        return sb.toString();
    }


    //메시지의 모든 문자를 왼쪽으로 하나씩 회전시킵니다. 예 "aB23d" -> "B23da"
    public static String resC(String s){
        StringBuilder sb=  new StringBuilder();
        int n= s.length();

        for (int i=1; i<n; i++) sb.append(s.charAt(i));//1번째부터 끝까지 먼저 넣고
        sb.append(s.charAt(0)); //맨앞문자 마지막에 넣기


        return sb.toString();
    }


    //메시지의 왼쪽 절반을 오른쪽 절반과 바꿉니다. 메시지의 문자 수가 홀수이면 가운데 메시지는 이동하지 않습니다.
    //예 "e3ac" -> "ace3"   "aB23d" -> "3d2aB"
    public static String resE(String s){
        StringBuilder sb=  new StringBuilder();
        int n= s.length();
        int half=n/2;
        int leftEndIdx=half-1;
        int rightStartIdx=n-half;

        for (int i=rightStartIdx; i<n;i++) sb.append(s.charAt(i)); //오른쪽 절반 먼저 넣고
        if (n%2==1) sb.append(s.charAt(half)); //홀수면 가운데 넣고
        for (int i=0; i<=leftEndIdx; i++ ) sb.append(s.charAt(i)); //왼쪽 절반 넣고

        return sb.toString();
    }


    //메시지를 뒤집는다. 예  "aB23d" -> "d32Ba"
    public static String resA(String s){
        StringBuffer sb= new StringBuffer(s); //StringBuffer class 이용하여 문자열 뒤집기 메소드 이용
        return sb.reverse().toString();
    }


    //메시지의 모든 숫자를 하나씩 감소시킵니다. 숫자가 '0'이면 '9'가 됩니다. 알파벳 문자는 변경되지 않습니다
    //예  "aB23d" -> "aB12d"
    public static String resP(String s){
        StringBuilder sb=  new StringBuilder();

        int n= s.length();
        char curC;
        String curS;
        int transI;

        for (int i=0; i<n; i++){
            curC=s.charAt(i);
            curS=String.valueOf(curC);
            if (isNumeric(curS)) {
                transI= ( Integer.parseInt(curS) + 10 -1 ) % 10;
                sb.append(transI);
            }
            else sb.append(curS);
        }

        return sb.toString();
    }


    //메시지의 모든 숫자를 하나씩 증가시킵니다. 숫자가 '9'이면 '0'이 됩니다. 알파벳 문자는 변경되지 않습니다
    //예  "aB23d" -> "aB34d"
    public static String resM(String s){
        StringBuilder sb=  new StringBuilder();

        int n= s.length();
        char curC;
        String curS;
        int transI;

        for (int i=0; i<n; i++){
            curC=s.charAt(i);
            curS=String.valueOf(curC);
            if (isNumeric(curS)) {
                transI= ( Integer.parseInt(curS) + 1 ) % 10;
                sb.append(transI);
            }
            else sb.append(curS);
        }

        return sb.toString();
    }


    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
