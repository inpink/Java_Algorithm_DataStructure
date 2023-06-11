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

        String s=br.readLine()+"."; //.을 넣어서 마지막에 XXXX나 XX나 XXX가 있는 경우 등을 탐지할 수 있게
        int n=s.length()-1;
        StringBuilder sb= new StringBuilder();
        boolean noAns=false;

        int xCount=0;
        for ( char c : s.toCharArray()){
            if (c=='.') {

                if (isOdd(sb,xCount)) {
                    noAns=true;
                    break; //홀수
                }

                isTwo(sb,xCount); //2개
                xCount=0;
                sb.append('.');
            }

            else {
                xCount++;

                if (isFour(sb,xCount)){
                    xCount=0;
                }
            }
        }


        //OUTPUT
        if (noAns==true) bw.write(sb.toString());
        else bw.write(sb.substring(0,n)); //마지막에 . 뺴고 출력
        bw.flush();
        bw.close();
    }

    public static boolean isOdd (StringBuilder sb, int xCount){ //SB는 객체 참조 가능

        if (xCount%2!=0) { //홀수는 못만들음
            sb.setLength(0);
            sb.append(-1);
            return true;
        }

        return false;
    }


    public static void isTwo (StringBuilder sb, int xCount){
        if(xCount==2) {
            sb.append("BB");
        }
    }

    public static boolean isFour (StringBuilder sb, int xCount) {

        if (xCount==4) {
            sb.append("AAAA");
            return true;
        }
        return false;
    }


}
