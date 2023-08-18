import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());

        int result = 0;

        for(int i = 0; i < n; i++) {
            int a = Math.abs(Integer.parseInt(st1.nextToken()));
            int b = Math.abs(Integer.parseInt(st2.nextToken()));
            result += (a+b);
        }

        System.out.println(result);
    }

}
