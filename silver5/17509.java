import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] arr = new int[11];
        int wrong = 0, ans = 0, sum = 0;;
        
        for (int i = 0;  i < 11; i++) {
            String[] inputArr = br.readLine().split(" ");
            arr[i] = Integer.parseInt(inputArr[0]);
            wrong += Integer.parseInt(inputArr[1]);
        }
        
        Arrays.sort(arr); //정렬
        
        for (int i = 0; i < 11; i++) {
            sum += arr[i];
            ans += sum;
        }
          
        ans += (wrong*20);
        System.out.println(ans);
    }
}
