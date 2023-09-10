import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); //n=1~10
        int[] dp = new int[11];  //n=1일 때도 있기 때문에, 아래 dp[2]에서 에러 안뜨려면 최대 n=10일때를 고려하여 dp크기 11으로 주고 시작하기 
        //dp[1]=0;
        dp[2] = 1;
        
        for (int i = 3; i <= n; i++)  dp[i] =  dp[i-1] + (i-1);
       
        System.out.print(dp[n]);
    }
}
