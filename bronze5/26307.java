import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int h=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int ans= (h-9)*60+m;

        System.out.println(ans);
    }
}
