import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long dp[] = new long[36]; //dp문제임. 문제에서 요구한대로 이전dp값 사용하는 점화식. n=35까지. long범위.
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < 36; i++) { //dp 미리 만들어놓기.
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i-1-j]);
            }
        }
        System.out.println(dp[n]);
    }
}
