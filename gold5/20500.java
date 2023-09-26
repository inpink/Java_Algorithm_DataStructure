import java.io.*;
import java.util.*;

public class Main {

     static int mod= 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());

        int[][] dp = new int[3][1516]; //dp[a][b]는 b자리수에서 3으로 나눈 나머지가 a인, 1의자리가 5인 수의 개수
        //정답은 n자리수에서 3으로 나눠서 나머지가 0인, 1의자리가 5인 수의 개수

        dp[0][2]=1;
        dp[1][2]=1;
        dp[2][2]=0;

        for (int i=3; i<=n; i++){
            dp[0][i]= (dp[1][i-1]+dp[2][i-1])%mod;
            dp[1][i]= (dp[2][i-1]+dp[0][i-1])%mod;
            dp[2][i]= (dp[0][i-1]+dp[1][i-1])%mod;
        }

        System.out.println(dp[0][n]);

    }

}
