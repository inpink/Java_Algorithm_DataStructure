import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb= new StringBuilder();
        StringTokenizer st0=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st0.nextToken());
        int m=Integer.parseInt(st0.nextToken());
        int a,b;

        int[][] subject= new int[m][2];
        int[] dp = new int[n+1]; //DP로 풀음

        //입력 담아두기
        for (int i=0; i<m; i++){
            StringTokenizer st1=new StringTokenizer(br.readLine());

            a=Integer.parseInt(st1.nextToken());
            b=Integer.parseInt(st1.nextToken());

            subject[i][0]=a;
            subject[i][1]=b;
        }

        //정렬하여 작은것부터 계산해야 DP가능
        //2차원 배열을 첫 번째 열을 기준으로 오름차순, 두 번째 열을 기준으로 오름차순 정렬
        Arrays.sort(subject, (left, right) -> {
            if (left[0] == right[0]) {
                return Integer.compare(left[1], right[1]);
            }
            return Integer.compare(left[0], right[0]);
        });


        //앞에서부터 dp값 계산
        for (int i=0; i<m; i++){
            a=subject[i][0];
            b=subject[i][1];

            if (dp[a]>=dp[b]){
                dp[b]=dp[a]+1;
            }
        }


        //출력
        for (int i=1; i<=n; i++){
            sb.append(dp[i]+1);
            sb.append(" ");
        }

        System.out.println(sb.toString());


    }
}
