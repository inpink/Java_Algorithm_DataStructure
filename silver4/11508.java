import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main { //class명 Main 필수
    public static void main(String[] args) throws IOException { //예외 처리 필수

        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n= Integer.parseInt(br.readLine());
        int ans=0, mod=n%3;
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i]= Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        //그냥 다더해서 뺄거만 빼면됨
        ans=Arrays.stream(arr).sum();

        for (int i=mod; i<n; i+=3) ans-=arr[i];

        //OUTPUT
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }


}
