import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1]; //dp[a]는 1~a번째까지에서의 최댓값이 담김 

        StringTokenizer st= new StringTokenizer(br.readLine());

        for (int i=1; i<=n; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        //DP이용하여 O(n^2)로 해결
        for (int i=2; i<=n; i++){ //dp[i]에서 i는 하나의 그룹의 끝위치이자, 1~i번째에서의 최댓값이 담김 
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for (int j=i; j>=1; j--){ //줄어듬
                max=Math.max(max,arr[j]);
                min=Math.min(min,arr[j]);
                
                //dp[j-1] + (i~j모임을 하나로 봄)  //j-1를 쓰기 때문에 dp는 1번쨰부터 사용
                dp[i]=Math.max(dp[i],max-min+dp[j-1]); 
            }
        }

        System.out.println(dp[n]);


    }

}
