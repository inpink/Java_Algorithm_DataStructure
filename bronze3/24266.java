import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

interface Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        System.out.println(n * n * n);
        System.out.println(3);
    }
}
