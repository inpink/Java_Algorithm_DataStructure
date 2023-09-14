import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans=0;
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] arr=new int[n+1];

        for (int i = 1; i <= n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for (int r = n-3; r >=1; r--)
        {
            int sum_i = 1;
            for (int i = 1; i <= r; i++)
            {
                int sum_j = 1;
                sum_i *= arr[i];
                for (int j = i+1; j <= n - 2; j++)
                {
                    sum_j *= arr[j];
                    int sum_k = 1;
                    for (int k = j+1; k <= n - 1; k++)
                    {
                        sum_k *= arr[k];
                        int sum_p = 1;
                        for (int p = k+1; p <= n; p++)
                        {
                            sum_p *= arr[p];
                        }
                        ans = Math.max(ans, (sum_i + sum_j + sum_k + sum_p) );
                    }
                }
            }
        }

        System.out.println(ans);

    }


}
