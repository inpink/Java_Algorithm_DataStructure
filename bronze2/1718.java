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

     /*   System.out.println( (char) 97);
        System.out.println( (int) 'l' -97);
        System.out.println( (char) ('n' -11));
        System.out.println( (char) ( ('n' - 'l' + 25) % 26 + 97));
        System.out.println( (char) ( ('i' - 'o' + 25) % 26 + 97));
        System.out.println( (char) ( ('c' - 'v' + 25) % 26 + 97));
        System.out.println( (char) ( ('e' - 'e' + 25) % 26 + 97));*/

        String plain=br.readLine();
        String crypt=br.readLine();
        StringBuilder sb=new StringBuilder();

        int cryptN=crypt.length();

        int idx=0;
        for (char c : plain.toCharArray()){
            if (c==' ')  sb.append(' ');
            else sb.append((char) ( (c - crypt.charAt(idx)+ 25) % 26 + 97) );

            idx=(idx+1)%cryptN;
        }


       //Output
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
