import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        String ans = (s.toLowerCase().charAt(0) == 'n') ? "Naver D2" : "Naver Whale";

        System.out.println(ans);
    }
}
