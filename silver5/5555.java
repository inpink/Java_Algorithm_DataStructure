import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String s= br.readLine();
        int n= Integer.parseInt(br.readLine());
        int ans=0;

        for (int i=0; i<n; i++){
            String ring=br.readLine();
            ring+=ring; //2배로 해주고

            if (ring.contains(s)) ans++;
        }

        System.out.println(ans);
    }

}
