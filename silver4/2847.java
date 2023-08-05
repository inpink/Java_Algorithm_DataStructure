import java.io.*;
import java.util.*;

public class Main{
    
    static int n;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(br.readLine()); 

        int ans = 0;
        for (int i = n - 1; i >= 1; i--) {
            if (arr[i] >= arr[i + 1]) {
                ans += arr[i] - arr[i + 1] + 1;
                arr[i] = arr[i + 1] - 1;
            }
        }
        
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }
}
