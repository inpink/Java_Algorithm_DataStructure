import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr=br.readLine().split(":");
        int a=Integer.parseInt(arr[0]);
        int b=Integer.parseInt(arr[1]);

        int gcd=GCD(a,b);

        //OUTPUT
        bw.write(a/gcd+":"+b/gcd);
        bw.flush();
        bw.close();
    }

    public static int GCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return GCD(num2, num1%num2);
    }


}
